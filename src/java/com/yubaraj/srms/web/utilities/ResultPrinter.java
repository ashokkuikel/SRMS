package com.yubaraj.srms.web.utilities;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.yubaraj.srms.web.DTO.ResultsDTO;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Yubaraj
 */
public class ResultPrinter {

    public static File print(String studentName, String course, String rollNo, List<ResultsDTO> resultList, String totalMarks, String percent, String status) {

//        rollNumberLabel.setText(searchParameter);
//        studentNameLabel.setText(student.getFirstName() + " " + student.getMiddleName() + " " + student.getLastName());
//        courseNameLabel.setText(student.getCourseName());
//        Double totalObtainedMarks = yubarajSmsManager.getSumOfObtainedMarksByStudentId(new Long(searchParameter), logger);
//        Double totalFullMarks = yubarajSmsManager.getSumOfTotalFullMarksByStudentId(new Long(searchParameter), logger);
//        totalMarksLabel.setText(totalObtainedMarks.toString());
//        parcentagesLabel.setText(calculatePercent(totalFullMarks, totalObtainedMarks));
//        List<Marks> marksList = yubarajSmsManager.getAllActiveMarksListByStudentId(new Long(searchParameter), logger);
//        boolean isPassed = isPassed(marksList);
//        if (isPassed) {
//            resultLabel.setText(Constant.PASSED + " !");
//        } else {
//            resultLabel.setText(Constant.FAILLED + " !");
//        }
        Document document = new Document();
        try {
            
            File file=new File("MarkSheet_"+rollNo+".pdf");
            
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Image image = Image.getInstance("LBEF.png");
            image.scaleAbsolute(450, 50);
            document.add(image);

            Paragraph markSheet = new Paragraph("Mark Sheet", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLUE));
            markSheet.setAlignment(Element.ALIGN_CENTER);
            document.add(markSheet);

            Paragraph generatedOn = new Paragraph("Date : " + DateFormatter.getDate(new Date(), "dd-MM-yyyy"), FontFactory.getFont(FontFactory.COURIER, 10, Font.BOLD, BaseColor.RED));
            generatedOn.setAlignment(Element.ALIGN_RIGHT);
            document.add(generatedOn);

            document.add(new Paragraph("Student Name : " +studentName ));
            document.add(new Paragraph("Roll Number   : " + rollNo));
            document.add(new Paragraph("Course Name  : " + course));

            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(5);

//            PdfPCell cell=new PdfPCell();
            PdfPCell subjectCell = new PdfPCell(new Paragraph("Subject Name"));
            PdfPCell fullMarksCell = new PdfPCell(new Paragraph("Full Marks"));
            PdfPCell passMarksCell = new PdfPCell(new Paragraph("Pass Marks"));
            PdfPCell obtainedMarksCell = new PdfPCell(new Paragraph("Obtained Marks"));
            PdfPCell statusCell = new PdfPCell(new Paragraph("Status"));

            subjectCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            subjectCell.setBackgroundColor(BaseColor.GREEN);

            fullMarksCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            fullMarksCell.setBackgroundColor(BaseColor.GREEN);

            passMarksCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            passMarksCell.setBackgroundColor(BaseColor.GREEN);

            obtainedMarksCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            obtainedMarksCell.setBackgroundColor(BaseColor.GREEN);

            statusCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            statusCell.setBackgroundColor(BaseColor.GREEN);
            /**
             * *adding table column name on table
             */
            table.addCell(subjectCell);
            table.addCell(fullMarksCell);
            table.addCell(passMarksCell);
            table.addCell(obtainedMarksCell);
            table.addCell(statusCell);
            /**
             * Adding mark sheets on the table
             */
            if (resultList != null && resultList.size() > 0) {
                for (ResultsDTO marks : resultList) {
                    table.addCell(marks.getSubjectName());
                    table.addCell(marks.getFullMarks().toString());
                    table.addCell(marks.getPassMarks().toString());
                    table.addCell(marks.getMarksValue().toString());
                    table.addCell(status);
                }
            }
            //adding table on the document
            document.add(table);

            document.add(new Paragraph("\n"));
            /**
             * Adding result summary
             */

            Paragraph totalMarksParagraph = new Paragraph("Total Marks:  " + totalMarks);
            totalMarksParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(totalMarksParagraph);

            Paragraph percentParagraph = new Paragraph("Percent:      " + percent);
            percentParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(percentParagraph);

            Paragraph statusParagraph = new Paragraph("Result:   " + status);
            statusParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(statusParagraph);

            /**
             * BarCode
             */
            PdfContentByte cb = writer.getDirectContent();
            BarcodeEAN codeEAN = new BarcodeEAN();
            codeEAN.setCode("123456789000");
            Paragraph barCodeParagraph = new Paragraph();
            codeEAN.setCodeType(BarcodeEAN.UPCA);
            codeEAN.setCode("098765432111");
            document.add(codeEAN.createImageWithBarcode(cb, BaseColor.BLACK, BaseColor.BLACK));
            document.add(barCodeParagraph);
            document.close();
            System.out.println("Result Printed on D Drive as MarkSheet.pdf");
            
            return file;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
    }

    private void displayResult(PdfWriter pdfWriter) {
        try {
            InputStream iss = getClass().getResourceAsStream("/MarkSheet.pdf"); //update the filename here when the help guide is written
            byte[] data = IOUtils.toByteArray(iss);
            iss.read(data);
            iss.close();
            String tempFile = "User_Guide";
            File temp = File.createTempFile(tempFile, ".pdf");
            FileOutputStream fos = new FileOutputStream(temp);
            fos.write(data);
            fos.flush();
            fos.close();
//            logger.error(temp.getAbsolutePath());
            Desktop.getDesktop().open(temp.getAbsoluteFile());
        } catch (IOException ex) {
//            logger.error(ex);
            JOptionPane.showMessageDialog(null, "File is not opening. Please check whether\n PDF reader is installed or not\n and try again.", "Warning !", JOptionPane.WARNING_MESSAGE);
        }
    }
}

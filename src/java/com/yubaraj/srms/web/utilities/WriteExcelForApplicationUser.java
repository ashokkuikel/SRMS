package com.yubaraj.srms.web.utilities;

import com.yubaraj.srms.web.DTO.ApplicationUserDTO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class WriteExcelForApplicationUser {

    private WritableCellFormat timesBoldUnderline;
    private WritableCellFormat times;
    private String inputFile1;
    private File inputFile;
    String[] dataAbcd;

    public WriteExcelForApplicationUser() {
    }

//    public WriteExcelForApplicationUser(String column[], List<ApplicationUserDTO> reportList) {
//        try {
////            JFileChooser chooser = new JFileChooser();
////            chooser.setDialogTitle("Save Report");
////            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
////            chooser.setCurrentDirectory(new File("."));
//
//            
////            chooser.setSelectedFile(inputFile);
////            int result = chooser.showSaveDialog(null);
////
////            if (result == JFileChooser.CANCEL_OPTION) {
////                return;
////            } else if (result == JFileChooser.APPROVE_OPTION) {
////
////                if (inputFile == null) {
////                    chooser.setSelectedFile(inputFile);
////                    chooser.updateUI();
////                }
////                inputFile = chooser.getSelectedFile();
////                if (inputFile.getName().endsWith(".xls")) {
////                    setOutputFile(new File(inputFile + ""));
////                } else {
////                    setOutputFile(new File(inputFile + ".xls"));
////                }
//
//             File file=   write(column, reportList);
//                System.out.println("\nReport generated as " + inputFile);
////                JOptionPane.showMessageDialog(null, "Report Successfully Exported", "Successfull !", JOptionPane.INFORMATION_MESSAGE);
//
////            } else {
////                System.out.println("Sorry Something wrong. \n Please see log file for more details");
////            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }
//        
//    }
    public void setOutputFile(String inputFile1) {
        this.inputFile1 = inputFile1;
    }

    public void setOutputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public File write(String[] column, List<ApplicationUserDTO> reportLst) throws IOException, WriteException {
        try {

            Calendar cal = Calendar.getInstance();
            //yyyy-MM-dd-HH:mm:ss
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            String date = sdf.format(cal.getTime());
            inputFile = new File(date + ".xls");
            System.out.println("\nRequested to generate report at " + inputFile);

//            
//            File file=   write(column, reportList);
//                System.out.println("\nReport generated as " + inputFile);
            File file = inputFile;
            WorkbookSettings wbSettings = new WorkbookSettings();

            wbSettings.setLocale(new Locale("en", "EN"));

            WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
            workbook.createSheet("Report", 0);
            WritableSheet excelSheet = workbook.getSheet(0);
            createLabel(excelSheet, column, reportLst);
            createContent(excelSheet);

            workbook.write();
            workbook.close();

            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void createLabel(WritableSheet sheet, String[] column, List<ApplicationUserDTO> reportList)
            throws WriteException {
        try {

            WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);

            times = new WritableCellFormat(times10pt);

            times.setWrap(true);

            WritableFont times10ptBoldUnderline = new WritableFont(
                    WritableFont.TIMES, 10, WritableFont.BOLD, false,
                    UnderlineStyle.SINGLE);
            timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);

            timesBoldUnderline.setWrap(true);

            CellView cv = new CellView();
            cv.setFormat(times);
            cv.setFormat(timesBoldUnderline);
            cv.setAutosize(true);

            for (int i = 0; i < column.length; i++) {
                addCaption(sheet, i, 0, column[i]);
            }

            for (int i = 0; i < reportList.size(); i++) {
                for (int j = 0; j < 6; j++) {
                    switch (j) {
                        case 0:
                            addLabel(sheet, j, i + 1, reportList.get(i).getFullName());
                            break;
                        case 1:
                            addLabel(sheet, j, i + 1, reportList.get(i).getMobileNumber());
                            break;
                        case 2:
                            addLabel(sheet, j, i + 1, reportList.get(i).getEmail());
                            break;
                        case 3:
                            addLabel(sheet, j, i + 1, reportList.get(i).getLastLogin());
                            break;
                        case 4:
                            addLabel(sheet, j, i + 1, reportList.get(i).getUsername());
                            break;
                        case 5:
                            addLabel(sheet, j, i + 1, reportList.get(i).getStatusDetails());
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("\nException while writing :");
        }
    }

    private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
    }

    private void addCaption(WritableSheet sheet, int column, int row, String s)
            throws RowsExceededException, WriteException {
        Label label;
        label
                = new Label(column, row, s, timesBoldUnderline);
        sheet.addCell(label);
    }

    private void addNumber(WritableSheet sheet, int column, int row,
            Integer integer) throws WriteException, RowsExceededException {
        Number number;
        number
                = new Number(column, row, integer, times);
        sheet.addCell(number);
    }

    private void addLabel(WritableSheet sheet, int column, int row, String s)
            throws WriteException, RowsExceededException {
        Label label;
        label = new Label(column, row, s, times);
        sheet.addCell(label);
    }

}

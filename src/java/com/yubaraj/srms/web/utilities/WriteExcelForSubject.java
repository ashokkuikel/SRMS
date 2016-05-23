package com.yubaraj.srms.web.utilities;

//package com.yubaraj.sms.utilities;
//
//import com.yubaraj.sms.DTO.SubjectDTO;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.List;
//import java.util.Locale;
//import javax.swing.JFileChooser;
//import javax.swing.JOptionPane;
//import jxl.CellView;
//import jxl.Workbook;
//import jxl.WorkbookSettings;
//import jxl.format.UnderlineStyle;
//import jxl.write.Label;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.WriteException;
//import jxl.write.biff.RowsExceededException;
//import org.apache.log4j.Logger;
//
///**
// *
// * @author Yuba Raj Kalathoki
// * <info.ykalathoki@gmail.com>
// */
//public class WriteExcelForSubject {
//
//    private WritableCellFormat timesBoldUnderline;
//    private WritableCellFormat times;
//    private String inputFile1;
//    private File inputFile;
//    String[] dataAbcd;
//    private Logger logger;
//
//    public WriteExcelForSubject(String column[], List<SubjectDTO> reportList, Logger logger) {
//        this.logger = logger;
//        try {
//            JFileChooser chooser = new JFileChooser();
//            chooser.setDialogTitle("Save Report");
//            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//            chooser.setCurrentDirectory(new File("."));
//
//            Calendar cal = Calendar.getInstance();
//            
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//            String date = sdf.format(cal.getTime());
//            inputFile = new File(date);
//            logger.info("\nRequested to generate report at " + inputFile);
//            chooser.setSelectedFile(inputFile);
//            int result = chooser.showSaveDialog(null);
//
//            if (result == JFileChooser.CANCEL_OPTION) {
//                return;
//            } else if (result == JFileChooser.APPROVE_OPTION) {
//
//                if (inputFile == null) {
//                    chooser.setSelectedFile(inputFile);
//                    chooser.updateUI();
//                }
//                inputFile = chooser.getSelectedFile();
//                if (inputFile.getName().endsWith(".xls")) {
//                    setOutputFile(new File(inputFile + ""));
//                } else {
//                    setOutputFile(new File(inputFile + ".xls"));
//                }
//
//                write(column, reportList, logger);
//                logger.info("\nReport generated as " + inputFile);
//                JOptionPane.showMessageDialog(null, "Report Successfully Exported", "Successfull !", JOptionPane.INFORMATION_MESSAGE);
//
//            } else {
//                JOptionPane.showMessageDialog(null, "Sorry Something wrong. \n Please see log file for more details", "Oops !", JOptionPane.ERROR_MESSAGE);
//            }
//
//        } catch (IOException e) {
//            logger.info("\nException here ", e);
//            e.printStackTrace();
//        } catch (WriteException e) {
//            logger.info("\nException here ", e);
//            e.printStackTrace();
//        }
//    }
//
//    public void setOutputFile(String inputFile1) {
//        this.inputFile1 = inputFile1;
//    }
//
//    public void setOutputFile(File inputFile) {
//        this.inputFile = inputFile;
//    }
//
//    private void write(String[] column, List<SubjectDTO> reportLst, Logger logger) throws IOException, WriteException {
//        try {
//            File file = inputFile;
//            WorkbookSettings wbSettings = new WorkbookSettings();
//
//            wbSettings.setLocale(new Locale("en", "EN"));
//
//            WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
//            workbook.createSheet("Report", 0);
//            WritableSheet excelSheet = workbook.getSheet(0);
//            createLabel(excelSheet, column, reportLst, logger);
//            createContent(excelSheet);
//
//            workbook.write();
//            workbook.close();
//        } catch (Exception e) {
//            logger.info("\nException ", e);
//        }
//    }
//
//    private void createLabel(WritableSheet sheet, String[] column, List<SubjectDTO> reportList, Logger logger)
//            throws WriteException {
//        try {
//            // Lets create a times font
//            WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
//            // Define the cell format
//            times = new WritableCellFormat(times10pt);
//            // Lets automatically wrap the cells
//            times.setWrap(true);
//
//            // Create create a bold font with unterlines
//            WritableFont times10ptBoldUnderline = new WritableFont(
//                    WritableFont.TIMES, 10, WritableFont.BOLD, false,
//                    UnderlineStyle.SINGLE);
//            timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
//            // Lets automatically wrap the cells
//            timesBoldUnderline.setWrap(true);
//
//            CellView cv = new CellView();
//            cv.setFormat(times);
//            cv.setFormat(timesBoldUnderline);
//            cv.setAutosize(true);
//
//            for (int i = 0; i < column.length; i++) {
//                addCaption(sheet, i, 0, column[i]);
//            }
//
//            for (int i = 0; i < reportList.size(); i++) {
//                for (int j = 0; j < 9; j++) {
//                    switch (j) {
//                        case 0:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getSubjectName());
//                            break;
//                        case 1:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getCourseName());
//                            break;
//                        case 2:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getCreatedBy());
//                            break;
//                        case 3:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getCreatedDate());
//                            break;
//                        case 4:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getFullMarks().toString());
//                            break;
//                        case 5:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getPassMarks().toString());
//                            break;
//                        case 6:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getStatusDetails());
//                            break;
//                        case 7:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getLastModifiedBy());
//                            break;
//                        case 8:
//                            addLabel(sheet, j, i + 1, reportList.get(i).getLastModifiedDate());
//                            break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.info("\nException while writing :", e);
//        }
//    }
//
//    private void createContent(WritableSheet sheet) throws WriteException, RowsExceededException {
//    }
//
//    private void addCaption(WritableSheet sheet, int column, int row, String s)
//            throws RowsExceededException, WriteException {
//        Label label;
//        label =
//                new Label(column, row, s, timesBoldUnderline);
//        sheet.addCell(label);
//    }
//
//    private void addNumber(WritableSheet sheet, int column, int row,
//            Integer integer) throws WriteException, RowsExceededException {
//        jxl.write.Number number;
//        number =
//                new jxl.write.Number(column, row, integer, times);
//        sheet.addCell(number);
//    }
//
//    private void addLabel(WritableSheet sheet, int column, int row, String s)
//            throws WriteException, RowsExceededException {
//        Label label;
//        label = new Label(column, row, s, times);
//        sheet.addCell(label);
//    }
//}

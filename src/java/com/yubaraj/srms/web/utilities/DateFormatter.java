package com.yubaraj.srms.web.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yubaraj
 */
public class DateFormatter {

    public static String getDate(Date date, String format) {

        if (date != null) {
            String formattedDate = "";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            formattedDate = sdf.format(date);
            return formattedDate;
        } else {
            return "N/A";
        }
    }

    public static void main(String[] args) {
//        String hello = DateFormatter.getDate(new Date(), "dd-MM-yyyy");
        String hello = DateFormatter.getDate(new Date(), SRMSConstant.DATE_FORMAT);
        System.out.println("hello " + hello);
    }
}

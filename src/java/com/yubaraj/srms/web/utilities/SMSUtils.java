package com.yubaraj.srms.web.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class SMSUtils {

    public static Long getStudentRollNumber(String studentInformation) {
        Long rollnumber = null;
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(studentInformation);
        while (m.find()) {
            rollnumber = new Long(m.group());
        }
        return rollnumber;
    }

    public static boolean isValidDoubleValue(String stringValue) {
        if (stringValue.matches("\\d+\\.\\d+")) {
            return true;
        }
        return false;
    }

    public static boolean isValidNumeric(String valueForNumericTest) {
        if (valueForNumericTest.matches("[0-9]+")) {
            return true;
        }
        return false;
    }

    public static String getResultStatus(Double passMarks, Double marksValue) {
        if (marksValue >= passMarks) {
            return (SRMSConstant.PASSED);
        } else {
            return (SRMSConstant.FAILLED);
        }
    }

    public static Character getGender(String gender) {
        if (gender != null) {
            if (gender.equals("MALE")) {
                return SRMSConstant.MALE;
            } else if (gender.equals("FEMALE")) {
                return SRMSConstant.FEMALE;
            } else {
                return SRMSConstant.OTHER;
            }
        } else {
            throw new UnsupportedOperationException("Gender is null");
        }
    }
    public static String getStatus(Character status) {
        if (status != null) {
            if (status.equals('A')) {
                return "Active";
            } else if (status.equals('B')) {
                return "Blocked";
            } else {
                return "Deleted";
            }
        } else {
            throw new UnsupportedOperationException("Status is null");
        }
    }
}

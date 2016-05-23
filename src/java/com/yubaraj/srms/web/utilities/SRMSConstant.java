package com.yubaraj.srms.web.utilities;

/**
 *
 * @author Yuba Raj Kalathoki
 * <info.ykalathoki@gmail.com>
 */
public class SRMSConstant {

    /**
     * Active and Deactive Status
     */
    public static Character ACTIVE_STATUS = 'A';
    public static Character DEACTIVE_STATUS = 'B';
    public static final Character DELETED_STATUS='D';
    /**
     * Male and Female
     */
    public static Character MALE = 'M';
    public static Character FEMALE = 'F';
    public static Character OTHER = 'O';
    /**
     * User type
     */
    public static final String SUPER_USER="SUPER_USER";
    public static final String APP_USER="APP_USER";
    
    /**
     * Result Passed and Failled
     */
    public static final String PASSED = "PASSED";
    public static final String FAILLED = "FAILLED";
    /**
     * Grades
     */
    public static final char GRADE_A = 'A';
    public static final char GRADE_B = 'B';
    public static final char GRADE_C = 'C';
    public static final char GRADE_D = 'D';
    public static final char GRADE_E = 'D';
    /**
     * Marks for grades
     */
    public static final Double GRADE_A_MARKS = 70D;

    /**
     * Messages
     */
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String USERNAME_REQUIRED = "usernameRequired";
    public static final String PASSWORD_REQUIRED = "passwordRequired";
    public static final String USER_TYPE_REQUIRED = "userTypeRequired";
    public static final String CONTENT = "content";
    public static final String SUCCESS_MESSAGE="successMessage";
    /**
     * Request actions
     */
    public static final String STUDENT_REGISTER_ACTION = "studentRegisterAction";
    public static final String USER_REGISTER_ACTION = "userRegisterAction";
    /**
     * Date format standard for Yubaraj
     */
    
    public static final String DATE_FORMAT="MM/dd/yyyy hh:mm:ss";
}

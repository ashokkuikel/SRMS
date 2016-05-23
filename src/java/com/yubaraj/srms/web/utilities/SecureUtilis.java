package com.yubaraj.srms.web.utilities;

/**
 *
 * @author Yubaraj
 */
public class SecureUtilis {

    public static String getBCryptedValue(String value) {
        String bValue = "";
        bValue = BCrypt.hashpw(value, BCrypt.gensalt());
        return bValue;
    }

    public static boolean isValidPassword(String plainText, String hashed) {
        try {
            return BCrypt.checkpw(plainText, hashed);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Salt Version");
            return false;
        }
    }
}

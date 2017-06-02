package by.hotel.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5.java
 * Class to data encryption using an algorithm MD5.
 * crypt - method to crypt data.
 * @author Igor Kozlov
 * @version 1.0
 */
public class MD5 {
    /**
     * Field - digester.
     */
    private static MessageDigest digester;

    static {
        try {
            digester = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a singleton object.
     * @param str - unencrypted string.
     * @return encrypted string.
     */
    public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        digester.update(str.getBytes());
        byte[] hash = digester.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
}

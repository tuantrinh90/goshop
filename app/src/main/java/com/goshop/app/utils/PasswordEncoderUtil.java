package com.goshop.app.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordEncoderUtil {

    private static final String ALGORITHM = "SHA-256";

    private static final String CHARSETNAME = "UTF-8";

    private static final int ITERATIONS = 100000;

    private static final int SALT_BYTE = 10;

    private static final int SALT_VAL = 0;

    public static String encryptPasswordWithSHA256Salt(String password) {
        byte[] salt = new byte[SALT_BYTE];
        Arrays.fill(salt, (byte) SALT_VAL);
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] messageByte = password.getBytes(CHARSETNAME);
            messageDigest.update(salt);
            messageDigest.update(messageByte);
            byte[] digestByte = messageDigest.digest();
            for (int i = 0; i < (ITERATIONS - 1); i++) {
                messageDigest.reset();
                digestByte = messageDigest.digest(digestByte);
            }
            // We build the result variable
            encodeStr = byte2Hex(digestByte);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr.toUpperCase();
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }


}

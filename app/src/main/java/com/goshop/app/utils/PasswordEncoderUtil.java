package com.goshop.app.utils;

import android.os.Handler;
import android.os.Message;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class PasswordEncoderUtil {

    public static final int MESSAGE_WHAT_ENCRYPTION = 0;

    private static final String ALGORITHM = "SHA-256";

    private static final String CHARSETNAME = "UTF-8";

    private static final int ITERATIONS = 100000;

    private static final int SALT_BYTE = 10;

    private static final int SALT_VAL = 0;

    public static void getEncryptPassword(Handler handler, String password) {
        new Thread(() -> {
            String result = encryptPasswordWithSHA256Salt(password);
            Message msg = new Message();
            msg.obj = result;
            msg.what = MESSAGE_WHAT_ENCRYPTION;
            handler.sendMessage(msg);
        }).start();
    }

    public static void getEncryptPasswords(Handler handler, String password1, String password2) {
        new Thread(() -> {
            String result1 = encryptPasswordWithSHA256Salt(password1);
            new Thread(() -> {
                String result2 = encryptPasswordWithSHA256Salt(password2);
                Message msg = new Message();
                msg.obj = result1 + "/" + result2;
                msg.what = MESSAGE_WHAT_ENCRYPTION;
                handler.sendMessage(msg);
            }).start();
        }).start();
    }

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

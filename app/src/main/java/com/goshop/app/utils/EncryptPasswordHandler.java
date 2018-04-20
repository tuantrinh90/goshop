package com.goshop.app.utils;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;

public class EncryptPasswordHandler extends Handler {

    private OnPasswordEncryptListener onPasswordEncryptListener;

    public EncryptPasswordHandler(Activity activity) {
        if (activity instanceof OnPasswordEncryptListener) {
            onPasswordEncryptListener = (OnPasswordEncryptListener) activity;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (onPasswordEncryptListener == null) {
            return;
        }
        if (PasswordEncoderUtil.MESSAGE_WHAT_ENCRYPTION == msg.what) {
            String password = (String) msg.obj;
            onPasswordEncryptListener.onPasswordEncrypted(password);
        }
    }

    public interface OnPasswordEncryptListener {

        void onPasswordEncrypted(String password);
    }
}

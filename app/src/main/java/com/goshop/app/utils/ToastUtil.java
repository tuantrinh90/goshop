package com.goshop.app.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by helen on 2018/1/9.
 */

public class ToastUtil {

    private static ToastUtil instance;

    private final Timer cancelTimer = new Timer();

    private final Timer timer = new Timer();

    private Context context;

    private Toast toast;

    private OnToastListener toastListener;

    private ToastUtil(Context context, OnToastListener toastListener, Toast toast) {
        this.context = context;
        this.toastListener = toastListener;
        this.toast = toast;
    }

    public static ToastUtil getInstance(Context context, OnToastListener toastListener,
        Toast toast) {
        if (instance == null) {
            return new ToastUtil(context, toastListener, toast);
        }
        return instance;
    }

    public void showToastCustomTime(final int cnt) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 3000);
        cancelTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
                toastListener.onToastCancel();
            }
        }, cnt);
    }

    public void cancelToast() {
        toast.cancel();
        timer.cancel();
        cancelTimer.cancel();
    }

    public interface OnToastListener {
        void onToastCancel();
    }

}

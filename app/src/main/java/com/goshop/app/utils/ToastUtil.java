package com.goshop.app.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by helen on 2018/1/9.
 */

public class ToastUtil {

    public static final int DELAY_TIME = 0;

    public static final int SHOW_TIME = 3000;

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
        }, DELAY_TIME, SHOW_TIME);
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

package com.goshop.app.utils;

import com.goshop.app.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class ToastUtil {

    public static final int DELAY_TIME = 0;

    public static final int SHOW_TIME = 3000;

    private final Timer cancelTimer = new Timer();

    private final Timer timer = new Timer();

    private Context context;

    private Toast toast;

    private OnToastListener toastListener;

    public ToastUtil(Context context, OnToastListener toastListener) {
        this.context = context;
        this.toastListener = toastListener;
        this.toast = new Toast(context);
    }

    public void showThanksToast() {
        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(context)
            .inflate(R.layout.layout_toast_complement, null);
        toast.setView(toastView);
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.BOTTOM, 0, 0);
        showToastCustomTime(SHOW_TIME);
    }

    private void showToastCustomTime(final int cnt) {
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

    public void showResetToast() {
        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(context)
            .inflate(R.layout.layout_toast_reset, null);
        toast.setView(toastView);
        toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.BOTTOM, 0, 0);
        showToastCustomTime(SHOW_TIME);
    }

    public void showLinkToast() {
        @SuppressLint("InflateParams") View toastView = LayoutInflater.from(context)
            .inflate(R.layout.layout_toast_link, null);
        toast.setView(toastView);
        toast.setGravity(Gravity.CENTER, 0, 0);
        showToastCustomTime(SHOW_TIME);
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

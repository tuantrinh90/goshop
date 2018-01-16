package com.goshop.app.utils;

import com.goshop.app.R;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by helen on 2018/1/9.
 */

public class EditTextUtil {

    public static void deleteImageShowListener(EditText targetEditText, ImageView deleteIv) {
        RxTextView.textChanges(targetEditText).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                deleteIv.setVisibility(View.VISIBLE);
                deleteIv.setOnClickListener(v -> {
                    targetEditText.setText("");
                    targetEditText.setFocusable(true);
                    targetEditText.requestFocus();
                    deleteIv.setVisibility(View.GONE);
                });
            } else {
                deleteIv.setVisibility(View.GONE);
            }
        });
    }

    public static void foucsChangedListener(EditText targetEdit, TextView titleText) {

        //TODO(helen)this is wait for decide
        /*RxView.focusChanges(targetEdit).subscribe(hasFoucs->{
            if (hasFoucs) {
                titleText.startAnimation(getEnterAnim(targetEdit.getContext()));
                titleText.setVisibility(View.VISIBLE);

            } else {
                if (!TextUtils.isEmpty(targetEdit.getText().toString())) {
                    titleText.startAnimation(getExitAnim(targetEdit.getContext()));
                    titleText.setVisibility(View.GONE);
                } else {
                    titleText.setTextColor(
                        targetEdit.getContext().getResources().getColor(R.color.colorAccent));
                    //todo(helen)wait for logic then will add tips on text
                    titleText.setText("Please input text!");
                }

            }
        });*/
        targetEdit.setOnFocusChangeListener((v, hasFoucs) -> {
            if (hasFoucs) {
                titleText.startAnimation(getEnterAnim(targetEdit.getContext()));
                titleText.setVisibility(View.VISIBLE);

            } else {
                if (!TextUtils.isEmpty(targetEdit.getText().toString())) {
                    titleText.startAnimation(getExitAnim(targetEdit.getContext()));
                    titleText.setVisibility(View.GONE);
                } else {
                    titleText.setTextColor(
                        targetEdit.getContext().getResources().getColor(R.color.colorAccent));
                    //todo(helen)wait for logic then will add tips on text
                    titleText.setText("Please input text!");
                }

            }
        });
    }

    private static AnimationSet getEnterAnim(Context context) {
        return (AnimationSet) AnimationUtils.loadAnimation(context, R.anim.enter_anim);
    }

    private static AnimationSet getExitAnim(Context context) {
        return (AnimationSet) AnimationUtils.loadAnimation(context, R.anim.exit_anim);
    }

    public static void emailFoucsChangedListener(EditText targetEdit, TextView titleText) {

        targetEdit.setOnFocusChangeListener((v, hasFoucs) -> {
            if (hasFoucs) {
                titleText.startAnimation(getEnterAnim(targetEdit.getContext()));
                titleText.setVisibility(View.VISIBLE);

            } else {
                if (isEmail(targetEdit.getText().toString())) {
                    titleText.startAnimation(getExitAnim(targetEdit.getContext()));
                    titleText.setVisibility(View.GONE);
                } else {
                    titleText.setTextColor(
                        targetEdit.getContext().getResources().getColor(R.color.colorAccent));
                    //todo(helen)wait for logic then will add tips on text
                    titleText.setText("Please input email!");
                }

            }
        });
    }

    public static boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static void mobileFoucsChangedListener(EditText targetEdit, TextView titleText) {

        targetEdit.setOnFocusChangeListener((v, hasFoucs) -> {
            if (hasFoucs) {
                titleText.startAnimation(getEnterAnim(targetEdit.getContext()));
                titleText.setVisibility(View.VISIBLE);

            } else {
                if (isMobile(targetEdit.getText().toString())) {
                    titleText.startAnimation(getExitAnim(targetEdit.getContext()));
                    titleText.setVisibility(View.GONE);
                } else {
                    titleText.setTextColor(
                        targetEdit.getContext().getResources().getColor(R.color.colorAccent));
                    //todo(helen)wait for logic then will add tips on text
                    titleText.setText("Please input mobile number!");
                }

            }
        });
    }

    public static boolean isMobile(String mobile) {
        //todo(helen) wait for logical needs
        return true;
    }

    public static void passwordFoucsChangedListener(EditText targetEdit, TextView titleText) {

        targetEdit.setOnFocusChangeListener((v, hasFoucs) -> {
            if (hasFoucs) {
                titleText.startAnimation(getEnterAnim(targetEdit.getContext()));
                titleText.setVisibility(View.VISIBLE);

            } else {
                if (isPassword(targetEdit.getText().toString())) {
                    titleText.startAnimation(getExitAnim(targetEdit.getContext()));
                    titleText.setVisibility(View.GONE);
                } else {
                    titleText.setTextColor(
                        targetEdit.getContext().getResources().getColor(R.color.colorAccent));
                    //todo(helen)wait for logic then will add tips on text
                    titleText.setText("Please input password!");
                }

            }
        });
    }

    public static boolean isPassword(String password) {
        //todo(helen) wait for logical needs
        return true;
    }

    public static void eidtLoseFocus(View view) {
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        KeyBoardUtils.hideKeyboard(view);
    }

    //todo(helen)just a demo, wait for logical needs
    public interface EditTextDeleteListener {

        void onDeleteClick();
    }

}

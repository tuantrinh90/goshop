package com.goshop.app.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class KeyBoardUtils {

    private KeyBoardUtils() {
    }

    public static void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void hideKeyboard(Activity activity) {
        try {
            if (activity != null) {
                View decorView = activity.getWindow().peekDecorView();
                InputMethodManager imm = (InputMethodManager) activity
                    .getSystemService(Activity.INPUT_METHOD_SERVICE);
                assert imm != null;
                imm.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void hideKeyboard(EditText edittext) {
        InputMethodManager inputMethodManager = (InputMethodManager)
            edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(edittext.getWindowToken(), 0);
        }
    }

    public static void showKeyboard(EditText edittext) {
        InputMethodManager inputMethodManager = (InputMethodManager)
            edittext.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.showSoftInput(edittext, InputMethodManager.SHOW_FORCED);
    }

}
package com.goshop.app.utils;

import com.goshop.app.common.view.CustomTextView;

import android.app.AlertDialog;
import android.content.DialogInterface;

public class AlertDialogUtil {

    public static void showSingleChooseDialog(CustomTextView parentView, String title,
        String[] contents) {
        AlertDialog dialog = new AlertDialog.Builder(parentView.getContext()).setTitle(title)
            .setSingleChoiceItems(contents, -1, (DialogInterface dialogInterface, int which) -> {
                parentView.setText(contents[which]);
            }).create();
        dialog.show();
    }

}

package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.utils.ScreenHelper;

import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by helen on 2018/1/16.
 */
//TODO(helen)this need decide
public class CategorySelectorHelper {

    public CategorySelectorHelper() {
    }

    public void createCheckBox(RelativeLayout parentView, List<String> categorys) {
        RelativeLayout.LayoutParams radioParams = new RelativeLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < categorys.size(); i++) {
            parentView.addView(initCheckBox(parentView, i, categorys.get(i)), radioParams);
        }
    }

    private CheckBox initCheckBox(ViewGroup parentView, int position, String category) {
        CheckBox checkBox = (CheckBox) LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.item_checkbox, parentView, false);
        checkBox.setTag(position);
        checkBox.setId(position);
        checkBox.setText(category);
        checkBox.setGravity(Gravity.CENTER);
        checkBox.setChecked(position == 0);
        setCheckBoxDrawable(checkBox);
        return checkBox;
    }

    private void setCheckBoxDrawable(CheckBox checkBox) {
        GradientDrawable normal = new GradientDrawable();
        normal.setStroke(ScreenHelper.getPxFromDp(checkBox.getContext(), 1),
            ContextCompat.getColor(checkBox.getContext(), R.color.color_main_grey));
        normal.setCornerRadius(100);
        normal.setShape(GradientDrawable.RECTANGLE);
        normal.setColor(0xffffffff);

        GradientDrawable checked = new GradientDrawable();
        checked.setStroke(ScreenHelper.getPxFromDp(checkBox.getContext(), 1),
            ContextCompat.getColor(checkBox.getContext(), R.color.color_main_grey));
        checked.setCornerRadius(100);
        checked.setShape(GradientDrawable.RECTANGLE);
        checked.setColor(0xffff4081);

        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_checked}, checked);
        drawable.addState(new int[]{-android.R.attr.state_checked}, normal);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            checkBox.setBackground(drawable);
        } else {
            checkBox.setBackgroundDrawable(drawable);
        }
    }

    private void setSelectorColor(RadioButton radioButton, int normal, int checked) {
        int[] colors = new int[]{normal, checked, normal};
        int[][] states = new int[3][];
        states[0] = new int[]{-android.R.attr.state_checked};
        states[1] = new int[]{android.R.attr.state_checked};
        states[2] = new int[]{};
        ColorStateList colorStateList = new ColorStateList(states, colors);
        radioButton.setTextColor(colorStateList);
    }
}

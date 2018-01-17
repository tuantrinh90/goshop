package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.utils.ScreenHelper;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * Created by helen on 2018/1/16.
 */

public class ColorSelectorHelper {

    public ColorSelectorHelper() {
    }

    public void createSelector(RadioGroup parentView, List<Integer> colors) {
        RadioGroup.LayoutParams radioParams = new RadioGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);
        for (int i = 0; i < colors.size(); i++) {
            parentView.addView(initSelector(parentView, i, colors.get(i)), radioParams);
        }
    }

    private RadioButton initSelector(ViewGroup parentView, int position, int color) {
        RadioButton selector = (RadioButton) LayoutInflater.from(parentView.getContext())
            .inflate(R.layout.item_color_selector, parentView, false);
        selector.setTag(position);
        selector.setId(position);
        selector.setChecked(position == 0);
        setSelectorDrawable(selector, color);
        return selector;
    }

    @SuppressLint("NewApi")
    private void setSelectorDrawable(RadioButton radioButton, int color) {
        ColorDrawable normal = new ColorDrawable(color);
        GradientDrawable checked = new GradientDrawable();
        checked.setStroke(ScreenHelper.getPxFromDp(radioButton.getContext(), 1),
            radioButton.getContext().getResources().getColor(R.color.color_main_grey));
        checked.setCornerRadius(2);
        checked.setShape(GradientDrawable.RECTANGLE);
        checked.setColor(color);

        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_checked}, checked);
        drawable.addState(new int[]{-android.R.attr.state_checked}, normal);
        radioButton.setBackground(drawable);
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

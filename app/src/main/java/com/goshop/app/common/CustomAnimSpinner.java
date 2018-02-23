package com.goshop.app.common;

import com.goshop.app.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;



public class CustomAnimSpinner extends RelativeLayout {

    @BindView(R.id.et_anim_spinner)
    ClickToSelectEditText etAnimSpinner;

    @BindView(R.id.iv_anim_spinner)
    ImageView ivAnimSpinner;

    @BindView(R.id.til_anim_spinner)
    TextInputLayout tilAnimSpinner;

    private int hintString;

    public CustomAnimSpinner(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        View spinnerView = LayoutInflater.from(context)
            .inflate(R.layout.layout_anim_spinner, this, true);
        ButterKnife.bind(this, spinnerView);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.animSpinner);
        hintString = typedArray.getResourceId(R.styleable.animSpinner_sp_hint, 0);
        typedArray.recycle();
        tilAnimSpinner.setHint(context.getString(hintString));
    }

    public CustomAnimSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomAnimSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public ClickToSelectEditText getEditText() {
        return etAnimSpinner;
    }

    public String getText() {
        return  etAnimSpinner.getText().toString();
    }

    public void setErrorMessage(String errorMessage) {
        tilAnimSpinner.setErrorEnabled(true);
        tilAnimSpinner.setError(errorMessage);
    }
}

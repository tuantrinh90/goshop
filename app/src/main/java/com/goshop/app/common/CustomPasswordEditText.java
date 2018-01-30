package com.goshop.app.common;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomEditText;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/26.
 */

public class CustomPasswordEditText extends RelativeLayout {

    @BindView(R.id.et_password_edittext)
    CustomEditText etPasswordEdittext;

    @BindView(R.id.iv_password_edittext_del)
    ImageView ivPasswordEdittextDel;

    @BindView(R.id.til_password_edittext)
    TextInputLayout tilPasswordEdittext;

    private int hintString;

    public CustomPasswordEditText(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        View editView = LayoutInflater.from(context)
            .inflate(R.layout.layout_password_edit, this, true);
        ButterKnife.bind(this, editView);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.pwd);
        hintString = typedArray.getResourceId(R.styleable.pwd_pwd_hint, R.string.password);
        typedArray.recycle();
        tilPasswordEdittext.setHint(context.getString(hintString));
        deleteImageShowListener(etPasswordEdittext, ivPasswordEdittextDel);
    }

    private void deleteImageShowListener(final EditText targetEditText, final ImageView deleteIv) {
        targetEditText.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                RxTextView.textChanges(targetEditText).subscribe(charSequence -> {
                    if (charSequence.length() > 0) {
                        tilPasswordEdittext.setErrorEnabled(false);
                        deleteIv.setVisibility(View.VISIBLE);
                        deleteIv.setOnClickListener(del -> {
                            targetEditText.setText("");
                            targetEditText.setFocusable(true);
                            targetEditText.requestFocus();
                            deleteIv.setVisibility(View.GONE);
                        });
                    } else {
                        deleteIv.setVisibility(View.GONE);
                    }
                });

            } else {
                deleteIv.setVisibility(View.GONE);
            }
        });
    }

    public CustomPasswordEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomPasswordEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public String getText() {
        return etPasswordEdittext.getText().toString();
    }

    public void setErrorMessage(String errorMessage) {
        tilPasswordEdittext.setErrorEnabled(true);
        tilPasswordEdittext.setError(errorMessage);
    }

    public void initInputType(int inputType) {
        etPasswordEdittext.setInputType(inputType);
    }

    public void initImeOptions(int imeAction) {
        etPasswordEdittext.onEditorAction(imeAction);
    }
}
package com.goshop.app.common;

import com.goshop.app.R;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/16.
 */

public class CustomMinusPlusEditText extends RelativeLayout {

    @BindView(R.id.et_minus_plus)
    EditText editText;

    @BindView(R.id.iv_minus)
    ImageView ivMinus;

    @BindView(R.id.iv_plus)
    ImageView ivPlus;

    @BindView(R.id.rl_et_minus_plus)
    RelativeLayout layout;

    public CustomMinusPlusEditText(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View editView = LayoutInflater.from(context)
            .inflate(R.layout.layout_edittext_minus_plus, this, true);
        ButterKnife.bind(this, editView);
        ivPlus.setOnClickListener(v -> plus());
        ivMinus.setOnClickListener(v -> minus());
    }

    private void plus() {
        String count = editText.getText().toString();
        if (count != null && !TextUtils.isEmpty(count)) {
            int num = Integer.parseInt(count);
            num++;
            editText.setText(num + "");
            editText.setSelection(editText.getText().length());
        }
    }

    private void minus() {
        String count = editText.getText().toString();
        if (count != null && !TextUtils.isEmpty(count)) {
            int num = Integer.parseInt(count);
            if (num > 1) {
                num--;
            } else {
                num = 1;
            }
            editText.setText(num + "");
            editText.setSelection(editText.getText().length());
        }
    }

    public CustomMinusPlusEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomMinusPlusEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setText(String text) {
        editText.setText(text);
    }


}

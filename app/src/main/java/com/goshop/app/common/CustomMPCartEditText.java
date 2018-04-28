package com.goshop.app.common;

import com.goshop.app.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomMPCartEditText extends RelativeLayout {

    private static final String placeHolder = "";

    @BindView(R.id.et_minus_plus)
    EditText editText;

    @BindView(R.id.iv_minus)
    ImageView ivMinus;

    @BindView(R.id.iv_plus)
    ImageView ivPlus;

    @BindView(R.id.rl_et_minus_plus)
    RelativeLayout layout;

    private OnCartMPEditClickListener onCartMPEditClickListener;

    public CustomMPCartEditText(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        View editView = LayoutInflater.from(context)
            .inflate(R.layout.layout_edittext_mp_cart, this, true);

        ButterKnife.bind(this, editView);
        ivPlus.setOnClickListener(v -> plus());
        ivMinus.setOnClickListener(v -> minus());
        editText.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            switch (actionId) {
                case EditorInfo.IME_ACTION_DONE:
                    onCartMPEditClickListener.onEditSend(v.getText().toString());
                    break;
            }
            return true;
        });
    }

    public void setOnCartMPEditClickListener(OnCartMPEditClickListener clickListener) {
        this.onCartMPEditClickListener = clickListener;
    }

    public interface OnCartMPEditClickListener {

        void onPlusMinusClick(boolean isPlus, String qty);

        void onEditSend(String qty);
    }

    @SuppressLint("SetTextI18n")
    private void plus() {
        String count = editText.getText().toString();
        if (!TextUtils.isEmpty(count)) {
            int num = Integer.parseInt(count);
            num++;
            ivMinus.setClickable(true);
            editText.setText(num + placeHolder);
            editText.setSelection(editText.getText().length());
            onCartMPEditClickListener.onPlusMinusClick(true,num + placeHolder);
        } else {
            editText.setText(1 + placeHolder);
            editText.setSelection(editText.getText().length());
        }
    }

    @SuppressLint("SetTextI18n")
    private void minus() {
        String count = editText.getText().toString();
        if (!TextUtils.isEmpty(count)) {
            int num = Integer.parseInt(count);
            if (num > 1) {
                num--;
            } else {
                num = 1;
                ivMinus.setClickable(false);
            }
            editText.setText(num + placeHolder);
            editText.setSelection(editText.getText().length());
            onCartMPEditClickListener.onPlusMinusClick(false,num + placeHolder);
        }
    }

    public CustomMPCartEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomMPCartEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void setEditBackGround(int resource) {
        layout.setBackgroundResource(resource);
    }

    public void setMinusBackGround(int resource) {
        ivMinus.setBackgroundResource(resource);
    }

    public void setPlusBackGround(int resource) {
        ivPlus.setBackgroundResource(resource);
    }


}

package com.goshop.app.common;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomEditText;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSearchEditText extends RelativeLayout {

    public static final int FIELD_DELAY = 500;

    @BindView(R.id.et_search_search)
    CustomEditText editText;

    @BindView(R.id.iv_search_del)
    ImageView ivDelete;

    public CustomSearchEditText(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        View searchView = LayoutInflater.from(context)
            .inflate(R.layout.layout_custom_search_edit, this, true);
        ButterKnife.bind(this, searchView);
        editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        RxTextView.textChanges(editText).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                ivDelete.setVisibility(View.VISIBLE);
                ivDelete.setOnClickListener(v -> {
                    editText.setText("");
                    editText.setFocusable(true);
                    editText.requestFocus();
                    ivDelete.setVisibility(View.GONE);
                });
            } else {
                ivDelete.setVisibility(View.GONE);
            }
        });
    }

    public CustomSearchEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CustomSearchEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public CustomEditText getEditText() {
        return editText;
    }

}

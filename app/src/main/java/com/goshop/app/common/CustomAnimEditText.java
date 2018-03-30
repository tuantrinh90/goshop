package com.goshop.app.common;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomAnimEditText extends RelativeLayout {

    private final String INPUT_EMAIL = "Email";

    private final String INPUT_MOBILE = "Mobile Number";

    @BindView(R.id.et_anim_edittext)
    RobotoRegularEditText etAnimEdittext;

    @BindView(R.id.iv_anim_del_edittext)
    ImageView ivAnimDelEdittext;

    @BindView(R.id.textinputlayout_anim)
    TextInputLayout textInputLayoutAnim;

    private int hintString;

    private String hintText;

    public CustomAnimEditText(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        View editView = LayoutInflater.from(context).inflate(R.layout.layout_anim_edit, this, true);
        ButterKnife.bind(this, editView);
        @SuppressLint("CustomViewStyleable") TypedArray typedArray = context
            .obtainStyledAttributes(attrs, R.styleable.animET);
        hintString = typedArray.getResourceId(R.styleable.animET_hint, 0);
        typedArray.recycle();
        hintText = context.getString(hintString);
        textInputLayoutAnim.setHint(hintText);
        deleteImageShowListener(etAnimEdittext, ivAnimDelEdittext);
        switch (hintText) {
            case INPUT_EMAIL:
                etAnimEdittext.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case INPUT_MOBILE:
                etAnimEdittext.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            default:
                etAnimEdittext.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
        }
    }

    private void deleteImageShowListener(final EditText targetEditText, final ImageView deleteIv) {
        targetEditText.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                RxTextView.textChanges(targetEditText).subscribe(charSequence -> {
                    if (charSequence.length() > 0) {
                        textInputLayoutAnim.setErrorEnabled(false);
                        deleteIv.setVisibility(View.VISIBLE);
                        deleteIv.setOnClickListener(del -> {
                            targetEditText.setText("");
                            targetEditText.setFocusable(true);
                            targetEditText.requestFocus();
                            deleteIv.setVisibility(View.GONE);
                        });

                        switch (hintText) {
                            case INPUT_EMAIL:
                                if (!isEmail(charSequence.toString())) {
                                    setError(targetEditText.getContext()
                                        .getString(R.string.format_email_warning));
                                } else {
                                    setNomarl();
                                }
                                break;
                            case INPUT_MOBILE:
                                if (!isMobileNO(charSequence.toString())) {
                                    setError(targetEditText.getContext()
                                        .getString(R.string.format_mobile_warning));
                                } else {
                                    setNomarl();
                                }
                                break;
                            default:
                                setNomarl();
                                break;
                        }

                    } else {
                        deleteIv.setVisibility(View.GONE);
                    }
                });

            } else {
                deleteIv.setVisibility(View.GONE);
            }
        });
    }

    private boolean isEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        }
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public void setError(String errorMessage) {
        textInputLayoutAnim.setErrorEnabled(true);
        textInputLayoutAnim.setError(errorMessage);
        textInputLayoutAnim.setHintTextAppearance(R.style.errorAppearance);
    }

    public void setNomarl() {
        textInputLayoutAnim.setErrorEnabled(false);
        textInputLayoutAnim.setHintTextAppearance(R.style.hintAppearance);
    }

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public CustomAnimEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomAnimEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public boolean isEmail() {
        return isEmail(etAnimEdittext.getText().toString());
    }

    public boolean isMobileNo() {
        return isMobileNO(etAnimEdittext.getText().toString());
    }

    public String getText() {
        return etAnimEdittext.getText().toString();
    }

    public void setText(String content) {
        etAnimEdittext.setText(content);
    }

    public void setErrorMessage(String errorMessage) {
        setError(errorMessage);
        etAnimEdittext.setFocusable(true);
        etAnimEdittext.requestFocus();
    }

    public void initInputType(int inputType) {
        etAnimEdittext.setInputType(inputType);
    }

    public void initImeOptions(int imeAction) {
        etAnimEdittext.onEditorAction(imeAction);
    }

    public TextInputLayout getTextInputLayout() {
        return textInputLayoutAnim;
    }

    public RobotoRegularEditText getEditText() {
        return etAnimEdittext;
    }
}

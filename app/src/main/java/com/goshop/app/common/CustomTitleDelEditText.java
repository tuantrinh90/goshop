package com.goshop.app.common;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.common.view.CustomTextView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/23.
 */

public class CustomTitleDelEditText extends RelativeLayout {

    public final static String EDITTEXT_EMAIL = "email";

    public final static String EDITTEXT_NUMBER = "number";

    public final static String EDITTEXT_TEXT = "text";

    private final static String WARNING_EMAIL = "Please input email!";

    private final static String WARNING_EMPTY = "Please input text!";

    @BindView(R.id.et_et_main)
    CustomEditText etEtMain;

    @BindView(R.id.iv_et_del)
    ImageView ivEtDel;

    @BindView(R.id.iv_et_eye)
    ImageView ivEtEye;

    @BindView(R.id.tv_et_title)
    CustomTextView tvEtTitle;

    private Context context;

    private int hintString;

    private boolean isMask;

    private boolean isPassword;

    public CustomTitleDelEditText(Context context) {
        super(context);
        initView(context, null);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context = context;
        View editView = LayoutInflater.from(context)
            .inflate(R.layout.layout_edittext_title_del, this, true);
        ButterKnife.bind(this, editView);
        if (attrs != null) {
            TypedArray typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.CustomTitleDelEditText);
            hintString = typedArray.getResourceId(R.styleable.CustomTitleDelEditText_et_hint, 0);
            isPassword = typedArray
                .getBoolean(R.styleable.CustomTitleDelEditText_et_password, false);
            typedArray.recycle();
            etEtMain.setHint(hintString);
            if (!isPassword) {
                ivEtEye.setVisibility(GONE);
            } else {
                isMask = true;
                etEtMain.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                ivEtEye.setVisibility(VISIBLE);
                ivEtEye.setOnClickListener(v -> {
                    isMask = !isMask;
                    if (isMask) {
                        etEtMain.setInputType(
                            InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        etEtMain.setText(getText());
                    } else {
                        etEtMain.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        etEtMain.setText(getText());
                    }
                    ivEtEye.setSelected(!ivEtEye.isSelected());
                    etEtMain.setSelection(getText().length());
                });
            }

            tvEtTitle
                .setTextColor(context.getResources().getColor(R.color.color_main_black));
            tvEtTitle.setText(hintString);

        }
        deleteImageShowListener(etEtMain, ivEtDel);
    }

    public String getText() {
        return etEtMain.getText().toString();
    }

    private void deleteImageShowListener(EditText targetEditText, ImageView deleteIv) {
        RxTextView.textChanges(targetEditText).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                deleteIv.setVisibility(View.VISIBLE);
                deleteIv.setOnClickListener(v -> {
                    targetEditText.setText("");
                    targetEditText.setFocusable(true);
                    targetEditText.requestFocus();
                    deleteIv.setVisibility(View.GONE);
                });
            } else {
                deleteIv.setVisibility(View.GONE);
            }
        });
    }

    public CustomTitleDelEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CustomTitleDelEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    public void focusListener(String viewType) {
        etEtMain.setOnFocusChangeListener((v, hasFoucs) -> {
            if (hasFoucs) {
                tvEtTitle
                    .setTextColor(context.getResources().getColor(R.color.color_main_black));
                tvEtTitle.setText(hintString);
                tvEtTitle.startAnimation(getEnterAnim(etEtMain.getContext()));
                tvEtTitle.setVisibility(View.VISIBLE);
            } else {
                if (TextUtils.isEmpty(getText())) {
                    tvEtTitle.setTextColor(context.getResources().getColor(R.color.colorAccent));
                    tvEtTitle.setText(WARNING_EMPTY);
                } else {
                    if (viewType.equals(EDITTEXT_EMAIL)) {
                        if (isEmail(getText())) {
                            tvEtTitle.startAnimation(getExitAnim(etEtMain.getContext()));
                            tvEtTitle.setVisibility(View.GONE);
                        } else {
                            tvEtTitle
                                .setTextColor(context.getResources().getColor(R.color.colorAccent));
                            //todo(helen)wait for logic then will add tips on text
                            tvEtTitle.setText(WARNING_EMAIL);
                        }
                        return;
                    }

                    tvEtTitle.startAnimation(getExitAnim(etEtMain.getContext()));
                    tvEtTitle.setVisibility(View.GONE);


                }


            }
        });
    }

    private static AnimationSet getEnterAnim(Context context) {
        return (AnimationSet) AnimationUtils.loadAnimation(context, R.anim.enter_anim);
    }

    private boolean isEmail(String email) {
        if (null == email || "".equals(email)) return false;
        Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private static AnimationSet getExitAnim(Context context) {
        return (AnimationSet) AnimationUtils.loadAnimation(context, R.anim.exit_anim);
    }

    public void initInputType(int inputType) {
        etEtMain.setInputType(inputType);
    }

    public void initImeOptions(int imeAction) {
        etEtMain.onEditorAction(imeAction);
    }

    public CustomEditText getEditText() {
        return etEtMain;
    }

    public CustomTextView getTextView() {
        return tvEtTitle;
    }
}

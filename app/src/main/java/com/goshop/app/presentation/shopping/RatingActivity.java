package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class RatingActivity extends BaseActivity<RatingContract.Presenter> implements
    RatingContract.View {

    @BindView(R.id.et_rating_detail)
    RobotoRegularEditText etRatingDetail;

    @BindView(R.id.et_rating_title)
    CustomAnimEditText etRatingTitle;

    @BindView(R.id.iv_rating_thumb)
    ImageView ivRatingThumb;

    @BindView(R.id.ratingbar_rating)
    RatingBar ratingbarRating;

    @BindView(R.id.textinputlayout_rating)
    TextInputLayout textinputlayoutRating;

    @BindView(R.id.textview_right_menu)
    RobotoMediumTextView textviewRightMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_rating;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
        textviewRightMenu.setText(getResources().getString(R.string.done));
        contentEditListener();
    }

    private void contentEditListener() {
        RxTextView.textChanges(etRatingDetail).subscribe(charSequence -> {
            if (charSequence.length() > 0) {
                textinputlayoutRating.setErrorEnabled(false);
            }
        });
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.write_a_review);
    }

    @OnClick({R.id.imageview_left_menu, R.id.textview_right_menu})
    public void onWriteReviewClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.textview_right_menu:
                KeyBoardUtils.hideKeyboard(this);
                float rating = ratingbarRating.getRating();
                String title = etRatingTitle.getText();
                String content = etRatingDetail.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    etRatingTitle.setErrorMessage(getResources().getString(R.string.empty_error));
                    return;
                }
                if (TextUtils.isEmpty(content)) {
                    textinputlayoutRating.setErrorEnabled(true);
                    textinputlayoutRating.setError(getResources().getString(R.string.empty_error));
                    textinputlayoutRating.setHintTextAppearance(R.style.errorAppearance);
                    etRatingDetail.setFocusable(true);
                    etRatingDetail.requestFocus();
                    return;
                }

                mPresenter.writeReviewRequest(title, content, rating);
                break;
        }
    }

    @Override
    public void writeReviewSuccess() {
        Toast.makeText(this,
            getResources().getString(R.string.success), Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void writeReviewFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(textviewRightMenu, errorMessage);
    }
}

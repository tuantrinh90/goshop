package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.OnClick;

public class RatingActivity extends BaseActivity {

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
        textviewRightMenu.setText(getResources().getString(R.string.done));

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
                break;
        }
    }
}

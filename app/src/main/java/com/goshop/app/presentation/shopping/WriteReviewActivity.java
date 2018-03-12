package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.OnClick;

public class WriteReviewActivity extends BaseActivity {

    @BindView(R.id.et_write_review_content)
    CustomAnimEditText etWriteReviewContent;

    @BindView(R.id.et_write_review_title)
    CustomAnimEditText etWriteReviewTitle;

    @BindView(R.id.iv_review_thumb)
    ImageView ivReviewThumb;

    @BindView(R.id.ratingbar_write_review)
    RatingBar ratingbarWriteReview;

    @BindView(R.id.textview_right_menu)
    CustomBoldTextView textviewRightMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_write_review;
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

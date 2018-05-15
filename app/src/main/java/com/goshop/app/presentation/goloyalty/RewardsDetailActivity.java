package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumItalicTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.RewardsDetailVM;
import com.goshop.app.utils.DateFormater;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.OnClick;

public class RewardsDetailActivity extends BaseActivity<RewardsDetailContract.Presenter>
    implements RewardsDetailContract.View {

    @BindView(R.id.ll_content)
    LinearLayout llContent;

    @BindView(R.id.sv_content)
    NestedScrollView nestedScrollView;

    @BindView(R.id.iv_rewards_detail_pic)
    ImageView ivRewardsDetailPic;

    @BindView(R.id.iv_rewards_details_thumb)
    ImageView ivRewardsDetailsThumb;

    @BindView(R.id.tv_btn_rewards_detail_download)
    RobotoMediumTextView tvBtnDownload;

    @BindView(R.id.tv_promo_details)
    RobotoMediumTextView tvPromoDetails;

    @BindView(R.id.tv_promo_details_summary)
    RobotoLightTextView tvPromoDetailsSummary;

    @BindView(R.id.tv_promo_terms)
    RobotoMediumTextView tvPromoTerms;

    @BindView(R.id.tv_promo_terms_summary)
    RobotoLightTextView tvPromoTermsSummary;

    @BindView(R.id.tv_promotion_title)
    RobotoMediumTextView tvPromotionTitle;

    @BindView(R.id.tv_rewards_detail_location)
    RobotoLightTextView tvRewardsDetailLocation;

    @BindView(R.id.tv_rewards_detail_time)
    RobotoLightTextView tvRewardsDetailTime;

    @BindView(R.id.tv_rewards_detail_time_left)
    RobotoMediumItalicTextView tvRewardsDetailTimeLeft;

    @BindView(R.id.tv_rewards_merchant_name)
    RobotoMediumTextView tvRewardsMerchantName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.rewardsDetailRequest(null);
    }

    private void initView() {
        hideRightMenu();
        nestedScrollView.setVisibility(View.GONE);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_rewards_detail;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_rewards_detail_download})
    public void onRewardsDetailClick(View view) {

        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_rewards_detail_download:
                //todo wait for api
                break;
        }
    }

    @Override
    public void showRewardsDetails(RewardsDetailVM rewardsDetailVM) {
        GlideUtils.loadImageError(
            this,
            rewardsDetailVM.getMerchantLogo(),
            ivRewardsDetailsThumb,
            rewardsDetailVM.getPromtionImageDefault());
        GlideUtils.loadImageError(
            this,
            rewardsDetailVM.getPromotionImage(),
            ivRewardsDetailPic,
            rewardsDetailVM.getPromtionImageDefault());
        nestedScrollView.setVisibility(View.VISIBLE);
        tvRewardsMerchantName.setText(rewardsDetailVM.getDealMerchantVM().getMerchantName());
        tvPromoDetailsSummary.setText(rewardsDetailVM.getDealDescription());
        tvPromoTermsSummary.setText(rewardsDetailVM.getDealDescription());
        tvPromotionTitle.setText(rewardsDetailVM.getDealName());
        tvRewardsDetailTime.setText(DateFormater.getDealTimePeriod(rewardsDetailVM.getDealStartDt(),rewardsDetailVM.getDealEndDt()) );
        // TODO: 2018/5/3 this need decide
        tvRewardsDetailLocation
            .setText(rewardsDetailVM.getDealLocationVMs().get(0).getLocationName());
        tvRewardsDetailTimeLeft.setText(rewardsDetailVM.getTimeLeft());
    }

    @Override
    public void showError(String message) {
        PopWindowUtil.showRequestMessagePop(llContent, message);
    }
}

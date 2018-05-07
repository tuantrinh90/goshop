package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumItalicTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.RewardsDetailVM;
import com.goshop.app.utils.GlideUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class RewardsDetailActivity extends BaseActivity<RewardsDetailContract.Presenter>
    implements RewardsDetailContract.View {

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
        //todo wait for api
        mPresenter.rewardsDetailRequest(null);
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(ivRewardsDetailsThumb), 200);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_rewards_detail;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
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

        tvRewardsMerchantName.setText(rewardsDetailVM.getMerchantName());
        tvPromoDetails.setText(rewardsDetailVM.getPromoDetail());
        tvPromoDetailsSummary.setText(rewardsDetailVM.getPromoDetailSummary());
        tvPromoTerms.setText(rewardsDetailVM.getPromoTerms());
        tvPromotionTitle.setText(rewardsDetailVM.getPromotionTitle());
        tvRewardsDetailTime.setText(rewardsDetailVM.getPromotionTime());
        tvRewardsDetailLocation.setText(rewardsDetailVM.getLocations());
        tvRewardsDetailTimeLeft.setText(rewardsDetailVM.getTimeLeft());
        List<String> terms = rewardsDetailVM.getPromoTermsSummarys();
        //todo this wait for api
        StringBuilder termsSummary = new StringBuilder();
        for (String content : terms) {
            content = "· " + content + "\n";
            termsSummary.append(content);
        }
        tvPromoTermsSummary.setText(termsSummary.toString());

    }
}

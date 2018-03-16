package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.RewardsDetailVM;

import android.os.Bundle;
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
    RobotoRegularTextView tvBtnDownload;

    @BindView(R.id.tv_promo_details)
    RobotoBoldTextView tvPromoDetails;

    @BindView(R.id.tv_promo_details_summary)
    RobotoRegularTextView tvPromoDetailsSummary;

    @BindView(R.id.tv_promo_terms)
    RobotoBoldTextView tvPromoTerms;

    @BindView(R.id.tv_promo_terms_summary)
    RobotoRegularTextView tvPromoTermsSummary;

    @BindView(R.id.tv_promotion_title)
    RobotoBoldTextView tvPromotionTitle;

    @BindView(R.id.tv_rewards_detail_location)
    RobotoRegularTextView tvRewardsDetailLocation;

    @BindView(R.id.tv_rewards_detail_time)
    RobotoRegularTextView tvRewardsDetailTime;

    @BindView(R.id.tv_rewards_detail_time_left)
    RobotoBoldTextView tvRewardsDetailTimeLeft;

    @BindView(R.id.tv_rewards_merchant_name)
    RobotoBoldTextView tvRewardsMerchantName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.rewardsDetailRequest(null);
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
        Glide.with(this).load(rewardsDetailVM.getMerchantLogo()).asBitmap()
            .error(rewardsDetailVM.getMerchantLogoDefault())
            .into(ivRewardsDetailsThumb);
        Glide.with(this).load(rewardsDetailVM.getPromotionImage()).asBitmap()
            .error(rewardsDetailVM.getPromtionImageDefault())
            .into(ivRewardsDetailPic);
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

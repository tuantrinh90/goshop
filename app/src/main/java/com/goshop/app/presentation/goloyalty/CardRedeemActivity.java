package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.CardRedeemVM;
import com.goshop.app.utils.GlideUtils;
import com.ncorti.slidetoact.SlideToActView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CardRedeemActivity extends BaseActivity<CardRedeemContract.Presenter> implements
    CardRedeemContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.iv_card_redeem_thumb)
    ImageView ivCardRedeemThumb;

    @BindView(R.id.slidetoactview_redeem)
    SlideToActView slidetoactviewRedeem;

    @BindView(R.id.tv_card_redeem_merchant_detail)
    RobotoMediumTextView tvCardRedeemMerchantDetail;

    @BindView(R.id.tv_card_redeem_merchant_end)
    RobotoLightTextView tvCardRedeemMerchantEnd;

    @BindView(R.id.tv_card_redeem_merchant_time)
    RobotoLightTextView tvCardRedeemMerchantTime;

    @BindView(R.id.tv_card_redeem_merchant_title)
    RobotoLightTextView tvCardRedeemMerchantTitle;

    @BindView(R.id.tv_card_redeem_tip)
    RobotoLightTextView tvCardRedeemTip;

    @BindView(R.id.tv_redeemed_show)
    RobotoRegularTextView tvRedeemedShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.cardRedeemRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_card_redeem;
    }

    @Override
    public void inject() {
        imageviewLeftMenu.setVisibility(View.GONE);
        initPresenter();
        tvRedeemedShow.setVisibility(View.GONE);
        slidetoactviewRedeem.setOnSlideToActAnimationEventListener(
            new SlideToActView.OnSlideToActAnimationEventListener() {
                @Override
                public void onSlideCompleteAnimationStarted(@NonNull SlideToActView view,
                    float threshold) {
                    //todo wait for api
                    slidetoactviewRedeem.setVisibility(View.GONE);
                    tvRedeemedShow.setVisibility(View.VISIBLE);
                    mPresenter.swipeRedeemRequest(null);
                }

                @Override
                public void onSlideCompleteAnimationEnded(@NonNull SlideToActView view) {

                }

                @Override
                public void onSlideResetAnimationStarted(@NonNull SlideToActView view) {

                }

                @Override
                public void onSlideResetAnimationEnded(@NonNull SlideToActView view) {
                    slidetoactviewRedeem.setVisibility(View.VISIBLE);
                }
            });
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
        return getResources().getString(R.string.redeem);
    }

    @Override
    public void showRedeemResult(CardRedeemVM cardRedeemVM) {
        GlideUtils.loadImageError(
            this,
            cardRedeemVM.getThumb(),
            ivCardRedeemThumb,
            R.drawable.ic_image_404_big);
        tvCardRedeemMerchantTitle.setText(cardRedeemVM.getTitle());
        tvCardRedeemMerchantEnd.setText(cardRedeemVM.getEnd());
        tvCardRedeemMerchantDetail.setText(cardRedeemVM.getDetail());
        tvCardRedeemMerchantTime.setText(cardRedeemVM.getTime());
    }

    @Override
    public void swipeRedeemSuccess() {
        tvRedeemedShow.setText(getResources().getString(R.string.redeemed));
        slidetoactviewRedeem.setVisibility(View.GONE);
        tvCardRedeemTip.setTextColor(
            ContextCompat.getColor(CardRedeemActivity.this, R.color.color_text_hint));
    }

    @Override
    public void swipeRedeemFailed() {
        slidetoactviewRedeem.setOnSlideCompleteListener((SlideToActView slideToActView) ->
            slidetoactviewRedeem.resetSlider());
    }
}

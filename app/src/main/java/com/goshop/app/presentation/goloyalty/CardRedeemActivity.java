package com.goshop.app.presentation.goloyalty;

import com.bumptech.glide.Glide;
import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.CardRedeemVM;
import com.goshop.app.presentation.model.RedeemSuccessVM;
import com.goshop.app.utils.PopWindowUtil;
import com.ncorti.slidetoact.SlideToActView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

public class CardRedeemActivity extends BaseActivity<CardRedeemContract.Presenter> implements
    CardRedeemContract.View {

    @BindView(R.id.ll_content)
    LinearLayout llContent;

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

    private CardRedeemVM cardRedeemVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        // TODO: 2018/5/2 get real data from intent
        cardRedeemVM = mPresenter.getMockData();
        Glide.with(this).load(cardRedeemVM.getThumb()).asBitmap()
            .error(R.drawable.ic_image_404_small)
            .into(ivCardRedeemThumb);
        tvCardRedeemMerchantTitle.setText(cardRedeemVM.getTitle());
        tvCardRedeemMerchantEnd.setText(cardRedeemVM.getEnd());
        tvCardRedeemMerchantDetail.setText(cardRedeemVM.getDetail());
        tvCardRedeemMerchantTime.setText(cardRedeemVM.getTime());

    }

    private void initView() {
        imageviewLeftMenu.setVisibility(View.GONE);
        tvRedeemedShow.setVisibility(View.GONE);
        slidetoactviewRedeem.setOnSlideToActAnimationEventListener(
            new SlideToActView.OnSlideToActAnimationEventListener() {
                @Override
                public void onSlideCompleteAnimationStarted(@NonNull SlideToActView view,
                    float threshold) {
                    tvRedeemedShow.setVisibility(View.VISIBLE);
                    slidetoactviewRedeem.setVisibility(View.GONE);
                    //todo wait for api
                    Map<String, Object> params = new HashMap<>();
                    params.put(Const.REQUEST_PARAM_CUSTOMER_ID, "1");
                    params.put(Const.REQUEST_PARAM_DEAL_ID, "3");
                    mPresenter.swipeRedeemRequest(params);
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

    @Override
    public int getContentView() {
        return R.layout.activity_card_redeem;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.redeem);
    }

    @Override
    public void swipeRedeemSuccess(RedeemSuccessVM redeemSuccessVM) {
        tvRedeemedShow.setText(getResources().getString(R.string.redeemed));
        slidetoactviewRedeem.setVisibility(View.GONE);
        tvCardRedeemTip.setTextColor(
            ContextCompat.getColor(CardRedeemActivity.this, R.color.color_text_hint));
    }

    @Override
    public void swipeRedeemFailed(String message) {
        PopWindowUtil.showRequestMessagePop(llContent, message);
        slidetoactviewRedeem.setOnSlideCompleteListener((SlideToActView slideToActView) ->
            slidetoactviewRedeem.resetSlider());
    }
}

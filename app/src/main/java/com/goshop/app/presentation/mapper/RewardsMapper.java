package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.response.DealCategoryResponse;
import com.goshop.app.data.model.response.DealDetailsResponse;
import com.goshop.app.data.model.response.DealLocationResponse;
import com.goshop.app.data.model.response.MyRewardsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.RewardResponse;
import com.goshop.app.presentation.model.DealCategoryVM;
import com.goshop.app.presentation.model.DealLocationVM;
import com.goshop.app.presentation.model.DealMerchantVM;
import com.goshop.app.presentation.model.DealStatusVM;
import com.goshop.app.presentation.model.RedeemSuccessVM;
import com.goshop.app.presentation.model.RewardsDetailVM;

import java.util.ArrayList;
import java.util.List;

public class RewardsMapper {

    public static RedeemSuccessVM transformSwipeRedeem(
        Response<CardRedeemResponse> cardRedeemResponse) {
        if (cardRedeemResponse.getData().getReward() != null) {
            RedeemSuccessVM redeemSuccessVM = new RedeemSuccessVM();
            RewardResponse rewardResponse = cardRedeemResponse.getData().getReward();
            redeemSuccessVM.setCustomerId(rewardResponse.getCustomerId());
            redeemSuccessVM.setDealId(rewardResponse.getDealId());
            redeemSuccessVM.setInstDtm(rewardResponse.getInstDtm());
            redeemSuccessVM.setRewardCode(rewardResponse.getRewardCode());
            redeemSuccessVM.setRewardExpiryDt(rewardResponse.getRewardExpiryDt());
            redeemSuccessVM.setRewardId(rewardResponse.getRewardId());
            redeemSuccessVM.setInstId(rewardResponse.getInstId());
            return redeemSuccessVM;
        }
        return null;
    }

    public static RewardsDetailVM transformDealDetail(
        Response<MyRewardsResponse> myRewardsResponse) {
        RewardsDetailVM rewardsDetailVM = new RewardsDetailVM();
        if (myRewardsResponse.getData() != null && myRewardsResponse.getData().getDeal() != null) {
            DealDetailsResponse dealDetailsResponse = myRewardsResponse.getData().getDeal();
            rewardsDetailVM.setDealId(dealDetailsResponse.getDealId());
            rewardsDetailVM.setDealDescription(dealDetailsResponse.getDealDescription());
            rewardsDetailVM.setDealEndDt(dealDetailsResponse.getDealEndDt());
            rewardsDetailVM.setDealImage(dealDetailsResponse.getDealImage());
            rewardsDetailVM.setDealName(dealDetailsResponse.getDealName());
            rewardsDetailVM.setDealStartDt(dealDetailsResponse.getDealStartDt());
            DealMerchantVM dealMerchantVM = new DealMerchantVM();
            if (dealDetailsResponse.getDealMerchantResponse() != null) {
                dealMerchantVM
                    .setMerchantId(dealDetailsResponse.getDealMerchantResponse().getMerchantId());
                dealMerchantVM
                    .setMerchantName(
                        dealDetailsResponse.getDealMerchantResponse().getMerchantName());
            }
            rewardsDetailVM.setDealMerchantVM(dealMerchantVM);
            DealStatusVM dealStatusVM = new DealStatusVM();
            if (dealDetailsResponse.getDealStatusResponse() != null) {
                dealStatusVM
                    .setStatusName(dealDetailsResponse.getDealStatusResponse().getStatusName());
                dealStatusVM.setStatusId(dealDetailsResponse.getDealStatusResponse().getStatusId());
            }
            rewardsDetailVM.setDealStatusVM(dealStatusVM);
            List<DealCategoryVM> dealCategoryVMs = new ArrayList<>();
            if (dealDetailsResponse.getDealCategoryResponses() != null && !dealDetailsResponse
                .getDealCategoryResponses().isEmpty()) {
                for (DealCategoryResponse dealCategoryResponse : dealDetailsResponse
                    .getDealCategoryResponses()) {
                    DealCategoryVM dealCategoryVM = new DealCategoryVM();
                    dealCategoryVM.setCategoryId(dealCategoryResponse.getCategoryId());
                    dealCategoryVM.setCategoryName(dealCategoryResponse.getCategoryName());
                    dealCategoryVMs.add(dealCategoryVM);
                }
            }
            rewardsDetailVM.setDealCategoryVMs(dealCategoryVMs);
            List<DealLocationVM> dealLocationVMs = new ArrayList<>();
            if (dealDetailsResponse.getDealLocationResponses() != null && !dealDetailsResponse
                .getDealLocationResponses().isEmpty()) {
                for (DealLocationResponse dealLocationResponse : dealDetailsResponse
                    .getDealLocationResponses()) {
                    DealLocationVM dealLocationVM = new DealLocationVM();
                    dealLocationVM.setLocationId(dealLocationResponse.getLocationId());
                    dealLocationVM.setLocationName(dealLocationResponse.getLocationName());
                    dealLocationVMs.add(dealLocationVM);
                }
            }
            rewardsDetailVM.setDealLocationVMs(dealLocationVMs);
        }

        return rewardsDetailVM;
    }
}

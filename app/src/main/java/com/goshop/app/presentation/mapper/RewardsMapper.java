package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.CardRedeemResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.RewardResponse;
import com.goshop.app.presentation.model.RedeemSuccessVM;

public class RewardsMapper {

    public static RedeemSuccessVM transformSwipeRedeem(
        Response<CardRedeemResponse> cardRedeemResponse) {
        if (cardRedeemResponse.getData().getReward() != null) {
            RedeemSuccessVM redeemSuccessVM = new RedeemSuccessVM();
            RewardResponse rewardResponse=cardRedeemResponse.getData().getReward();
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
}

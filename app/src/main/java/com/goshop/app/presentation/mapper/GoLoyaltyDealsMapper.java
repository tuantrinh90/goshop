package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.DealsResponse;
import com.goshop.app.data.model.response.common.DealsData;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.utils.DateFormater;

import java.util.ArrayList;
import java.util.List;

public class GoLoyaltyDealsMapper {

    public static List<GoLoyaltyDealsVM> transform(DealsResponse response) {
        List<GoLoyaltyDealsVM> dealsVMS = new ArrayList<>();
        List<DealsData> dealsDatas = response.getDeals();
        for (DealsData data:dealsDatas) {
            dealsVMS.add(
            new GoLoyaltyDealsVM(data.getDealImage(), R.drawable.ic_image_404_small,
                data.getDealMerchant().getMerchantName(),
                data.getDealName(),
                DateFormater.getDealTimePeriod(data.getDealStartDt(),
                    data.getDealEndDt()), ""));
        }
        return dealsVMS;
    }
}

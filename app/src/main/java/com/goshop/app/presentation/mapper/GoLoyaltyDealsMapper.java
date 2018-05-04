package com.goshop.app.presentation.mapper;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.data.model.response.DealsResponse;
import com.goshop.app.data.model.response.common.DealLocationData;
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
            String locations = "";
            List<DealLocationData> dealLocationDatas = data.getDealLocation();
            List<ArraysVM> locationArrays = new ArrayList<>();
            for(DealLocationData locationData: dealLocationDatas) {
                locations = locations + locationData.getLocationName() + Const.TEXT_SEPARATOR;
                ArraysVM arraysVM = new ArraysVM();
                arraysVM.setId(locationData.getLocationId());
                arraysVM.setName(locationData.getLocationName());
                locationArrays.add(arraysVM);
            }

            GoLoyaltyDealsVM dealsVM = new GoLoyaltyDealsVM();
            dealsVM.setImageUrl(data.getDealImage());
            dealsVM.setIconDefault(R.drawable.ic_image_404_small);
            dealsVM.setName(data.getDealMerchant().getMerchantName());
            dealsVM.setDetail(data.getDealName());
            dealsVM.setTime( DateFormater.getDealTimePeriod(data.getDealStartDt(),
                data.getDealEndDt()));
            dealsVM.setEnd(locations);
            dealsVM.setLocations(locationArrays);
            dealsVMS.add(dealsVM);
        }
        return dealsVMS;
    }
}

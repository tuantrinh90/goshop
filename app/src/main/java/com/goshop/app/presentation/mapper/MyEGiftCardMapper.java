package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.presentation.model.MyEGiftCardsDetailsVM;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.ArrayList;
import java.util.List;

public class MyEGiftCardMapper {

    private static final String EXPIRE_TILL = "Expire till ";

    private static final String SENT_BY = "Sent by ";

    public static List<MyEGiftModel> transform(MyEGiftResponse response) {
        List<MyEGiftModel> myEGiftModels = new ArrayList<>();
        myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_TOP));
        myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_CENTER));
        List<MyEGiftResponse.Datas.EGiftCardData> eGiftCardDatas = response.getData()
            .getEGiftCard();
        List<MyEGiftCardsDetailsVM> detailsVMS = new ArrayList<>();
        for (MyEGiftResponse.Datas.EGiftCardData eGiftCardData : eGiftCardDatas) {
            detailsVMS.add(
                new MyEGiftCardsDetailsVM(eGiftCardData.getCode(),
                    SENT_BY + eGiftCardData.getSentby(),
                    EXPIRE_TILL + eGiftCardData.getExpire(),
                    eGiftCardData.getBalance(),
                    eGiftCardData.getStatus()));
        }
        myEGiftModels.addAll(detailsVMS);
        return myEGiftModels;
    }

}

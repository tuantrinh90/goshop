package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyEGiftResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.EgiftCardData;
import com.goshop.app.presentation.model.MyEGiftCardsDetailsVM;
import com.goshop.app.presentation.model.MyEGiftModel;

import java.util.ArrayList;
import java.util.List;

public class MyEGiftCardMapper {

    private static final String EXPIRE_TILL = "Expire till ";

    private static final String SENT_BY = "Sent by ";

    public static List<MyEGiftModel> transform(Response<MyEGiftResponse> response) {
        List<MyEGiftModel> myEGiftModels = new ArrayList<>();
        myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_TOP));
        List<EgiftCardData> eGiftCardDatas = response.getData()
            .getEgiftCard();
        if (eGiftCardDatas.size() > 0) {
            myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_CENTER));

            List<MyEGiftCardsDetailsVM> detailsVMS = new ArrayList<>();
            for (EgiftCardData eGiftCardData : eGiftCardDatas) {
                detailsVMS.add(
                    new MyEGiftCardsDetailsVM(eGiftCardData.getCode(),
                        SENT_BY + eGiftCardData.getSentby(),
                        EXPIRE_TILL + eGiftCardData.getExpire(),
                        eGiftCardData.getBalance(),
                        eGiftCardData.getStatus()));
            }
            myEGiftModels.addAll(detailsVMS);
        } else {
            myEGiftModels.add(new MyEGiftModel(MyEGiftModel.VIEW_TYPE_NO_DATA));
        }
        return myEGiftModels;
    }

}

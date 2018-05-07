package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.CardRedeemVM;
import com.goshop.app.presentation.model.RedeemSuccessVM;

import java.util.Map;

public class CardRedeemContract {

    interface View extends BaseView {

        void swipeRedeemSuccess(RedeemSuccessVM redeemSuccessVM);

        void swipeRedeemFailed(String s);
    }

    public interface Presenter extends BasePresenter<View> {

        void swipeRedeemRequest(Map<String, Object> params);

        CardRedeemVM getMockData();
    }

}

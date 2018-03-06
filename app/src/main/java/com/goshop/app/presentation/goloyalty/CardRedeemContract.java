package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.CardRedeemVM;

import java.util.Map;

public class CardRedeemContract {

    interface View extends BaseView {

        void showRedeemResult(CardRedeemVM cardRedeemVM);

        void swipeRedeemSuccess();

        void swipeRedeemFailed();
    }

    public interface Presenter extends BasePresenter<View> {

        void cardRedeemRequest(Map<String, Object> params);

        void swipeRedeemRequest(Map<String, Object> params);
    }

}

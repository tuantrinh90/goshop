package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.GoLoyaltyModel;

import java.util.List;
import java.util.Map;

public class GoLoyaltyContract {

    interface View extends BaseView {

        void showGoLoyaltyResult(List<GoLoyaltyModel> goLoyaltyModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void goLoyaltyRequest(Map<String, Object> params);
    }
}

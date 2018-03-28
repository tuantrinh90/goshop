package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;

import java.util.List;
import java.util.Map;

public class RedeemedContract {

    interface View extends BaseView {

        void showRedeemedResult(List<GoLoyaltyDealsVM> dealsVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void redeemedRequest(Map<String, Object> params);
    }
}

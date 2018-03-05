package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.RewardsDetailVM;

import java.util.Map;

public class RewardsDetailContract {

    interface View extends BaseView {

        void showRewardsDetails(RewardsDetailVM rewardsDetailVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void rewardsDetailRequest(Map<String, Object> params);
    }
}

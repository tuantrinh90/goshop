package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.NotificationVM;

import java.util.List;
import java.util.Map;

public class NotificationContract {

    interface View extends BaseView {

        void notificationResult(List<NotificationVM> notificationVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void notificationRequest(Map<String, Object> params);
    }
}

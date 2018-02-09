package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.NotificationsResponse;

import java.util.Map;

/**
 * Created by helen on 2018/1/26.
 */

public class NotificationContract {

    interface View extends BaseView {

        void notificationResult(NotificationsResponse notificationsResponse);
    }

    public interface Presenter extends BasePresenter<View> {

        void notificationRequest(Map<String, Object> params);
    }
}

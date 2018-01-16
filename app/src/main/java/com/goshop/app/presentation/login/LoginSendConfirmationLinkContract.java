package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

/**
 * Created by helen on 2018/1/9.
 */

public class LoginSendConfirmationLinkContract {

    interface View extends BaseView {

        void sendConfirmationLinkSuccess();
    }

    public interface Presenter extends BasePresenter<View> {

        void sendConfirmationLinkRequest(Map<String, Object> params);
    }

}

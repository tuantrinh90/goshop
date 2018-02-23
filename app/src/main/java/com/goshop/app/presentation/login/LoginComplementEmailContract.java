package com.goshop.app.presentation.login;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

public class LoginComplementEmailContract {

    interface View extends BaseView {

        void complementEmailSuccess();

        void showErrorMessage();

        void hideErrorMessage();
    }

    public interface Presenter extends BasePresenter<View> {

        void complementEmailRequest(Map<String, Object> params);
    }

}

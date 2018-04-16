package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.List;

public class ReturnOrderContract {

    interface View extends BaseView {

        void returnRequestSuccess();

        void returnRequestFailed(String errorMessage);

        void returnRequestNetError(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        List<ProfileMetaVM> getCodeChooses();

        List<ProfileMetaVM> getDetailChooses();

        void returnOrderRequest(String name, String email, String mobile, String handing,
            String reasonCode, String reasonDetail);
    }
}

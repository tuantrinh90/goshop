package com.goshop.app.presentation.myorder;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.List;

public class CancelOrderContract {

    interface View extends BaseView {

        void cancelRequestSuccess();

        void cancelRequestFailed(String errorMessage);

        void cancelRequestNetError(String errorMessage);

        void setReasonCode(List<ProfileMetaVM> reasonCodes);
    }

    public interface Presenter extends BasePresenter<View> {

        void cancelOrderRequest(String name, String email, String mobile, String handing,
            String reasonCode, String reasonDetail);

        void getOrderMetadata();
    }
}

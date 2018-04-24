package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.HelpSupportModel;
import java.util.ArrayList;

public class HelpSupportContract {

    interface View extends BaseView {

        void onHelpSupportRequestSuccess(ArrayList<HelpSupportModel> helpSupportResponse);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void helpSupportRequest();
    }

}

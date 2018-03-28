package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

import java.util.List;
import java.util.Map;

public class AddAddressContract {

    interface View extends BaseView {

        void addAddressResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void addAddressRequest(Map<String, Object> params);

        List<SingleChooseVM> getCountryChooses();

        List<SingleChooseVM> getStateChooses();

        List<SingleChooseVM> getCityChooses();
    }
}

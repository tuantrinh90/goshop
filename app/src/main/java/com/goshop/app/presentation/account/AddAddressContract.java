package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

import java.util.Map;

/**
 * Created by helen on 2018/1/26.
 */

public class AddAddressContract {

    interface View extends BaseView {

        void addAddressResult();
    }

    public interface Presenter extends BasePresenter<View> {

        void addAddressRequest(Map<String, Object> params);
    }
}

package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.HomeResponse;

import java.util.Map;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface HomeContract {

    interface View extends BaseView{

        void showHome(HomeResponse homeResponse);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<View>{
         void getHome(Map<String, Object> params);
    }

}

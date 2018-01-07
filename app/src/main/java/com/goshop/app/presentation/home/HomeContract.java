package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.Weather;

/**
 * Created by Administrator on 2018/1/6.
 */

public interface HomeContract {

    interface View extends BaseView{

        void showWeather(Weather weather);

        void showNetwordErrorMessage();

        void showFaildMessage(String errorMessage);
    }

    interface Presenter extends BasePresenter<View>{
         void getWeather();
    }

}

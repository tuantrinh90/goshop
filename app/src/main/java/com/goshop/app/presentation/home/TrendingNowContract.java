package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import java.util.List;
import java.util.Map;

public class TrendingNowContract {

    interface View extends BaseView {

        void trendingNowResult(List<WidgetViewModel> widgetViewModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void trendingNowRequest(Map<String, Object> params);
    }

}

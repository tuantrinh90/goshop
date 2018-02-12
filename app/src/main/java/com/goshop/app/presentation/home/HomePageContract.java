package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/2/10.
 */

public class HomePageContract {

    interface View extends BaseView {
        void homePageResult(List<WidgetViewModel> widgetViewModels);
    }

    public interface Presenter extends BasePresenter<View> {
        void homePageRequest(Map<String, Object> params);
    }

}

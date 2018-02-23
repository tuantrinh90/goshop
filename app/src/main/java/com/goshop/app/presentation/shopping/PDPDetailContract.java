package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/2/22.
 */

public class PDPDetailContract {

    interface View extends BaseView {

        void pdpDetailRequestSuccess(List<WidgetViewModel> detailDatas);
    }

    public interface Presenter extends BasePresenter<View> {

        void pdpDetailRequest(Map<String, Object> params);
    }
}

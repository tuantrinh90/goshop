package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.PointsModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/2/8.
 */

public class MyPointsContract {

    interface View extends BaseView {

        void showMyPointsResult(List<PointsModel> pointsModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void myPointsRequest(Map<String, Object> params);
    }
}

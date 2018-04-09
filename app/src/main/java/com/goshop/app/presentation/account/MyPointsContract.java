package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.PointsModel;

import java.util.List;
import java.util.Map;

public class MyPointsContract {

    interface View extends BaseView {

        void getPointDetailsSuccess(List<PointsModel> pointsModels);

        void getPointDetailsFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void getGoShopPointsDetails();
    }
}

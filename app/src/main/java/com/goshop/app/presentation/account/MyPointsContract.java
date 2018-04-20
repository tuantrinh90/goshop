package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.PointsModel;

import java.util.List;

public class MyPointsContract {

    interface View extends BaseView {

        void getPointDetailsSuccess(List<PointsModel> pointsModels, PaginationData pagination);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void getGoShopPointsDetails(int page, boolean isShowLoading);
    }
}

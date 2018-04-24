package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.BrandsListVM;

import java.util.List;

public class BrandsContract {

    interface View extends BaseView {

        void onBandRequestSuccess(List<BrandsListVM> brandsVMS, PaginationData pagination);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void brandsRequest(int page, boolean isShowLoading);
    }

}

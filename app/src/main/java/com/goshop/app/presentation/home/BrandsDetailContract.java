package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.BrandsDetailModel;

import java.util.List;
import java.util.Map;

public class BrandsDetailContract {

    interface View extends BaseView {

        void brandsDetailResult(List<BrandsDetailModel> brandsDetailModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void brandsDetailRequest(Map<String, Object> params);
    }

}

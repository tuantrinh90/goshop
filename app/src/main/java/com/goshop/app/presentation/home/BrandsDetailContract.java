package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.BrandsDetailVM;
import com.goshop.app.presentation.model.FilterMenuModel;

import java.util.List;
import java.util.Map;

public class BrandsDetailContract {

    interface View extends BaseView {

        void brandsDetailResult(BrandsDetailVM brandsDetailVM);

        void showFilterMenu(List<FilterMenuModel> filterMenuModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void brandsDetailRequest(Map<String, Object> params);

        void filterMenuRequest(Map<String, Object> params);
    }

}

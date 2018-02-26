package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.BrandsVM;

import java.util.List;
import java.util.Map;

public class BrandsPageContract {

    interface View extends BaseView {

        void showResult(List<BrandsVM> brandsVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void brandsPageRequest(Map<String, Object> params);
    }

}

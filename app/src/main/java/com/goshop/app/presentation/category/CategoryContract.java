package com.goshop.app.presentation.category;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.CategoriesParentVM;

import java.util.List;

public class CategoryContract {

    interface View extends BaseView {

        void onCategoryRequestSuccess(List<CategoriesParentVM> categoryMenuResponse);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void getCategory();
    }

}

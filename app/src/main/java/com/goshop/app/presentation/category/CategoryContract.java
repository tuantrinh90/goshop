package com.goshop.app.presentation.category;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.CategoryResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.CategoriesParentVM;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;

import java.util.List;
import java.util.Map;

public class CategoryContract {

    interface View extends BaseView {

        void showLeftMenu(List<CategoryLeftMenuVM> leftMenuVMS);

        void showRightMenu(List<CategoryRightMenuModel> rightMenuModels);

        void onCategoryRequestSuccess(List<CategoriesParentVM> categoryMenuResponse);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String message);
    }

    public interface Presenter extends BasePresenter<View> {

        void getCategory();

        void categoryRightMenuRequest(Map<String, Object> params);
    }

}

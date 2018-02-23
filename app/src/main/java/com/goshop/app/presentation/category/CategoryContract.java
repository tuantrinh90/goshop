package com.goshop.app.presentation.category;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;

import java.util.List;
import java.util.Map;

public class CategoryContract {

    interface View extends BaseView {

        void showLeftMenu(List<CategoryLeftMenuVM> leftMenuVMS);

        void showRightMenu(List<CategoryRightMenuModel> rightMenuModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void getCategoryLeftMenu();

        void categoryRightMenuRequest(Map<String, Object> params);
    }

}

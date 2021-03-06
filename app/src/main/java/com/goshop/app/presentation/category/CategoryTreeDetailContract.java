package com.goshop.app.presentation.category;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SortVM;

import java.util.List;
import java.util.Map;

public class CategoryTreeDetailContract {

    interface View extends BaseView {

        void categoryDetailResult(List<SearchFilterModel> filterModels);

        void categoryDetailNoData(List<SearchFilterModel> filterModels);

        void showFilterMenu(List<FilterMenuModel> filterMenuModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void categoryDetailRequest(Map<String, Object> params);

        void filterMenuRequest(Map<String, Object> params);

        List<SortVM> getSortVMS();
    }
}

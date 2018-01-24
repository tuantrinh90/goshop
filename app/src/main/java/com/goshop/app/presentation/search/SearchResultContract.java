package com.goshop.app.presentation.search;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SearchFilterModel;

import java.util.List;
import java.util.Map;

/**
 * Created by helen on 2018/1/19.
 */

public class SearchResultContract {

    interface View extends BaseView {

        void showResult(List<SearchFilterModel> datas);

        void showFilterMenu(List<FilterMenuModel> filterMenuModels);
    }

    public interface Presenter extends BasePresenter<View> {

        void searchResultRequest(Map<String, Object> params);

        void filterMenuRequest(Map<String, Object> params);
    }
}

package com.goshop.app.presentation.search;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.SearchFilterModel;

import java.util.List;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchContract {

    interface View extends BaseView {

        void showSuggestResult(List<SearchFilterModel> models);

        void showFilterResult(List<SearchFilterModel> models);
    }

    public interface Presenter extends BasePresenter<View> {

        void searchFilter(String keyWords);
    }

}

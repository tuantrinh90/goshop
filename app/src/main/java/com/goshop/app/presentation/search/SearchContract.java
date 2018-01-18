package com.goshop.app.presentation.search;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;

/**
 * Created by helen on 2018/1/18.
 */

public class SearchContract {

    interface View extends BaseView {

        void showNoDataLayout();

        void hideNoDataLayout();

        void showFilterResult(String keyWords);
    }

    public interface Presenter extends BasePresenter<View> {

        void searchFilter(String keyWords);


    }

}

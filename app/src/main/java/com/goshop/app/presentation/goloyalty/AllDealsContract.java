package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.presentation.model.SortVM;

import java.util.List;

public class AllDealsContract {

    interface View extends BaseView {

        void showAllDealsResult(List<GoLoyaltyDealsVM> dealsVMS);

        void showNetError();

        void getCategorySuccess(List<FilterMenuModel> filterMenuModels);

        void getStatusSuccess(List<FilterMenuModel> filterMenuModels);

        void showErrorMessage(String errorMessage);

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void getListDeals(int page, boolean isRefresh);

        void getFilterCategory();

        void getFilterStatus();

        List<SortVM> getSortVMS();
    }

}

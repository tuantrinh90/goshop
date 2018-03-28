package com.goshop.app.presentation.search;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;
import java.util.Map;

public class SearchResultContract {

    interface View extends BaseView {

        void showProductsData(List<ProductsVM> productsVMS);

        void showFilterMenu(List<FilterMenuModel> filterMenuModels);

    }

    public interface Presenter extends BasePresenter<View> {

        void searchResultRequest(Map<String, Object> params);

        void filterMenuRequest(Map<String, Object> params);

        List<SortVM> getSortVMS();
    }
}

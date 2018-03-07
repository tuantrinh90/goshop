package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.List;
import java.util.Map;

public class MyWishlistContract {

    interface View extends BaseView {

        void showNodata();

        void showWishlistResult(List<ProductsVM> productsVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void myWishlistRequest(Map<String, Object> params);
    }

}

package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.WishlistVM;

import java.util.List;

public class MyWishlistContract {

    interface View extends BaseView {

        void showWishlistItems(List<WishlistVM> wishlistVMS);

        void showError(String errorMessage);

        void deleteSuccess(List<WishlistVM> wishlistVMS);
    }

    public interface Presenter extends BasePresenter<View> {

        void wishlistDeleteRequest(String sku);

        void getWishlistItems();
    }

}

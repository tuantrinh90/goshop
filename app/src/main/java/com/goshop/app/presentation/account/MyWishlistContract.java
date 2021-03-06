package com.goshop.app.presentation.account;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.presentation.model.WishlistVM;

import java.util.List;

public class MyWishlistContract {

    interface View extends BaseView {

        void showWishlistItems(List<WishlistVM> wishlistVMS, PaginationData pagination);

        void deleteSuccess(List<WishlistVM> wishlistVMS);

        void showServiceErrorMessage(String errorMessage);

        void showNetworkErrorMessage(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void wishlistDeleteRequest(String sku);

        void getWishlistItems(int page, boolean isShowLoading);
    }

}

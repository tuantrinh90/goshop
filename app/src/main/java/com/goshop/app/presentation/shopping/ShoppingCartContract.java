package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ApplyDiscountVM;
import com.goshop.app.presentation.model.ShoppingCartProductVM;

public class ShoppingCartContract {

    interface View extends BaseView {

        void showCartDetail(ShoppingCartProductVM cartProductVM);

        void showNetError();

        void removeFailed(String errorMessage);

        void addWishlistSuccess();

        void showErrorMessage(String errorMessage);

        void applySuccess(ApplyDiscountVM discountVM);

        void stopRefresh();
    }

    public interface Presenter extends BasePresenter<View> {

        void viewCartDetails(int page, boolean isRefresh);

        void removeFromCartRequest(String sku, String qty);

        void addWishlistRequest(String skuId);

        void applyCoupon(String couponCode, String cartId);

        void updateCartRequest(String quoteItemId, String qty);
    }
}

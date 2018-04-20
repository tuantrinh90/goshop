package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ShoppingCartModel;

import java.util.List;
import java.util.Map;

public class ShoppingCartContract {

    interface View extends BaseView {

        void showCartDetail(List<ShoppingCartModel> cartModels);

        void removeSuccess();

        void removeFailed(String errorMessage);

        void addWishlistSuccess();

        void addWishlistFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void shoppingCartRequest(Map<String, Object> params);

        void removeFromCartRequest(String sku, String qty);

        void addWishlistRequest(String skuId);
    }
}

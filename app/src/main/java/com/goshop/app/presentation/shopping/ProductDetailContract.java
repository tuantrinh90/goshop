package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.ProductDetailModel;

import java.util.List;
import java.util.Map;

public class ProductDetailContract {

    interface View extends BaseView {

        void productDetailRequestSuccess(List<ProductDetailModel> detailDatas);

        void productBannerResult(List<String> imageUrls);

        void addWishlistSuccess();

        void removeWishlistSuccess();

        void addWishlistFailed(String errorMessage);

        void removeWishlistFailed(String errorMessage);

        void deliveryCheckRequestSuccess();

        void deliveryCheckRequestFailed(String errorMessage);
    }

    public interface Presenter extends BasePresenter<View> {

        void productDetailRequest(Map<String, Object> params);

        void addWishlistRequest(String skuId);

        void removeWishlistRequest(String skuId);

        void deliveryCheckRequest(String zipCode);
    }

}

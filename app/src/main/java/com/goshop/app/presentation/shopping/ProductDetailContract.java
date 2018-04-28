package com.goshop.app.presentation.shopping;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.data.model.request.AddRemoveCartRequest;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProfileVM;
import com.goshop.app.presentation.model.SizeVM;
import com.goshop.app.presentation.model.ColorVM;

import java.util.List;

public class ProductDetailContract {

    interface View extends BaseView {

        void getProductDetailSuccess(List<ProductDetailModel> detailDatas);

        void productBannerResult(List<String> imageUrls);

        void addWishlistSuccess();

        void removeWishlistSuccess();

        void addWishlistFailed(String errorMessage);

        void removeWishlistFailed(String errorMessage);

        void deliveryCheckRequestSuccess();

        void deliveryCheckRequestFailed(String errorMessage);

        void showNetError();

        void showFailedMessage(String errorMessage);

        void hideDataLayout();

        void setColorDatas(List<ColorVM> colorVMS);

        void setSizeDatas(List<SizeVM> sizeVMS);

        void getReviewsSuccess(List<ProductDetailModel> detailDatas);

        void getQASuccess(List<ProductDetailModel> detailDatas);

        void addToCartSuccess(int cartNum);

        void getUserProfileSuccess(ProfileVM profileVM);
    }

    public interface Presenter extends BasePresenter<View> {

        void getUserProfile();

        void getProductDetails();

        void getReviews();

        void getQA();

        void addWishlistRequest(String skuId);

        void removeWishlistRequest(String skuId);

        void deliveryCheckRequest(String zipCode);

        void addToCartRequest(String sku, String qty);
    }

}

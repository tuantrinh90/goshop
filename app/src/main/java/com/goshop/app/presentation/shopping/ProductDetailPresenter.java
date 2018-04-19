package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpAdditionalItemVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpQAVM;
import com.goshop.app.presentation.model.PdpReviewsVM;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProductDetailTopVM;
import com.goshop.app.presentation.model.SizeVM;
import com.goshop.app.presentation.model.widget.ColorVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.QAVM;
import com.goshop.app.presentation.model.widget.ReviewsVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ProductDetailPresenter extends RxPresenter<ProductDetailContract.View> implements
    ProductDetailContract.Presenter {

    private AccountRepository accountRepository;

    private ProductRepository productRepository;

    public ProductDetailPresenter(AccountRepository accountRepository,
        ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void productDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(productRepository.productDetailRequest(params).subscribeWith(
            new DisposableObserver<ProductDetailResponse>() {
                @Override
                public void onNext(ProductDetailResponse productDetailResponse) {
                    mView.hideLoadingBar();
                    //todo(helen)wait for api
                    mView.productDetailRequestSuccess(null);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //todo(helen)wait for api
                    mView.productDetailRequestSuccess(getMockData());
                    mView.productBannerResult(getBanners());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void addWishlistRequest(String skuId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_SKUID, skuId);
        addSubscrebe(accountRepository.addWishlistRequest(params).subscribeWith(
            new DisposableObserver<Response<MyWishlistResponse>>() {
                @Override
                public void onNext(Response<MyWishlistResponse> response) {
                    mView.hideLoadingBar();
                    mView.addWishlistSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.addWishlistFailed(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void removeWishlistRequest(String skuId) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_SKUID, skuId);
        addSubscrebe(accountRepository.wishlistDeleteRequest(params).subscribeWith(
            new DisposableObserver<Response<MyWishlistResponse>>() {
                @Override
                public void onNext(Response<MyWishlistResponse> response) {
                    mView.hideLoadingBar();
                    mView.removeWishlistSuccess();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.removeWishlistFailed(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void deliveryCheckRequest(String zipCode) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_POSTCODE, zipCode);
        addSubscrebe(productRepository.deliveryCheckRequest(params).subscribeWith(
            new DisposableObserver<Response<DeliveryCheckResponse>>() {
                @Override
                public void onNext(Response<DeliveryCheckResponse> response) {
                    mView.hideLoadingBar();
                    mView.deliveryCheckRequestSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.deliveryCheckRequestFailed(throwable.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private List<ProductDetailModel> getMockData() {
        //todo(helen)wait for complete
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(getProductTopData());
        detailModels.addAll(getProductSummary());
        detailModels.addAll(getProductsDetail());
        detailModels.addAll(getProductsDelivery());
        detailModels.addAll(getProductReviews());
        detailModels.addAll(getProductQuestionAnswer());
        detailModels.addAll(getAdditionalInformation());
        detailModels.addAll(getFrequentlyBoughtTogether());
        return detailModels;
    }

    private List<String> getBanners() {
        List<String> images = new ArrayList<>();
        images.add(
            "http://g.hiphotos.baidu" +
                ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        images.add("http://img843.ph.126.net/HQO2EzKsZ30Kvp03799Gyg==/883831426873459781.jpg");
        images.add(
            "http://g.hiphotos.baidu" +
                ".com/image/pic/item/9a504fc2d56285356bd508329aef76c6a7ef63e8.jpg");
        images.add(
            "http://a.hiphotos.baidu" +
                ".com/image/pic/item/503d269759ee3d6d453aab8b48166d224e4adef5.jpg");
        return images;
    }

    //todo(helen)this is mock data will delete when get api
    private ProductDetailTopVM getProductTopData() {
        List<ColorVM> colorVMS = new ArrayList<>();
        colorVMS.add(new ColorVM("Yellow", ""));
        colorVMS.add(new ColorVM("Red", ""));
        List<SizeVM> sizeVMS = new ArrayList<>();
        sizeVMS.add(new SizeVM("XL"));
        sizeVMS.add(new SizeVM("L"));
        return new ProductDetailTopVM(
            "Kloken Living Box Value Set Kloken Living Box Value Set",
            "RM 269.00", "RM 199.00", "-30%", colorVMS, sizeVMS, "2");
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getProductSummary() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Product Summary"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_SINGLE_TEXT));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getProductsDetail() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Details"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_SINGLE_TEXT));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getProductsDelivery() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(false, false, "Delivery Info"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_DELIVERY_INFO));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getProductReviews() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Reviews"));
        List<ReviewsVM> reviewsVMS = new ArrayList<>();
        ReviewsVM reviewsVM = new ReviewsVM(4, "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "User Name", "1/2/18");
        reviewsVMS.add(reviewsVM);
        reviewsVMS.add(reviewsVM);
        detailModels.add(new PdpReviewsVM(5, "(100)", reviewsVMS));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getProductQuestionAnswer() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Q&A"));

        QAVM qavm = new QAVM("3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
            "1/2/2018");
        List<QAVM> qavms = new ArrayList<>();
        qavms.add(qavm);
        qavms.add(qavm);
        detailModels.add(new PdpQAVM("10", "10", qavms));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getAdditionalInformation() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Additional Information"));

        List<PdpAdditionalItemVM> additionalItemVMS = new ArrayList<>();

        additionalItemVMS.add(new PdpAdditionalItemVM("A/S Processing Standard", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Quality Guarantee Period", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Basic Constitution", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Precaution", "N/A"));
        additionalItemVMS
            .add(new PdpAdditionalItemVM("Return/Cancel Processing Standard", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Model Name", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Material", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Product Features", "N/A"));
        detailModels.add(new PdpAdditionalInformationVM(additionalItemVMS));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private List<ProductDetailModel> getFrequentlyBoughtTogether() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(false, false, "Frequently Bought Together"));
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "RM 149.00", "RM 200.00");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductsVM> productsVMS = new ArrayList<>();
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        detailModels.add(new PdpFrequentlyBoughtTogetherVM(productsVMS));
        return detailModels;
    }


}

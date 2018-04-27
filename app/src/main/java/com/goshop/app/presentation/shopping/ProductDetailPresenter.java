package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.request.AddRemoveCartRequest;
import com.goshop.app.data.model.request.common.CartRequestData;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.ProductDetailResponse;
import com.goshop.app.data.model.response.DeliveryCheckResponse;
import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.AllReviewsMapper;
import com.goshop.app.presentation.mapper.ProductDetailMapper;
import com.goshop.app.presentation.mapper.QuestionAnswerMapper;

import java.util.HashMap;
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
    public void getProductDetails() {
        mView.showLoadingBar();
        mView.hideDataLayout();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        addSubscrebe(productRepository.getProductDetails(params).subscribeWith(
            new DisposableObserver<Response<ProductDetailResponse>>() {
                @Override
                public void onNext(Response<ProductDetailResponse> response) {
                    mView.hideLoadingBar();
                    mView.productBannerResult(
                        ProductDetailMapper.transformBanner(response.getData()));
                    mView
                        .getProductDetailSuccess(ProductDetailMapper.transform(response.getData()));
                    mView.setColorDatas(ProductDetailMapper.transformColorVMs(response.getData()));
                    mView.setSizeDatas(ProductDetailMapper.transformSizeVMs(response.getData()));
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.showFailedMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.showNetError();
                    }
                }

                @Override
                public void onComplete() {
                }
            }));
    }

    @Override
    public void getReviews() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_PAGE, 1);
        params.put(Const.PARAMS_LIMIT, 2);
        addSubscrebe(accountRepository.getProductRatingReviews(params).subscribeWith(
            new DisposableObserver<Response<AllReviewsResponse>>() {
                @Override
                public void onNext(Response<AllReviewsResponse> response) {
                    mView.hideLoadingBar();
                    mView.getReviewsSuccess(ProductDetailMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    if (e instanceof ServiceApiFail) {
                        mView.showFailedMessage(((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showFailedMessage(e.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getQA() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_PAGE, 1);
        params.put(Const.PARAMS_LIMIT, 2);
        addSubscrebe(productRepository.listProductQA(params).subscribeWith(
            new DisposableObserver<Response<QuestionAnswerResponse>>() {
                @Override
                public void onNext(Response<QuestionAnswerResponse> response) {
                    mView.hideLoadingBar();
                    mView.getQASuccess(ProductDetailMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.hideDataLayout();
                    if (e instanceof ServiceApiFail) {
                        mView.showFailedMessage(((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showFailedMessage(e.getMessage().toString());
                    }
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
                    mView.hideLoadingBar();
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

    @Override
    public void addToCartRequest(String sku, String qty) {
        mView.showLoadingBar();
        AddRemoveCartRequest request = new AddRemoveCartRequest();
        CartRequestData cartRequestData = new CartRequestData();
        cartRequestData.setSku(sku);
        cartRequestData.setQty(qty);
        cartRequestData.setStoreId(Const.STORE_ID);
        cartRequestData.setWebsiteId(Const.WEBSITE_ID);
        request.setRequest(cartRequestData);
        addSubscrebe(productRepository.addToCartRequest(request).subscribeWith(
            new DisposableObserver<Response<CartDataResponse>>() {
                @Override
                public void onNext(Response<CartDataResponse> response) {
                    mView.hideLoadingBar();
                    mView.addToCartResult(true, response.getMessage().getDisplayMessage());
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if(throwable instanceof ServiceApiFail) {
                        mView.addToCartResult(false, ((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.addToCartResult(false, throwable.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}

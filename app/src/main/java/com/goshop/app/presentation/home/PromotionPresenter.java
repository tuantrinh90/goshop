package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.PromotionBannerCenterVM;
import com.goshop.app.presentation.model.PromotionBannerModel;
import com.goshop.app.presentation.model.PromotionBannerScrollerVM;
import com.goshop.app.presentation.model.PromotionBannerTopVM;
import com.goshop.app.presentation.model.widget.OfferListItemsVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.JToolUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class PromotionPresenter extends RxPresenter<PromotionContract.View> implements
    PromotionContract.Presenter {

    private ProductRepository repository;

    @Inject
    public PromotionPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getPromotionList(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(repository.promotionListRequest(params).subscribeWith(
            new DisposableObserver<PromotionListResponse>() {
                @Override
                public void onNext(PromotionListResponse response) {
                    mView.hideLoadingBar();
                    //todo wait for decide
//                    mView.showPromotionList(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getPromotionBanner(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(repository.promotionBannerRequest(params).subscribeWith(
            new DisposableObserver<PromotionBannerResponse>() {
                @Override
                public void onNext(PromotionBannerResponse response) {
                    JToolUtils.printObject(response);
                    mView.hideLoadingBar();
//                    mView.showPromotionBanner(response);
                    mView.showPromotionBannerResult(getMockDatas());
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo wait for api
    private List<PromotionBannerModel> getMockDatas() {
        List<PromotionBannerModel> models = new ArrayList<>();
        PromotionBannerTopVM bannerTopVM = new PromotionBannerTopVM("",
            R.drawable.ic_samsung_detail);
        PromotionBannerCenterVM bannerCenterVM = new PromotionBannerCenterVM(getSinglePicture());
        PromotionBannerScrollerVM scrollerVM = new PromotionBannerScrollerVM(
            getWidgetProductScrollerVM());

        models.add(bannerTopVM);
        models.add(bannerCenterVM);
        models.add(scrollerVM);
        models.add(bannerCenterVM);
        models.add(bannerCenterVM);
        models.add(scrollerVM);
        return models;
    }

    //TODO(helen) this is mock data
    private OfferListItemsVM getSinglePicture() {
        OfferListItemsVM offerListItemsVM = new OfferListItemsVM(R.drawable.ic_detail_top_demo, "",
            "");
        return offerListItemsVM;
    }

    //TODO(helen) this is mock data
    private List<ProductsVM> getWidgetProductScrollerVM() {
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
        return productsVMS;
    }
}

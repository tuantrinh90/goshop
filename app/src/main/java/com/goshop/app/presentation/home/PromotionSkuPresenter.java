package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.PromotionSkuModel;
import com.goshop.app.data.model.PromotionSkuResponse;
import com.goshop.app.data.model.SkuBannerVM;
import com.goshop.app.data.model.SkuFilterWithDataVM;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.FilterFlowVM;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuFlowButtonVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.FilterMenuPriceVM;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class PromotionSkuPresenter extends RxPresenter<PromotionSkuContract.View> implements
    PromotionSkuContract.Presenter {

    private ProductRepository repository;

    public PromotionSkuPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void promotionSkuRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(repository.promotionSkuRequest(params).subscribeWith(
            new DisposableObserver<PromotionSkuResponse>() {
                @Override
                public void onNext(PromotionSkuResponse promotionSkuResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showPromotionResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<PromotionSkuModel> getMockData() {
        SortVM sortVM1 = new SortVM("New Arrivals");
        SortVM sortVM2 = new SortVM("Price from Low to High");
        SortVM sortVM3 = new SortVM("Name A to Z");
        SortVM sortVM4 = new SortVM("Promotion");
        List<SortVM> sortVMS = new ArrayList<>();
        sortVMS.add(sortVM1);
        sortVMS.add(sortVM2);
        sortVMS.add(sortVM3);
        sortVMS.add(sortVM4);
        List<PromotionSkuModel> skuModels = new ArrayList<>();
        SkuBannerVM bannerVM = new SkuBannerVM("", R.drawable.ic_banner_demo);
        SkuFilterWithDataVM withDataVM = new SkuFilterWithDataVM(getProductsVMS(), sortVMS,
            getFilterMenu());
        skuModels.add(bannerVM);
        skuModels.add(withDataVM);
        return skuModels;
    }

    //todo this is mock data, please do not delete
    private List<ProductsVM> getProductsVMS() {
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
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        return productsVMS;
    }

    //todo this is mock data, please do not delete
    private List<FilterMenuModel> getFilterMenu() {
        List<FilterMenuModel> filterMenuModels = new ArrayList<>();
        filterMenuModels.add(new FilterMenuExpandVM("Category", true));
        filterMenuModels.add(new FilterMenuFlowButtonVM(getCategorys()));
        filterMenuModels.add(new FilterMenuExpandVM("Brands", true));
        filterMenuModels.add(new FilterMenuFlowButtonVM(getCategorys()));
        filterMenuModels.add(new FilterMenuExpandVM("Price(RM)", false));
        filterMenuModels.add(new FilterMenuPriceVM());
        return filterMenuModels;
    }

    //todo  this is mock data, please do not delete
    private List<FilterFlowVM> getCategorys() {
        List<FilterFlowVM> categorys = new ArrayList<>();
        categorys.add(new FilterFlowVM("", "Beauty"));
        categorys.add(new FilterFlowVM("", "Fashion"));
        categorys.add(new FilterFlowVM("", "Applicance"));
        categorys.add(new FilterFlowVM("", "Kids & Baby"));
        categorys.add(new FilterFlowVM("", "Digital & Electronic"));
        categorys.add(new FilterFlowVM("", "Living"));
        categorys.add(new FilterFlowVM("", "Sports & Leisure"));
        categorys.add(new FilterFlowVM("", "Others"));
        return categorys;
    }
}

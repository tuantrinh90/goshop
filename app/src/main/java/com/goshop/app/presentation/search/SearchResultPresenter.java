package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuFlowButtonVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.FilterMenuPriceVM;
import com.goshop.app.presentation.model.SearchResultVM;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.VideoProductsVM;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class SearchResultPresenter extends RxPresenter<SearchResultContract.View> implements
    SearchResultContract.Presenter {

    private ProductRepository repository;

    public SearchResultPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void searchResultRequest(Map<String, Object> params) {
        //TODO  the null is just for mock data, waiting for api
        addSubscrebe(repository.searchResultResponse(null).subscribeWith(
            new DisposableObserver<SearchResultResponse>() {
                @Override
                public void onNext(SearchResultResponse searchResultResponse) {
                    //TODO  wait for api
                }

                @Override
                public void onError(Throwable throwable) {
                    //TODO  wait for api
//                    List<SearchFilterModel> suggestModels = new ArrayList<>();
//                    suggestModels.addAll(getSuggestDatas());
//                    mView.onBandRequestSuccess(suggestModels);
                    mView.showProductsData(getProductsVMS());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data, please do not delete
    private List<VideoProductsVM> getProductsVMS() {
        VideoProductsVM productsVM = new VideoProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "RM 149.00", "RM 200.00");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<VideoProductsVM> productsVMS = new ArrayList<>();
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

    @Override
    public void filterMenuRequest(Map<String, Object> params) {
        //todo wait for api
        new Handler().post(() -> mView.showFilterMenu(getFilterMenu()));

    }

    @Override
    public List<SortVM> getSortVMS() {
        SortVM sortVM1 = new SortVM("New Arrivals");
        SortVM sortVM2 = new SortVM("Price from Low to High");
        SortVM sortVM3 = new SortVM("Name A to Z");
        SortVM sortVM4 = new SortVM("Promotion");
        List<SortVM> sortVMS = new ArrayList<>();
        sortVMS.add(sortVM1);
        sortVMS.add(sortVM2);
        sortVMS.add(sortVM3);
        sortVMS.add(sortVM4);
        return sortVMS;
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
    private List<String> getCategorys() {
        List<String> categorys = new ArrayList<>();
        categorys.add("Beauty");
        categorys.add("Fashion");
        categorys.add("Applicance");
        categorys.add("Kids & Baby");
        categorys.add("Digital & Electronic");
        categorys.add("Living");
        categorys.add("Sports & Leisure");
        categorys.add("Others");
        return categorys;
    }

    //todo this is mock data, please do not delete
    private List<SearchResultVM> getSuggestDatas() {
        List<SearchResultVM> filterModels = new ArrayList<>();
        SearchResultVM searchResultVM1 = new SearchResultVM(R.drawable.ic_bought, 0,
            R.drawable.ic_tv, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM2 = new SearchResultVM(R.drawable.ic_bought,
            R.drawable.ic_gift,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM3 = new SearchResultVM(R.drawable.ic_bought, 0,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");

        SearchResultVM searchResultVM4 = new SearchResultVM(R.drawable.ic_bought, 0,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM5 = new SearchResultVM(R.drawable.ic_bought, 0,
            0, true, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM6 = new SearchResultVM(R.drawable.ic_bought, 0,
            0, false, true, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        filterModels.add(searchResultVM1);
        filterModels.add(searchResultVM2);
        filterModels.add(searchResultVM3);
        filterModels.add(searchResultVM4);
        filterModels.add(searchResultVM5);
        filterModels.add(searchResultVM6);
        filterModels.add(searchResultVM1);
        filterModels.add(searchResultVM2);
        filterModels.add(searchResultVM3);
        filterModels.add(searchResultVM4);
        filterModels.add(searchResultVM5);
        filterModels.add(searchResultVM6);
        return filterModels;
    }
}

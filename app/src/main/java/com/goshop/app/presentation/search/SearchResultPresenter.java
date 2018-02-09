package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SearchResultResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.FilterMenuBrandsVM;
import com.goshop.app.presentation.model.FilterMenuCategoryVM;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.FilterMenuPriceVM;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SearchResultVM;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/19.
 */

public class SearchResultPresenter extends RxPresenter<SearchResultContract.View> implements
    SearchResultContract.Presenter {

    private AccountRepository accountRepository;

    public SearchResultPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void searchResultRequest(Map<String, Object> params) {
        //TODO(helen) the null is just for mock data, waiting for api
        addSubscrebe(accountRepository.searchResultResponse(null).subscribeWith(
            new DisposableObserver<SearchResultResponse>() {
                @Override
                public void onNext(SearchResultResponse searchResultResponse) {
                    //TODO(helen) wait for api
                }

                @Override
                public void onError(Throwable throwable) {
                    //TODO(helen) wait for api
                    List<SearchFilterModel> suggestModels = new ArrayList<>();
                    suggestModels.addAll(getSuggestDatas());
                    mView.showResult(suggestModels);
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void filterMenuRequest(Map<String, Object> params) {
        //todo wait for api
        new Handler().post(()-> mView.showFilterMenu(getFilterMenu()));

    }
    //todo(helen) this is mock data, please do not delete
    private List<FilterMenuModel> getFilterMenu() {
        List<FilterMenuModel> filterMenuModels = new ArrayList<>();
        filterMenuModels.add(new FilterMenuExpandVM("Category", true));
        filterMenuModels.add(new FilterMenuCategoryVM(getCategorys()));
        filterMenuModels.add(new FilterMenuExpandVM("Brands", true));
        filterMenuModels.add(new FilterMenuBrandsVM());
        filterMenuModels.add(new FilterMenuExpandVM("Price(RM)", false));
        filterMenuModels.add(new FilterMenuPriceVM());
        return filterMenuModels;
    }
    //todo(helen) this is mock data, please do not delete
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

    //todo(helen) this is mock data, please do not delete
    private List<SearchResultVM> getSuggestDatas() {
        List<SearchResultVM> filterModels = new ArrayList<>();
        SearchResultVM searchResultVM1 = new SearchResultVM(R.mipmap.bought, 0,
            R.mipmap.tv, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM2 = new SearchResultVM(R.mipmap.bought, R.mipmap.gift,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM3 = new SearchResultVM(R.mipmap.bought, 0,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");

        SearchResultVM searchResultVM4 = new SearchResultVM(R.mipmap.bought, 0,
            0, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM5 = new SearchResultVM(R.mipmap.bought, 0,
            0, true, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM6 = new SearchResultVM(R.mipmap.bought, 0,
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

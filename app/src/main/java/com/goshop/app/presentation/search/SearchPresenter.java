package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.SearchFilterResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.model.SearchCategoryVM;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SearchKeywordsVM;
import com.goshop.app.presentation.model.SearchPopularDetailVM;
import com.goshop.app.presentation.model.SearchResultVM;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class SearchPresenter extends RxPresenter<SearchContract.View> implements SearchContract
    .Presenter {

    private ProductRepository repository;

    public SearchPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void searchFilter(String keyWords) {

        //TODO  the null is just for mock data, waiting for api
        addSubscrebe(repository.searchFilterRequest(null).subscribeWith(
            new DisposableObserver<SearchFilterResponse>() {
                @Override
                public void onNext(SearchFilterResponse searchFilterResponse) {
                    //TODO  wait for api
                }

                @Override
                public void onError(Throwable throwable) {
                    //TODO  wait for api
                    List<SearchFilterModel> displayFilterModels = new ArrayList<>();
                    List<SearchCategoryVM> categoryVMS = getCategorysDatas();
                    List<SearchKeywordsVM> keywordsVMS = getKeywordsDatas();
                    List<SearchFilterModel> filterModels = new ArrayList<>();
                    for (SearchCategoryVM categoryVM : categoryVMS) {
                        if (categoryVM.getKeywords().toLowerCase()
                            .contains(keyWords.toLowerCase())) {
                            filterModels.add(categoryVM);
                        }
                    }
                    if (filterModels.size() > 0) {
                        displayFilterModels.addAll(filterModels);
                    }
                    filterModels.clear();
                    for (SearchKeywordsVM keywordsVM : keywordsVMS) {
                        if (keywordsVM.getKeywords().toLowerCase()
                            .contains(keyWords.toLowerCase())) {
                            filterModels.add(keywordsVM);
                        }
                    }
                    if (filterModels.size() > 0) {
                        displayFilterModels.addAll(filterModels);
                    }

                    if (displayFilterModels.isEmpty()) {
                        displayFilterModels
                            .add(new SearchFilterModel(SearchFilterModel.SEARCH_NO_DATA));
                        mView.showFilterResult(displayFilterModels);
                        List<SearchFilterModel> suggestModels = new ArrayList<>();
                        suggestModels.addAll(getSuggestDatas());
                        mView.showSuggestResult(suggestModels);
                    } else {
                        displayFilterModels.addAll(getPopularDetail());
                        mView.showFilterResult(displayFilterModels);
                    }

                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo(helen) this is mock data, please do not delete
    private List<SearchCategoryVM> getCategorysDatas() {
        List<SearchCategoryVM> filterModels = new ArrayList<>();
        SearchCategoryVM categoryVM1 = new SearchCategoryVM("aaa", "Sports");
        SearchCategoryVM categoryVM2 = new SearchCategoryVM("bb", "Sports");
        SearchCategoryVM categoryVM3 = new SearchCategoryVM("ccc", "Foot");
        SearchCategoryVM categoryVM4 = new SearchCategoryVM("aca", "ABC");
        SearchCategoryVM categoryVM5 = new SearchCategoryVM("ab", "Sports");
        SearchCategoryVM categoryVM6 = new SearchCategoryVM("qa", "Books");
        filterModels.add(categoryVM1);
        filterModels.add(categoryVM2);
        filterModels.add(categoryVM3);
        filterModels.add(categoryVM4);
        filterModels.add(categoryVM5);
        filterModels.add(categoryVM6);
        return filterModels;
    }

    //todo  this is mock data, please do not delete
    private List<SearchKeywordsVM> getKeywordsDatas() {
        List<SearchKeywordsVM> filterModels = new ArrayList<>();
        SearchKeywordsVM keywordsVM1 = new SearchKeywordsVM("abc 3");
        SearchKeywordsVM keywordsVM2 = new SearchKeywordsVM("aAbc 4");
        SearchKeywordsVM keywordsVM3 = new SearchKeywordsVM("AAc 5");
        SearchKeywordsVM keywordsVM4 = new SearchKeywordsVM("AAc adda");
        SearchKeywordsVM keywordsVM5 = new SearchKeywordsVM("BB 4ad");
        SearchKeywordsVM keywordsVM6 = new SearchKeywordsVM("Asdfaa 5");
        filterModels.add(keywordsVM1);
        filterModels.add(keywordsVM2);
        filterModels.add(keywordsVM3);
        filterModels.add(keywordsVM4);
        filterModels.add(keywordsVM5);
        filterModels.add(keywordsVM6);
        return filterModels;
    }

    //todo(helen) this is mock data, please do not delete
    private List<SearchResultVM> getSuggestDatas() {
        List<SearchResultVM> filterModels = new ArrayList<>();
        SearchResultVM searchResultVM1 = new SearchResultVM(R.drawable.ic_bought, 0,
            R.drawable.ic_tv, false, false, "RM 299.00", "RM 399.00", "30% OFF",
            "Manjung Korean Crispy Seaweed (S");
        SearchResultVM searchResultVM2 = new SearchResultVM(R.drawable.ic_bought, R.drawable.ic_gift,
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

    //todo  this is mock data, please do not delete
    private List<SearchFilterModel> getPopularDetail() {
        List<SearchFilterModel> filterModels = new ArrayList<>();
        SearchPopularDetailVM popularDetailVM1 = new SearchPopularDetailVM(R.drawable.ic_bought,
            "Manjung Korean Crispy Seaweed (Sea Salt) Seaweed (Sea Salt)", "RM 233.00",
            "RM 119.00");
        SearchPopularDetailVM popularDetailVM2 = new SearchPopularDetailVM(R.drawable.ic_bought,
            "Manjung Korean Crispy Seaweed (Sea Salt) Seaweed (Sea Salt)", "RM 233.00",
            "RM 119.00");
        filterModels.add(new SearchFilterModel(SearchFilterModel.SEARCH_POPULAR_TITLE));
        filterModels.add(popularDetailVM1);
        filterModels.add(popularDetailVM2);
        return filterModels;
    }
}

package com.goshop.app.presentation.goloyalty;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.AllDealsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuFlowButtonVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.presentation.model.SortVM;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AllDealsPresenter extends RxPresenter<AllDealsContract.View> implements
    AllDealsContract.Presenter {

    private AccountRepository accountRepository;

    public AllDealsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void allDealsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.allDealsRequest(params).subscribeWith(
            new DisposableObserver<AllDealsResponse>() {
                @Override
                public void onNext(AllDealsResponse allDealsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showAllDealsResult(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private List<GoLoyaltyDealsVM> getMockDatas() {
        GoLoyaltyDealsVM dealsVM = new GoLoyaltyDealsVM("", R.drawable.ic_deals,
            "Starbucks(Merchant)",
            "Buy 1 cup and get 1 cup", "12 Jan 2017 - 14 Jan 2017", "Kuala Lumpor");
        List<GoLoyaltyDealsVM> dealsVMS = new ArrayList<>();
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        dealsVMS.add(dealsVM);
        return dealsVMS;
    }

    @Override
    public void filterMenuRequest(Map<String, Object> params) {
//todo wait for api
        new Handler().post(() -> mView.showFilterMenu(getFilterMenu()));
    }

    @Override
    public List<SortVM> getSortVMS() {
        SortVM sortVM1 = new SortVM("Latest");
        SortVM sortVM2 = new SortVM("Hot");
        SortVM sortVM3 = new SortVM("Nearby (drop 2)");
        List<SortVM> sortVMS = new ArrayList<>();
        sortVMS.add(sortVM1);
        sortVMS.add(sortVM2);
        sortVMS.add(sortVM3);
        return sortVMS;
    }

    //todo this is mock data, please do not delete
    private List<FilterMenuModel> getFilterMenu() {
        List<FilterMenuModel> filterMenuModels = new ArrayList<>();
        filterMenuModels.add(new FilterMenuExpandVM("Category", true));
        filterMenuModels.add(new FilterMenuFlowButtonVM(getCategorys()));
        filterMenuModels.add(new FilterMenuExpandVM("Status", true));
        filterMenuModels.add(new FilterMenuFlowButtonVM(getStatus()));
        return filterMenuModels;
    }

    //todo  this is mock data, please do not delete
    private List<String> getCategorys() {
        List<String> categorys = new ArrayList<>();
        categorys.add("All");
        categorys.add("Healty");
        categorys.add("Food");
        categorys.add("Entertainment");
        return categorys;
    }

    //todo  this is mock data, please do not delete
    private List<String> getStatus() {
        List<String> categorys = new ArrayList<>();
        categorys.add("All");
        categorys.add("Downloaded");
        categorys.add("New");
        return categorys;
    }
}

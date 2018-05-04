package com.goshop.app.presentation.goloyalty;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.DealsResponse;
import com.goshop.app.data.model.response.FilterCategoryResponse;
import com.goshop.app.data.model.response.FilterStatusResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.FilterDataMapper;
import com.goshop.app.presentation.mapper.GoLoyaltyDealsMapper;
import com.goshop.app.presentation.model.SortVM;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class AllDealsPresenter extends RxPresenter<AllDealsContract.View> implements
    AllDealsContract.Presenter {

    private AccountRepository accountRepository;

    public AllDealsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getListDeals(int page, boolean isRefresh) {
        //todo wait for api
//        Map<String, Object> params = new HashMap<>();
        if (!isRefresh) {
            mView.showLoadingBar();
        }
        addSubscrebe(accountRepository.getListDeals().subscribeWith(
            new DisposableObserver<Response<DealsResponse>>() {
                @Override
                public void onNext(Response<DealsResponse> response) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    mView.showAllDealsResult(GoLoyaltyDealsMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.stopRefresh();
                    if (e instanceof ServiceApiFail) {
                        mView.showErrorMessage(((ServiceApiFail) e).getErrorMessage());
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
    public void getFilterCategory() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getFilterCategory().subscribeWith(
            new DisposableObserver<Response<FilterCategoryResponse>>() {
                @Override
                public void onNext(Response<FilterCategoryResponse> response) {
                    mView.hideLoadingBar();
                    mView.getCategorySuccess(
                        FilterDataMapper.transformDealCategory(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    if (e instanceof ServiceApiFail) {
                        mView.showErrorMessage(((ServiceApiFail) e).getErrorMessage());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getFilterStatus() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getFilterStatus().subscribeWith(
            new DisposableObserver<Response<FilterStatusResponse>>() {
                @Override
                public void onNext(Response<FilterStatusResponse> response) {
                    mView.hideLoadingBar();
                    mView
                        .getStatusSuccess(FilterDataMapper.transformDealStatus(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    if (e instanceof ServiceApiFail) {
                        mView.showErrorMessage(((ServiceApiFail) e).getErrorMessage());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
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


}

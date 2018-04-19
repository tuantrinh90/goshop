package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.AllReviewsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.AllReviewsMapper;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AllReviewsPresenter extends RxPresenter<AllReviewsContract.View> implements
    AllReviewsContract.Presenter {

    private AccountRepository accountRepository;

    public AllReviewsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getProductRatingReviews(int page, boolean isRefresh) {
        if(!isRefresh) {
            mView.showLoadingBar();
            mView.hideDataLayout();
        }

        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_PAGE, page);
        params.put(Const.PARAMS_LIMIT, Const.LIMIT);
        addSubscrebe(accountRepository.getProductRatingReviews(params).subscribeWith(
            new DisposableObserver<Response<AllReviewsResponse>>() {
                @Override
                public void onNext(Response<AllReviewsResponse> response) {
                    mView.hideLoadingBar();
                    mView.showDataLayout();
                    mView.stopRefresh();
                    mView.showAllReviewsResult(AllReviewsMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.hideDataLayout();
                    mView.stopRefresh();
                    if (e instanceof ServiceApiFail) {
                        mView.showRequestFailed(((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showNetWorkError(e.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

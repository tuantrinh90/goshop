package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.mapper.GoShopPointsMapper;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyPointsPresenter extends RxPresenter<MyPointsContract.View> implements
    MyPointsContract.Presenter {

    AccountRepository accountRepository;

    public MyPointsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void getGoShopPointsDetails() {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.getGoShopPointsDetails().subscribeWith(
            new DisposableObserver<MyPointsResponse>() {
                @Override
                public void onNext(MyPointsResponse myPointsResponse) {
                    mView.hideLoadingBar();
                    mView.getPointDetailsSuccess(GoShopPointsMapper.transform(myPointsResponse));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.getPointDetailsFailed(e.getLocalizedMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

}

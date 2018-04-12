package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.GoShopPointsMapper;

import io.reactivex.observers.DisposableObserver;

public class MyPointsPresenter extends RxPresenter<MyPointsContract.View> implements
    MyPointsContract.Presenter {

    private ProductRepository repository;

    public MyPointsPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getGoShopPointsDetails() {
        mView.showLoadingBar();
        addSubscrebe(repository.getGoShopPointsDetails().subscribeWith(
            new DisposableObserver<Response<MyPointsResponse>>() {
                @Override
                public void onNext(Response<MyPointsResponse> response) {
                    mView.hideLoadingBar();
                    mView.getPointDetailsSuccess(GoShopPointsMapper.transform(response));
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

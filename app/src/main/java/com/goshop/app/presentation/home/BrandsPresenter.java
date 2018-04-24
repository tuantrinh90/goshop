package com.goshop.app.presentation.home;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.BrandMapper;
import com.goshop.app.presentation.model.BrandsListVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class BrandsPresenter extends RxPresenter<BrandsContract.View> implements
    BrandsContract.Presenter {

    private ProductRepository repository;

    public BrandsPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void brandsRequest(int page, boolean isShowLoading) {
        if (isShowLoading) mView.showLoadingBar();
        HashMap<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        params.put(Const.REQUEST_PARAM_LIMIT, Const.LIMIT);
        params.put(Const.REQUEST_PARAM_PAGE, page);
        addSubscrebe(repository.brandsRequest(params)
            .subscribeWith(new DisposableObserver<Response<BrandsResponse>>() {
                @Override
                public void onNext(Response<BrandsResponse> response) {
                    mView.hideLoadingBar();
                    mView.onBandRequestSuccess(BrandMapper.transform(response, page),
                        response.getData().getPagination());
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        ServiceApiFail serviceApiFail = (ServiceApiFail) throwable;
                        mView.showServiceErrorMessage(serviceApiFail.getErrorMessage());
                    } else {
                        mView.showNetworkErrorMessage(throwable.getMessage());
                    }
                }

                @Override
                public void onComplete() {
                    mView.hideLoadingBar();
                }
            }));
    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyPointsResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.PaginationData;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.GoShopPointsMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyPointsPresenter extends RxPresenter<MyPointsContract.View> implements
    MyPointsContract.Presenter {

    private ProductRepository repository;

    public PaginationData paginationData;

    public MyPointsPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getGoShopPointsDetails(int page, boolean isShowLoading) {
        if (isShowLoading) mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_PAGE, page);
        params.put(Const.REQUEST_PARAM_LIMIT, Const.LIMIT);
        addSubscrebe(repository.getGoShopPointsDetails(params).subscribeWith(
            new DisposableObserver<Response<MyPointsResponse>>() {
                @Override
                public void onNext(Response<MyPointsResponse> response) {
                    mView.hideLoadingBar();
                    paginationData = response.getData().getPagination();
                    mView.getPointDetailsSuccess(GoShopPointsMapper.transform(response,page),
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

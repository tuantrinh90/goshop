package com.goshop.app.presentation.category;

import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.CategoryResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.CategoryMapper;
import com.goshop.app.presentation.model.CategoryLeftMenuVM;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;
import com.goshop.app.presentation.model.CategoryRightParentVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class CategoryPresenter extends RxPresenter<CategoryContract.View> implements
    CategoryContract.Presenter {

    private ProductRepository repository;

    public CategoryPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getCategory() {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.REQUEST_PARAM_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.REQUEST_PARAM_STORE_ID, Const.STORE_ID);
        addSubscrebe(repository.getCategory(params).subscribeWith(
            new DisposableObserver<Response<CategoryResponse>>() {
                @Override
                public void onNext(Response<CategoryResponse> categoryMenuResponse) {
                    mView.hideLoadingBar();
                    mView.onCategoryRequestSuccess(CategoryMapper.transform(categoryMenuResponse));
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

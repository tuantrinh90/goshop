package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.domian.ProductRepository;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class RatingPresenter extends RxPresenter<RatingContract.View>
    implements RatingContract.Presenter{

    private ProductRepository repository;

    public RatingPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void writeReviewRequest(String title, String content, float rating) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.PARAMS_CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.PARAMS_TITLE, title);
        params.put(Const.PARAMS_CONTENT, content);
        params.put(Const.PARAMS_RATING, rating);
        addSubscrebe(repository.writeReviewRequest(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response response) {
                    mView.hideLoadingBar();
                    mView.writeReviewSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.writeReviewFailed(throwable.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

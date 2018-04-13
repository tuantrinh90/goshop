package com.goshop.app.presentation.shopping;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.QuestionAnswerResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.ProductRepository;
import com.goshop.app.presentation.mapper.QuestionAnswerMapper;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AllQAPresenter extends RxPresenter<AllQAContract.View> implements AllQAContract
    .Presenter {

    private ProductRepository repository;

    public AllQAPresenter(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void allQARequest(Map<String, Object> params) {
        mView.showLoadingBar();
        mView.hideDataLayout();
        addSubscrebe(repository.allQARequest(params).subscribeWith(
            new DisposableObserver<Response<QuestionAnswerResponse>>() {
                @Override
                public void onNext(Response<QuestionAnswerResponse> response) {
                    mView.hideLoadingBar();
                    mView.showRequestSuccess(QuestionAnswerMapper.transform(response.getData()));
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.hideDataLayout();
                    if(e instanceof ServiceApiFail) {
                        mView.showRequestFailed( ((ServiceApiFail) e).getErrorMessage());
                    } else {
                        mView.showNetError(e.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void submitQuestions(String question) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        params.put(Const.CUSTOMER_ID, Const.CUSTOMER_ID);
        params.put(Const.QUESTION, question);

        addSubscrebe(repository.submitQuestions(params).subscribeWith(
            new DisposableObserver<Response>() {
                @Override
                public void onNext(Response response) {
                    mView.hideLoadingBar();
                    mView.showSubmitSuccess(response.getMessage().getDisplayMessage());
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showRequestFailed( e.getMessage().toString());
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

package com.goshop.app.presentation.shopping;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.QuestionAnswerResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class QADetailPresenter extends RxPresenter<QADetailContract.View> implements
    QADetailContract.Presenter {

    private AccountRepository accountRepository;

    public QADetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void qaDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.qaDetailRequest(params).subscribeWith(
            new DisposableObserver<QuestionAnswerResponse>() {
                @Override
                public void onNext(QuestionAnswerResponse questionAnswerResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showQADetail(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private List<QuestionAnswerDataVM> getMockDatas() {
        QuestionAnswerDataVM dataVM = new QuestionAnswerDataVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
            "By User Name on 1/2/18");
        List<QuestionAnswerDataVM> dataVMS = new ArrayList<>();
        dataVMS.add(dataVM);
        dataVMS.add(dataVM);
        dataVMS.add(dataVM);
        return dataVMS;
    }
}

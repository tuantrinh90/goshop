package com.goshop.app.presentation.shopping;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.QuestionAnswerResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;
import com.goshop.app.presentation.model.QuestionAnswerVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AllQAPresenter extends RxPresenter<AllQAContract.View> implements AllQAContract
    .Presenter {

    private AccountRepository accountRepository;

    public AllQAPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void allQARequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.allQARequest(params).subscribeWith(
            new DisposableObserver<QuestionAnswerResponse>() {
                @Override
                public void onNext(QuestionAnswerResponse questionAnswerResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showAllQAResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private QuestionAnswerVM getMockData() {
        QuestionAnswerDataVM dataVM = new QuestionAnswerDataVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit ",
            "All 12 Answers", "Updated at 1/2/2018");
        List<QuestionAnswerDataVM> dataVMS = new ArrayList<>();
        dataVMS.add(dataVM);
        dataVMS.add(dataVM);
        dataVMS.add(dataVM);
        return new QuestionAnswerVM("10", "10", dataVMS);
    }

}

package com.goshop.app.presentation.home;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.PromotionBannerResponse;
import com.goshop.app.data.model.response.PromotionListResponse;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.utils.JToolUtils;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by img on 2018/1/23.
 */

public class PromotionPresenter extends RxPresenter<PromotionContract.View> implements PromotionContract.Presenter {
    AccountRepository accountRepository;

    @Inject
    public PromotionPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void getPromotionList(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.promotionListRequest(params).subscribeWith(
            new DisposableObserver<PromotionListResponse>() {
                @Override
                public void onNext(PromotionListResponse response) {
                    mView.hideLoadingBar();
                    mView.showPromotionList(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if(throwable instanceof ServiceApiFail){
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    }else{
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void getPromotionBanner(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.promotionBannerRequest(params).subscribeWith(
            new DisposableObserver<PromotionBannerResponse>() {
                @Override
                public void onNext(PromotionBannerResponse response) {
                    JToolUtils.printObject(response);
                    mView.hideLoadingBar();
                    mView.showPromotionBanner(response);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if(throwable instanceof ServiceApiFail){
                        mView.showFaildMessage(((ServiceApiFail) throwable).getErrorMessage());
                    }else{
                        mView.showNetwordErrorMessage();
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

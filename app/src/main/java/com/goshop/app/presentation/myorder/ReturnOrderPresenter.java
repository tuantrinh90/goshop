package com.goshop.app.presentation.myorder;

import com.goshop.app.Const;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.OrderResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.retrofit.ServiceApiFail;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ProfileMetaVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class ReturnOrderPresenter extends RxPresenter<ReturnOrderContract.View>
    implements ReturnOrderContract.Presenter {

    private AccountRepository accountRepository;

    public ReturnOrderPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<ProfileMetaVM> getCodeChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("Code " + (i + 1)));
        }
        return profileMetaVMS;
    }

    @Override
    public List<ProfileMetaVM> getDetailChooses() {
        //todo this is mock data
        List<ProfileMetaVM> profileMetaVMS = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            profileMetaVMS.add(new ProfileMetaVM("Reason " + (i + 1)));
        }
        return profileMetaVMS;
    }

    @Override
    public void returnOrderRequest(String name, String email, String mobile, String handing,
        String reasonCode, String reasonDetail) {
        mView.showLoadingBar();
        Map<String, Object> params = new HashMap<>();
        params.put(Const.PARAMS_WEBSITE_ID, Const.WEBSITE_ID);
        params.put(Const.PARAMS_STORE_ID, Const.STORE_ID);
        //todo hard code are wait for pdp api
        params.put(Const.PARAMS_SKU, "123");
        params.put(Const.PARAMS_QTY, "2");
        params.put(Const.PARAMS_NAME, name);
        params.put(Const.PARAMS_EMAIL, email);
        params.put(Const.PARAMS_MOBILE_NUMBER, mobile);
        params.put(Const.PARAMS_PRODUCT_HANDLING, handing);
        params.put(Const.PARAMS_RETURN_REASON_CODE, reasonCode);
        params.put(Const.PARAMS_RETURN_DETAIL_REASON, reasonDetail);
        addSubscrebe(accountRepository.cancelOrderRequest(params).subscribeWith(
            new DisposableObserver<Response<OrderResponse>>() {
                @Override
                public void onNext(Response<OrderResponse> response) {
                    mView.hideLoadingBar();
                    mView.returnRequestSuccess();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    if (throwable instanceof ServiceApiFail) {
                        mView.returnRequestFailed(((ServiceApiFail) throwable).getErrorMessage());
                    } else {
                        mView.returnRequestNetError(throwable.getMessage().toString());
                    }
                }

                @Override
                public void onComplete() {

                }
            }));
    }
}

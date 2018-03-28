package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.response.MyOrderListResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.presentation.model.MyOrdersVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyOrdersPresenter extends RxPresenter<MyOrdersContract.View> implements
    MyOrdersContract.Presenter {

    private AccountRepository accountRepository;

    public MyOrdersPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void myOrdersRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.myOrdersRequest(params).subscribeWith(
            new DisposableObserver<MyOrderListResponse>() {
                @Override
                public void onNext(MyOrderListResponse myOrderListResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showMyOrdersResult(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));

    }

    //todo this is mock data
    private List<MyOrdersVM> getMockDatas() {
        List<MyOrdersVM> myOrdersVMS = new ArrayList<>();
        List<MyOrdersProductVM> myOrdersProductVMS = new ArrayList<>();
        List<String> attrs = new ArrayList<>();
        attrs.add("Blue");
        attrs.add("L");
        MyOrdersProductVM productVM = new MyOrdersProductVM("#123019223", "Shipped", "",
            R.drawable.ic_bought, "Manjung Korean Crispy Seaweed (Sea Salt)", attrs, "269", "119",
            "3", "30% OFF");
        MyOrdersProductVM productVM2 = new MyOrdersProductVM("#123019223", "Processing", "",
            R.drawable.ic_bought, "Manjung Korean Crispy Seaweed (Sea Salt)", attrs, "269", "119",
            "3", "30% OFF");
        myOrdersProductVMS.add(productVM);
        myOrdersProductVMS.add(productVM2);
        MyOrdersVM myOrdersVM = new MyOrdersVM("123019223", "Shipped", myOrdersProductVMS, "112");
        myOrdersVMS.add(myOrdersVM);
        myOrdersVMS.add(myOrdersVM);
        return myOrdersVMS;
    }
}

package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.OrderDetailResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.MyOrdersProductVM;
import com.goshop.app.presentation.model.OrderDetailVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class OrderDetailPresenter extends RxPresenter<OrderDetailContract.View> implements
    OrderDetailContract.Presenter {

    private AccountRepository accountRepository;

    public OrderDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void orderDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.orderDetailRequest(params).subscribeWith(
            new DisposableObserver<OrderDetailResponse>() {
                @Override
                public void onNext(OrderDetailResponse orderDetailResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showOrderDetailResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private OrderDetailVM getMockData() {
        return new OrderDetailVM("123019223", "Shipped", "12:00 PM, 12 July 2018", "Test Name",
            "Test Address", "city, 1000", "China", "T:+123456789", "Method 1", getMockDatas());
    }

    //todo this is mock data
    private List<MyOrdersProductVM> getMockDatas() {
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

        MyOrdersProductVM productVM3 = new MyOrdersProductVM("#123019223", "Delivered", "",
            R.drawable.ic_bought, "Manjung Korean Crispy Seaweed (Sea Salt)", attrs, "269", "119",
            "3", "30% OFF");
        myOrdersProductVMS.add(productVM);
        myOrdersProductVMS.add(productVM2);
        myOrdersProductVMS.add(productVM3);
        return myOrdersProductVMS;
    }
}

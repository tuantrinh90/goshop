package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.TVShowVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class TVShowPagePresenter extends RxPresenter<TVShowPageContract.View> implements
    TVShowPageContract.Presenter {

    private AccountRepository accountRepository;

    public TVShowPagePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void tvShowRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.tvShowRequest(params).subscribeWith(
            new DisposableObserver<TVShowResponse>() {
                @Override
                public void onNext(TVShowResponse tvShowResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showTvShowResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo wait for api
    private List<TVShowVM> getMockData() {
        List<TVShowVM> tvShowVMS = new ArrayList<>();
        TVShowVM tvShowVM = new TVShowVM("3", "12", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM1 = new TVShowVM("3", "12", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_product_one);
        TVShowVM tvShowVM2 = new TVShowVM("3", "13", "TUE",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_product_two);
        TVShowVM tvShowVM3 = new TVShowVM("3", "13", "TUS",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM4 = new TVShowVM("3", "14", "WED",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM5 = new TVShowVM("3", "14", "WED",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_left_demo);
        TVShowVM tvShowVM6 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM7 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_product_one);
        TVShowVM tvShowVM8 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM9 = new TVShowVM("3", "16", "FRI",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_left_demo);
        TVShowVM tvShowVM10 = new TVShowVM("3", "17", "SAT",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM11 = new TVShowVM("3", "18", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_coffee);
        TVShowVM tvShowVM12 = new TVShowVM("3", "19", "TUE",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00", "",
            R.drawable.ic_right_video_demo);


        tvShowVMS.add(tvShowVM);
        tvShowVMS.add(tvShowVM1);
        tvShowVMS.add(tvShowVM2);
        tvShowVMS.add(tvShowVM3);
        tvShowVMS.add(tvShowVM4);
        tvShowVMS.add(tvShowVM5);
        tvShowVMS.add(tvShowVM6);
        tvShowVMS.add(tvShowVM7);
        tvShowVMS.add(tvShowVM8);
        tvShowVMS.add(tvShowVM9);
        tvShowVMS.add(tvShowVM10);
        tvShowVMS.add(tvShowVM11);
        tvShowVMS.add(tvShowVM12);

        return tvShowVMS;
    }

}

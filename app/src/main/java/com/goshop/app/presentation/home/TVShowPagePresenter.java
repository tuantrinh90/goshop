package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.TVVideoLeftVM;
import com.goshop.app.presentation.model.TVVideoRightVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class TVShowPagePresenter extends RxPresenter<TVShowPageContract.View> implements
    TVShowPageContract.Presenter {

    AccountRepository accountRepository;

    public TVShowPagePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void rightVideoRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.rightVideoRequest(params).subscribeWith(
            new DisposableObserver<TVShowResponse>() {
                @Override
                public void onNext(TVShowResponse tvShowResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showRightVideoResult(getRightVideos());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void leftVideoRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.leftVideoRequest(params).subscribeWith(
            new DisposableObserver<TVShowResponse>() {
                @Override
                public void onNext(TVShowResponse tvShowResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showLeftVideoResult(getLeftVideos());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private List<TVVideoLeftVM> getLeftVideos() {
        List<TVVideoLeftVM> leftVMS = new ArrayList<>();
        leftVMS.add(new TVVideoLeftVM("RM 119.00", "RM 239.00", "30% OFF", "10:00 - 11:00",
            "Manjung Korean Crispy Seaweed (Sea Salt)", R.drawable.ic_left_demo, ""));
        leftVMS.add(new TVVideoLeftVM("RM 119.00", "RM 239.00", "30% OFF", "10:00 - 11:00",
            "Manjung Korean Crispy Seaweed (Sea Salt)", R.drawable.ic_left_demo, ""));
        leftVMS.add(new TVVideoLeftVM("RM 119.00", "RM 239.00", "30% OFF", "10:00 - 11:00",
            "Manjung Korean Crispy Seaweed (Sea Salt)", R.drawable.ic_left_demo, ""));
        return leftVMS;
    }

    //TODO(helen) this is mock data
    private List<TVVideoRightVM> getRightVideos() {
        List<TVVideoRightVM> rightVMS = new ArrayList<>();
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_right_video_demo, true));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_bought, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_right_video_demo, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_bought, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_right_video_demo, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_bought, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_right_video_demo, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_bought, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_right_video_demo, false));
        rightVMS.add(new TVVideoRightVM("13:00", "", R.drawable.ic_bought, false));

        return rightVMS;
    }
}

package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.TVShowResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.ChannelVM;
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

    @Override
    public List<ChannelVM> getChannels() {
        //todo this is mock data
        List<ChannelVM> channelVMS = new ArrayList<>();
        channelVMS.add(new ChannelVM(true, "CH118"));
        channelVMS.add(new ChannelVM(false, "CH120"));
        channelVMS.add(new ChannelVM(false, "CH303"));
        channelVMS.add(new ChannelVM(false, "FB LIVE"));
        return channelVMS;
    }

    //todo wait for api
    private List<TVShowVM> getMockData() {
        List<TVShowVM> tvShowVMS = new ArrayList<>();
        TVShowVM tvShowVM = new TVShowVM("3", "12", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://playback01.aotg-video.astro.com.my/AOTGHLS/master_AGSS.m3u8",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM1 = new TVShowVM("3", "12", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/videolib3/1604/28/fVobI0704/SD/movie_index.m3u8",
            R.drawable.ic_product_one);
        TVShowVM tvShowVM2 = new TVShowVM("3", "13", "TUE",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/G/O/EBKQOA8GO/SD/movie_index.m3u8",
            R.drawable.ic_product_two);
        TVShowVM tvShowVM3 = new TVShowVM("3", "13", "TUS",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/M/Q/EBKQO95MQ/SD/movie_index.m3u8",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM4 = new TVShowVM("3", "14", "WED",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/N/C/EBKQMCMNC/SD/movie_index.m3u8",
            R.drawable.ic_coffee);
        TVShowVM tvShowVM5 = new TVShowVM("3", "14", "WED",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/videolib3/1604/28/Dgwkr8165/SD/movie_index.m3u8",
            R.drawable.ic_product_two);
        TVShowVM tvShowVM6 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/N/C/EBKQMCMNC/SD/movie_index.m3u8",
            R.drawable.ic_left_demo);
        TVShowVM tvShowVM7 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/U/4/EBKQN3GU4/SD/movie_index.m3u8",
            R.drawable.ic_product_one);
        TVShowVM tvShowVM8 = new TVShowVM("3", "15", "THU",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/5/G/EBKQO085G/SD/movie_index.m3u8",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM9 = new TVShowVM("3", "16", "FRI",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/I/G/EBKQO2SIG/SD/movie_index.m3u8",
            R.drawable.ic_product_one);
        TVShowVM tvShowVM10 = new TVShowVM("3", "17", "SAT",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/G/S/EBKQO7TGS/SD/movie_index.m3u8",
            R.drawable.ic_right_video_demo);
        TVShowVM tvShowVM11 = new TVShowVM("3", "18", "MON",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/M/Q/EBKQO95MQ/SD/movie_index.m3u8",
            R.drawable.ic_coffee);
        TVShowVM tvShowVM12 = new TVShowVM("3", "19", "TUE",
            "9:00", "30% OFF", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 220.00", "RM 119.00",
            "http://flv2.bn.netease.com/tvmrepo/2016/4/G/O/EBKQOA8GO/SD/movie_index.m3u8",
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

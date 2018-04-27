package com.goshop.app.presentation.home;

import com.goshop.app.base.BasePresenter;
import com.goshop.app.base.BaseView;
import com.goshop.app.presentation.model.BannerVm;
import com.goshop.app.presentation.model.TrendingNowModel;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;

import android.content.Context;

import java.util.List;
import java.util.Map;

public class TrendingNowContract {

    interface View extends BaseView {

        void onBannerRequestSuccess(List<BannerVm> transform);

        void onBannerRequestFailure(String message);

        void onAirScheduleRequestFailure(String message);

        void onAirScheduleRequestSuccess(List<TrendingNowModel> bannerVms);
    }

    public interface Presenter extends BasePresenter<View> {

        void getHomeBanner();

        void getOnAirSchedule(Context context);
    }

}

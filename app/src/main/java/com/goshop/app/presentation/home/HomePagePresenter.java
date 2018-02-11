package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.WidgetViewReponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.WidgetBannerVM;
import com.goshop.app.presentation.model.WidgetGridDetailVM;
import com.goshop.app.presentation.model.WidgetHorizontalVM;
import com.goshop.app.presentation.model.WidgetOnAirVM;
import com.goshop.app.presentation.model.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.WidgetViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/2/10.
 */

public class HomePagePresenter extends RxPresenter<HomePageContract.View> implements
    HomePageContract.Presenter {

    AccountRepository accountRepository;

    public HomePagePresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void homePageRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.homePageRequest(params).subscribeWith(
            new DisposableObserver<WidgetViewReponse>() {
                @Override
                public void onNext(WidgetViewReponse widgetViewReponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //TODO(helen) wait for api
                    mView.homePageResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen) this is mock data
    private List<WidgetViewModel> getMockData() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.addAll(getWidgetBannerVMS());
        widgetViewModels.addAll(getWidgetOnAirVMS());
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.addAll(getWidgetHorizontalVMs("Trending Now"));
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.addAll(getWidgetHorizontalVMs("Best Seller"));
        widgetViewModels.addAll(getSinglePicture());
        widgetViewModels.addAll(getWidgetHorizontalVMs("TV Special"));
        return widgetViewModels;
    }

    //TODO(helen) this is mock data
    private List<WidgetBannerVM> getWidgetBannerVMS() {
        List<WidgetBannerVM> widgetBannerVMS = new ArrayList<>();
        List<String> images = new ArrayList<>();
        images.add(
            "http://a.hiphotos.baidu" +
                ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        images.add(
            "http://g.hiphotos.baidu" +
                ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        images.add("http://img843.ph.126.net/HQO2EzKsZ30Kvp03799Gyg==/883831426873459781.jpg");
        images.add(
            "http://g.hiphotos.baidu" +
                ".com/image/pic/item/9a504fc2d56285356bd508329aef76c6a7ef63e8.jpg");
        images.add(
            "http://a.hiphotos.baidu" +
                ".com/image/pic/item/503d269759ee3d6d453aab8b48166d224e4adef5.jpg");
        widgetBannerVMS.add(new WidgetBannerVM(images));
        return widgetBannerVMS;
    }

    //TODO(helen) this is mock data
    private List<WidgetOnAirVM> getWidgetOnAirVMS() {
        List<WidgetOnAirVM> widgetOnAirVMS = new ArrayList<>();
        widgetOnAirVMS.add(
            new WidgetOnAirVM("", "", "Manjung Korean Crispy Seaweed (Sea Salt)", "RM 239.00",
                "RM 119.00", "30% OFF"));
        return widgetOnAirVMS;
    }

    //TODO(helen) this is mock data
    private List<WidgetSinglePictureVM> getSinglePicture() {
        List<WidgetSinglePictureVM> singlePictureVMS = new ArrayList<>();
        singlePictureVMS.add(new WidgetSinglePictureVM("", R.mipmap.detail_top_demo));
        return singlePictureVMS;
    }

    //TODO(helen) this is mock data
    private List<WidgetHorizontalVM> getWidgetHorizontalVMs(String title) {
        List<WidgetHorizontalVM> widgetHorizontalVMS = new ArrayList<>();
        List<WidgetGridDetailVM> detailVMS = new ArrayList<>();
        WidgetGridDetailVM detailVM = new WidgetGridDetailVM("", R.mipmap.bought, "30% OFF",
            "Bloom By Naelofar Hijab (3pcs set)", "RM 269.00", "RM 119.00");
        detailVMS.add(detailVM);
        detailVMS.add(detailVM);
        detailVMS.add(detailVM);
        detailVMS.add(detailVM);
        widgetHorizontalVMS.add(new WidgetHorizontalVM(title, detailVMS));
        return widgetHorizontalVMS;
    }
}

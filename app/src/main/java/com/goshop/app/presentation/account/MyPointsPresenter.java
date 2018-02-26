package com.goshop.app.presentation.account;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.MyPointsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.PointsDetailVM;
import com.goshop.app.presentation.model.PointsModel;
import com.goshop.app.presentation.model.PointsTotalVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class MyPointsPresenter extends RxPresenter<MyPointsContract.View> implements
    MyPointsContract.Presenter {

    AccountRepository accountRepository;

    public MyPointsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void myPointsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.myPointsRequest(params).subscribeWith(
            new DisposableObserver<MyPointsResponse>() {
                @Override
                public void onNext(MyPointsResponse myPointsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    mView.showMyPointsResult(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo  this is mock data
    private List<PointsModel> getMockData() {
        List<PointsModel> pointsModels = new ArrayList<>();
        pointsModels.add(new PointsTotalVM("1000"));
        pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_TITLE));
        pointsModels.add(new PointsDetailVM("1000", "17/03/2018", "Comment description",
            "Order No. 12334455666", "16/01/2018, 06:52 am", true));
        pointsModels.add(new PointsDetailVM("1000", "17/03/2018", "Comment description",
            "Order No. 12334455666", "16/01/2018, 06:52 am", true));
        pointsModels.add(new PointsDetailVM("100", "17/03/2018", "Comment description",
            "Order No. 12334455666", "16/01/2018, 06:52 am", false));
        return pointsModels;
    }

    //todo this is nodata data
    private List<PointsModel> showNoData() {
        List<PointsModel> pointsModels = new ArrayList<>();
        pointsModels.add(new PointsTotalVM("1000"));
        pointsModels.add(new PointsModel(PointsModel.VIEW_TYPE_TRANSACTIONS_NODATA));
        return pointsModels;
    }
}

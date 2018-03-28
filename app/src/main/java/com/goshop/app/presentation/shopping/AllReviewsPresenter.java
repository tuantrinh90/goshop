package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.AllReviewsResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.AllReviewsVM;
import com.goshop.app.presentation.model.widget.ReviewsVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

public class AllReviewsPresenter extends RxPresenter<AllReviewsContract.View> implements
    AllReviewsContract.Presenter {

    private AccountRepository accountRepository;

    public AllReviewsPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void allReviewsRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.allReviewsRequest(params).subscribeWith(
            new DisposableObserver<AllReviewsResponse>() {
                @Override
                public void onNext(AllReviewsResponse allReviewsResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.showAllReviewsResult(getMockDatas());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //todo this is mock data
    private AllReviewsVM getMockDatas() {
        List<ReviewsVM> reviewsVMS = new ArrayList<>();
        ReviewsVM reviewsVM = new ReviewsVM(4, "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "User Name", "1/2/18");
        reviewsVMS.add(reviewsVM);
        reviewsVMS.add(reviewsVM);
        reviewsVMS.add(reviewsVM);
        reviewsVMS.add(reviewsVM);
        return new AllReviewsVM("", R.drawable.ic_bought, 5, "100 Reviews", reviewsVMS);
    }
}

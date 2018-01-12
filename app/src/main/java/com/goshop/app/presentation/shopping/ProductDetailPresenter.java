package com.goshop.app.presentation.shopping;

import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpBannerVM;
import com.goshop.app.presentation.model.PdpDeliveryInfoVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpProductSummaryVM;
import com.goshop.app.presentation.model.PdpQAContentTopVM;
import com.goshop.app.presentation.model.PdpQAContentVM;
import com.goshop.app.presentation.model.PdpReviewsContentVM;
import com.goshop.app.presentation.model.PdpReviewsTopVM;
import com.goshop.app.presentation.model.PdpTopContentVM;
import com.goshop.app.presentation.model.ProductDetailModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/1/11.
 */

public class ProductDetailPresenter extends RxPresenter<ProductDetailContract.View> implements
    ProductDetailContract.Presenter {

    AccountRepository accountRepository;

    public ProductDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void productDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.productDetailRequest(params).subscribeWith(
            new DisposableObserver<ProductDetailResponse>() {
                @Override
                public void onNext(ProductDetailResponse productDetailResponse) {
                    mView.hideLoadingBar();
                    //todo(helen)wait for api
                    mView.productDetailRequestSuccess(null);
                }

                @Override
                public void onError(Throwable throwable) {
                    mView.hideLoadingBar();
                    //todo(helen)wait for api
                    mView.productDetailRequestSuccess(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    private List<ProductDetailModel> getMockData() {
        //todo(helen)wait for complete
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpBannerVM());
        detailModels.addAll(getTopDatas());
        detailModels.addAll(getSummaryDatas());
        detailModels.addAll(getDeliveryDatas());
        detailModels.addAll(getDetailsDatas());
        detailModels.addAll(getQADatas());
        detailModels.addAll(getReviewsDatas());
        detailModels.addAll(getAdditionalInfoDatas());
        detailModels.addAll(getFrequentlyBoughtDatas());
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getTopDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels
            .add(new PdpTopContentVM("Kloken Living Box Value Set Kloken Living Box Value Set",
                "RM 199.00", "RM 268.00", "-30%", 4, "(24)", "10"));
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getSummaryDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.NO_ICON, "PRODUCT SUMMARY"));
        detailModels.add(new PdpProductSummaryVM());
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getDeliveryDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.NO_ICON, "DELIVERY INFO"));
        detailModels.add(new PdpDeliveryInfoVM());
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getDetailsDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.HAS_ICON, "DETAILS", false));
        detailModels.add(new PdpProductSummaryVM());
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getQADatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.HAS_ICON, "Q&A", true));
        detailModels.add(new PdpQAContentTopVM("10", "10"));
        detailModels.add(new PdpQAContentVM(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "By User Name on 1/2/18",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "By User Name on 1/2/18"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_VIEW_MORE));
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getReviewsDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.HAS_ICON, "REVIEWS", true));
        detailModels.add(new PdpReviewsTopVM("100", 5));
        detailModels.add(new PdpReviewsContentVM(4, "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "By User Name on 1/2/18"));
        detailModels.add(new PdpReviewsContentVM(3, "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "By User Name on 1/2/18"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_VIEW_MORE));
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getAdditionalInfoDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(PdpExpandTitleVM.NO_ICON, "ADDITIONAL INFORMATION"));
        detailModels.add(new PdpAdditionalInformationVM("A/S Processing Standard"));
        detailModels.add(new PdpAdditionalInformationVM("Quality Guarantee Period"));
        detailModels.add(new PdpAdditionalInformationVM("Basic Constitution"));
        detailModels.add(new PdpAdditionalInformationVM("Precaution"));
        detailModels.add(new PdpAdditionalInformationVM("Return/Cancel Processing Standard"));
        detailModels.add(new PdpAdditionalInformationVM("Model Name"));
        detailModels.add(new PdpAdditionalInformationVM("Material"));
        detailModels.add(new PdpAdditionalInformationVM("Product Features"));
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getFrequentlyBoughtDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels
            .add(new PdpExpandTitleVM(PdpExpandTitleVM.NO_ICON, "FREQUENTLY BOUGHT TOGETHER"));
        detailModels.add(new PdpFrequentlyBoughtTogetherVM());
        return detailModels;
    }


}

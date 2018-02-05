package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpBannerVM;
import com.goshop.app.presentation.model.PdpDeliveryInfoVM;
import com.goshop.app.presentation.model.PdpDetailsContentVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpFrequentlyDataVM;
import com.goshop.app.presentation.model.PdpProductSummaryVM;
import com.goshop.app.presentation.model.PdpQAContentTopVM;
import com.goshop.app.presentation.model.PdpQAContentVM;
import com.goshop.app.presentation.model.PdpReviewsContentVM;
import com.goshop.app.presentation.model.PdpReviewsTopVM;
import com.goshop.app.presentation.model.PdpTipVM;
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
        detailModels.addAll(getBannerDatas());
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
    private List<ProductDetailModel> getBannerDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
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
        detailModels.add(new PdpBannerVM(images));
        return detailModels;
    }

    //todo(helen)this is mock data will delete when get api
    private List<ProductDetailModel> getTopDatas() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        List<PdpTipVM> tips = new ArrayList<>();

        tips.add(new PdpTipVM("In Stock", R.color.color_text_black, R.color.color_divider_grey));
        tips.add(new PdpTipVM("With free gift", R.color.color_main_pink, R.color.color_litte_pink));
        List<Integer> colors = new ArrayList<>();
        colors.add(0xff23f22d);
        colors.add(0xff23faad);
        colors.add(0xfa23faaa);
        detailModels
            .add(new PdpTopContentVM("Kloken Living Box Value Set Kloken Living Box Value Set",
                "RM 199.00", "RM 268.00", "-30%", 4, "(24)", "10", colors, tips));
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
        detailModels.add(new PdpDetailsContentVM());
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
        List<PdpFrequentlyDataVM> frequentlyDataVMS = new ArrayList<>();
        PdpFrequentlyDataVM frequentlyDataVM = new PdpFrequentlyDataVM(
            "Bloom By Naelofar Hijab (3pcs set)", "", "RM 119.00", "",
            R.mipmap.bought);
        PdpFrequentlyDataVM frequentlyDataVM2 = new PdpFrequentlyDataVM(
            "Bloom By Naelofar Hijab (3pcs set)", "RM 269.00", "RM 119.00", "30% OFF",
            R.mipmap.bought);
        frequentlyDataVMS.add(frequentlyDataVM);
        frequentlyDataVMS.add(frequentlyDataVM2);
        frequentlyDataVMS.add(frequentlyDataVM);
        frequentlyDataVMS.add(frequentlyDataVM2);
        detailModels
            .add(new PdpExpandTitleVM(PdpExpandTitleVM.NO_ICON, "FREQUENTLY BOUGHT TOGETHER"));
        detailModels.add(new PdpFrequentlyBoughtTogetherVM(frequentlyDataVMS));
        return detailModels;
    }


}

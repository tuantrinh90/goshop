package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.base.RxPresenter;
import com.goshop.app.data.model.ProductDetailResponse;
import com.goshop.app.domian.AccountRepository;
import com.goshop.app.presentation.model.widget.AdditionalInformationVM;
import com.goshop.app.presentation.model.widget.CarouselAutoPlayVM;
import com.goshop.app.presentation.model.widget.CarouselDataVM;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.ColorVM;
import com.goshop.app.presentation.model.widget.ProductDataVM;
import com.goshop.app.presentation.model.widget.ProductItemVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetPDPTopDetailsVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetTitleExpandVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by helen on 2018/2/22.
 */

public class PDPDetailPresenter extends RxPresenter<PDPDetailContract.View> implements
    PDPDetailContract.Presenter {

    private AccountRepository accountRepository;

    public PDPDetailPresenter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void pdpDetailRequest(Map<String, Object> params) {
        mView.showLoadingBar();
        addSubscrebe(accountRepository.pdpDetailRequest(params).subscribeWith(
            new DisposableObserver<ProductDetailResponse>() {
                @Override
                public void onNext(ProductDetailResponse productDetailResponse) {
                    mView.hideLoadingBar();
                }

                @Override
                public void onError(Throwable e) {
                    mView.hideLoadingBar();
                    mView.pdpDetailRequestSuccess(getMockData());
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    //TODO(helen) this is mock data
    private List<WidgetViewModel> getMockData() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(getWidgetBanners());
        widgetViewModels.add(getPDPTopDetails());
        widgetViewModels.addAll(getProductSummary());
        widgetViewModels.addAll(getDeliveryInfo());
        widgetViewModels.addAll(getDetails());
        widgetViewModels.addAll(getQA());
        widgetViewModels.addAll(getReviews());
        widgetViewModels.addAll(getAdditionalInformation());
        widgetViewModels.addAll(getFrequentlyBoughtTogether());
        return widgetViewModels;
    }

    //TODO(helen) this is mock data
    private WidgetCarouselVM getWidgetBanners() {
        CarouselAutoPlayVM autoPlayVM = new CarouselAutoPlayVM(1000, true);
        List<CarouselItemsVM> itemsVMS = new ArrayList<>();
        CarouselItemsVM itemsVM = new CarouselItemsVM("http://a.hiphotos.baidu" +
            ".com/image/pic/item/4e4a20a4462309f788a28152790e0cf3d6cad6a4.jpg");
        CarouselItemsVM itemsVM1 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/7aec54e736d12f2ee7ed822044c2d56284356881.jpg");
        CarouselItemsVM itemsVM2 = new CarouselItemsVM(
            "http://img843.ph.126.net/HQO2EzKsZ30Kvp03799Gyg==/883831426873459781.jpg");
        CarouselItemsVM itemsVM3 = new CarouselItemsVM("http://g.hiphotos.baidu" +
            ".com/image/pic/item/9a504fc2d56285356bd508329aef76c6a7ef63e8.jpg");
        itemsVMS.add(itemsVM);
        itemsVMS.add(itemsVM1);
        itemsVMS.add(itemsVM2);
        itemsVMS.add(itemsVM3);
        CarouselDataVM carouselDataVM = new CarouselDataVM(itemsVMS);
        return new WidgetCarouselVM(autoPlayVM, carouselDataVM);
    }

    //TODO(helen) this is mock data
    private WidgetPDPTopDetailsVM getPDPTopDetails() {
        List<String> tips = new ArrayList<>();
        tips.add("3M Installment");
        tips.add("with free gift");
        tips.add("Best Seller");
        List<ColorVM> colorVMS = new ArrayList<>();
        colorVMS.add(new ColorVM("Yellow", "#fbaf3f"));
        List<String> sizes = new ArrayList<>();
        sizes.add("XL");
        return new WidgetPDPTopDetailsVM("Kloken Living Box Value Set Kloken Living Box Value Set",
            "RM 269.00", "RM 199.00", "(-30%)", 5, "(24)",
            tips, colorVMS, sizes, "2");
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getProductSummary() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Product Summary", true, true));
        widgetViewModels.add(new WidgetViewModel(WidgetViewModel.VIEW_TYPE_SINGLE_TEXT));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getDeliveryInfo() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Delivery Info", false, true));
        widgetViewModels.add(new WidgetViewModel(WidgetViewModel.VIEW_TYPE_DELIVERY_INFO));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getDetails() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Details", true, true));
        widgetViewModels.add(new WidgetViewModel(WidgetViewModel.VIEW_TYPE_SINGLE_TEXT));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getQA() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Q&A", false, true));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getReviews() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Reviews", false, true));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getAdditionalInformation() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Additional Information", false, true));
        widgetViewModels.add(new AdditionalInformationVM("A/S Processing Standard","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Quality Guarantee Period","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Basic Constitution","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Precaution","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Return/Cancel Processing Standard","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Model Name","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Material","N/A"));
        widgetViewModels.add(new AdditionalInformationVM("Product Features","N/A"));
        return widgetViewModels;
    }
    //TODO(helen) this is mock data
    private List<WidgetViewModel> getFrequentlyBoughtTogether() {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM("Frequently Bought Together"));
        ProductPriceRMVM productPriceRMVM = new ProductPriceRMVM("25% OFF", "149", "200");
        ProductPriceVM productPriceVM = new ProductPriceVM(productPriceRMVM);
        List<String> attributes = new ArrayList<>();
        attributes.add("New");
        ProductItemVM productItemVM = new ProductItemVM(R.mipmap.bought, "",
            "Bloom By Naelofar Hijab (3pcs set)", attributes, productPriceVM);
        List<ProductItemVM> productItemVMS = new ArrayList<>();
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        productItemVMS.add(productItemVM);
        ProductDataVM productDataVM = new ProductDataVM(productItemVMS);
        widgetViewModels.add(new WidgetProductScrollerVM(productDataVM));
        return widgetViewModels;
    }
}

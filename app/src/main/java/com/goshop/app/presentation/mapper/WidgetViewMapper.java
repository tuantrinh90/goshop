package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.BaseWidgetReponse;
import com.goshop.app.data.model.response.CarouselItemsReponse;
import com.goshop.app.data.model.response.CarouselReponse;
import com.goshop.app.data.model.response.OfferListItemsReponse;
import com.goshop.app.data.model.response.OfferListReponse;
import com.goshop.app.data.model.response.ProductScrollerItemsReponse;
import com.goshop.app.data.model.response.ProductScrollerPriceReponse;
import com.goshop.app.data.model.response.ProductScrollerReponse;
import com.goshop.app.data.model.response.VideoItemsReponse;
import com.goshop.app.data.model.response.VideoPlayerReponse;
import com.goshop.app.data.model.response.VideoProductsReponse;
import com.goshop.app.data.model.response.VideoRMReponse;
import com.goshop.app.data.model.response.WidgetListReponse;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.presentation.model.widget.OfferListItemsVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.VideoPlayerItemsVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetTitleExpandVM;
import com.goshop.app.presentation.model.widget.WidgetVideoPlayerVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class WidgetViewMapper {

    public static List<WidgetViewModel> transform(WidgetListReponse widgetListReponse) {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        List<BaseWidgetReponse> baseWidgetReponses = widgetListReponse.getWidgetlist();
        for (BaseWidgetReponse baseWidgetReponse : baseWidgetReponses) {
            switch (baseWidgetReponse.getName()) {
                case BaseWidgetReponse.NAME_CAROUSEL:
                    widgetViewModels.add(getWidgetCarouselVM((CarouselReponse) baseWidgetReponse));
                    break;
                case BaseWidgetReponse.NAME_VIDEOPLAYER:
                    widgetViewModels
                        .add(getWidgetVideoPlayerVM((VideoPlayerReponse) baseWidgetReponse));
                    break;
                case BaseWidgetReponse.NAME_OFFERLIST:
                    widgetViewModels
                        .add(getWidgetSinglePictureVM((OfferListReponse) baseWidgetReponse));
                    break;
                case BaseWidgetReponse.NAME_PRODUCTSCROLLER:
                    widgetViewModels.addAll(
                        getWidgetProductScrollerVM((ProductScrollerReponse) baseWidgetReponse));
                    break;
            }
        }
        return widgetViewModels;
    }

    private static WidgetCarouselVM getWidgetCarouselVM(CarouselReponse carouselReponse) {
        boolean autoEnabled = Boolean.parseBoolean(carouselReponse.getAutoPlay().getEnabled());
        long autoDuration = Integer.parseInt(carouselReponse.getAutoPlay().getDuration());
        List<CarouselItemsVM> carouselItemsVMS = new ArrayList<>();
        List<CarouselItemsReponse> items = carouselReponse.getData().getItems();
        for (CarouselItemsReponse reponse : items) {
            CarouselItemsVM itemsVM = new CarouselItemsVM();
            itemsVM.setImage(reponse.getImage());
            itemsVM.setLink(reponse.getLink());
            carouselItemsVMS.add(itemsVM);
        }
        return new WidgetCarouselVM(autoEnabled, autoDuration, carouselItemsVMS);
    }

    private static WidgetVideoPlayerVM getWidgetVideoPlayerVM(
        VideoPlayerReponse videoPlayerReponse) {
        String title = videoPlayerReponse.getTitle();
        String detailTitle = videoPlayerReponse.getData().getDetail().getTitle();
        List<VideoPlayerItemsVM> videoPlayerItemsVMS = new ArrayList<>();
        List<VideoItemsReponse> itemsReponses = videoPlayerReponse.getData().getItems();
        for (VideoItemsReponse itemsReponse : itemsReponses) {
            VideoPlayerItemsVM videoPlayerItemsVM = new VideoPlayerItemsVM();
            List<VideoProductsReponse> productsReponses = itemsReponse.getProducts();
            List<ProductsVM> productsVMS = new ArrayList<>();
            for (VideoProductsReponse productsReponse : productsReponses) {
                ProductsVM productsVM = new ProductsVM();
                productsVM.setTitle(productsReponse.getTitle());
                productsVM.setImage(productsReponse.getImage());
                productsVM.setLink(productsReponse.getLink());
                VideoRMReponse rmReponse = productsReponse.getPrice().getRM();
                //todo this will deal when api ready
                ProductPriceRMVM rmvm = new ProductPriceRMVM(rmReponse.getDiscountTitle(),
                    NumberFormater.formaterMoney(rmReponse.getDiscounted()),
                    NumberFormater.formaterMoney(rmReponse.getOriginal()));
                ProductPriceVM priceVM = new ProductPriceVM(rmvm);
                productsVM.setPriceVM(priceVM);
                productsVM.setId(productsReponse.getIdX());
                productsVM.setAttributes(productsReponse.getAttributes());
                productsVMS.add(productsVM);
            }
            videoPlayerItemsVM.setProductsVMS(productsVMS);
            videoPlayerItemsVM.setName(itemsReponse.getNameX());
            videoPlayerItemsVMS.add(videoPlayerItemsVM);
        }
        return new WidgetVideoPlayerVM(title, detailTitle, videoPlayerItemsVMS);
    }

    private static WidgetSinglePictureVM getWidgetSinglePictureVM(
        OfferListReponse offerListReponse) {
        List<OfferListItemsVM> offerListItemsVMS = new ArrayList<>();
        List<OfferListItemsReponse> listItemsReponses = offerListReponse.getData().getItems();
        for (OfferListItemsReponse itemsReponse : listItemsReponses) {
            OfferListItemsVM itemsVM = new OfferListItemsVM(R.drawable.ic_detail_top_demo,
                itemsReponse.getImage(), itemsReponse.getLink());
            offerListItemsVMS.add(itemsVM);
        }
        return new WidgetSinglePictureVM(offerListItemsVMS);
    }

    private static List<WidgetViewModel> getWidgetProductScrollerVM(
        ProductScrollerReponse productScrollerReponse) {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM(productScrollerReponse.getTitle()));

        List<ProductScrollerItemsReponse> itemsReponses = productScrollerReponse.getData()
            .getItems();
        List<ProductsVM> productsVMS = new ArrayList<>();
        for (ProductScrollerItemsReponse itemsReponse : itemsReponses) {
            ProductsVM productsVM = new ProductsVM();
            ProductScrollerPriceReponse priceReponse = itemsReponse.getPrice();
            ProductPriceRMVM priceRMVM = new ProductPriceRMVM(
                priceReponse.getRM().getDiscountTitle(),
                NumberFormater.formaterMoney(priceReponse.getRM().getDiscounted()),
                NumberFormater.formaterMoney(priceReponse.getRM().getOriginal()));
            productsVM.setPriceVM(new ProductPriceVM(priceRMVM));
            productsVM.setImage(itemsReponse.getImage());
            productsVM.setTitle(itemsReponse.getTitle());
            productsVM.setAttributes(itemsReponse.getAttributes());
            productsVMS.add(productsVM);
        }
        widgetViewModels.add(new WidgetProductScrollerVM(productsVMS));
        return widgetViewModels;
    }

}

package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.BaseWidgetResponse;
import com.goshop.app.data.model.response.CarouselItemsResponse;
import com.goshop.app.data.model.response.CarouselResponse;
import com.goshop.app.data.model.response.OfferListItemsResponse;
import com.goshop.app.data.model.response.OfferListResponse;
import com.goshop.app.data.model.response.ProductScrollerItemsResponse;
import com.goshop.app.data.model.response.ProductScrollerPriceResponse;
import com.goshop.app.data.model.response.ProductScrollerResponse;
import com.goshop.app.data.model.response.VideoItemsResponse;
import com.goshop.app.data.model.response.VideoPlayerResponse;
import com.goshop.app.data.model.response.VideoProductsResponse;
import com.goshop.app.data.model.response.VideoRMResponse;
import com.goshop.app.data.model.response.WidgetListResponse;
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

    public static List<WidgetViewModel> transform(WidgetListResponse widgetListResponse) {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        List<BaseWidgetResponse> baseWidgetRepons = widgetListResponse.getWidgetlist();
        for (BaseWidgetResponse baseWidgetResponse : baseWidgetRepons) {
            switch (baseWidgetResponse.getName()) {
                case BaseWidgetResponse.NAME_CAROUSEL:
                    widgetViewModels.add(getWidgetCarouselVM((CarouselResponse) baseWidgetResponse));
                    break;
                case BaseWidgetResponse.NAME_VIDEOPLAYER:
                    widgetViewModels
                        .add(getWidgetVideoPlayerVM((VideoPlayerResponse) baseWidgetResponse));
                    break;
                case BaseWidgetResponse.NAME_OFFERLIST:
                    widgetViewModels
                        .add(getWidgetSinglePictureVM((OfferListResponse) baseWidgetResponse));
                    break;
                case BaseWidgetResponse.NAME_PRODUCTSCROLLER:
                    widgetViewModels.addAll(
                        getWidgetProductScrollerVM((ProductScrollerResponse) baseWidgetResponse));
                    break;
            }
        }
        return widgetViewModels;
    }

    private static WidgetCarouselVM getWidgetCarouselVM(CarouselResponse carouselReponse) {
        boolean autoEnabled = Boolean.parseBoolean(carouselReponse.getAutoPlay().getEnabled());
        long autoDuration = Integer.parseInt(carouselReponse.getAutoPlay().getDuration());
        List<CarouselItemsVM> carouselItemsVMS = new ArrayList<>();
        List<CarouselItemsResponse> items = carouselReponse.getData().getItems();
        for (CarouselItemsResponse reponse : items) {
            CarouselItemsVM itemsVM = new CarouselItemsVM();
            itemsVM.setImage(reponse.getImage());
            itemsVM.setLink(reponse.getLink());
            carouselItemsVMS.add(itemsVM);
        }
        return new WidgetCarouselVM(autoEnabled, autoDuration, carouselItemsVMS);
    }

    private static WidgetVideoPlayerVM getWidgetVideoPlayerVM(
        VideoPlayerResponse videoPlayerReponse) {
        String title = videoPlayerReponse.getTitle();
        String detailTitle = videoPlayerReponse.getData().getDetail().getTitle();
        List<VideoPlayerItemsVM> videoPlayerItemsVMS = new ArrayList<>();
        List<VideoItemsResponse> itemsReponses = videoPlayerReponse.getData().getItems();
        for (VideoItemsResponse itemsReponse : itemsReponses) {
            VideoPlayerItemsVM videoPlayerItemsVM = new VideoPlayerItemsVM();
            List<VideoProductsResponse> productsReponses = itemsReponse.getProducts();
            List<ProductsVM> productsVMS = new ArrayList<>();
            for (VideoProductsResponse productsReponse : productsReponses) {
                ProductsVM productsVM = new ProductsVM();
                productsVM.setTitle(productsReponse.getTitle());
                productsVM.setImage(productsReponse.getImage());
                productsVM.setLink(productsReponse.getLink());
                VideoRMResponse rmReponse = productsReponse.getPrice().getRM();
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
        OfferListResponse offerListReponse) {
        List<OfferListItemsVM> offerListItemsVMS = new ArrayList<>();
        List<OfferListItemsResponse> listItemsReponses = offerListReponse.getData().getItems();
        for (OfferListItemsResponse itemsReponse : listItemsReponses) {
            OfferListItemsVM itemsVM = new OfferListItemsVM(R.drawable.ic_detail_top_demo,
                itemsReponse.getImage(), itemsReponse.getLink());
            offerListItemsVMS.add(itemsVM);
        }
        return new WidgetSinglePictureVM(offerListItemsVMS);
    }

    private static List<WidgetViewModel> getWidgetProductScrollerVM(
        ProductScrollerResponse productScrollerReponse) {
        List<WidgetViewModel> widgetViewModels = new ArrayList<>();
        widgetViewModels.add(new WidgetTitleExpandVM(productScrollerReponse.getTitle()));

        List<ProductScrollerItemsResponse> itemsReponses = productScrollerReponse.getData()
            .getItems();
        List<ProductsVM> productsVMS = new ArrayList<>();
        for (ProductScrollerItemsResponse itemsReponse : itemsReponses) {
            ProductsVM productsVM = new ProductsVM();
            ProductScrollerPriceResponse priceReponse = itemsReponse.getPrice();
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

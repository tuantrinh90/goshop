package com.goshop.app.presentation.mapper;

import com.goshop.app.Const;
import com.goshop.app.data.model.response.ProductDetailResponse;
import com.goshop.app.data.model.response.common.PDPProductData;
import com.goshop.app.data.model.response.common.PriceData;
import com.goshop.app.data.model.response.common.SuperAttributeData;
import com.goshop.app.data.model.response.common.VariantData;
import com.goshop.app.presentation.model.PdpAdditionalInformationVM;
import com.goshop.app.presentation.model.PdpAdditionalItemVM;
import com.goshop.app.presentation.model.PdpExpandTitleVM;
import com.goshop.app.presentation.model.PdpFrequentlyBoughtTogetherVM;
import com.goshop.app.presentation.model.PdpQAVM;
import com.goshop.app.presentation.model.PdpReviewsVM;
import com.goshop.app.presentation.model.PdpSingleTextVM;
import com.goshop.app.presentation.model.ProductDetailModel;
import com.goshop.app.presentation.model.ProductDetailTopVM;
import com.goshop.app.presentation.model.SizeVM;
import com.goshop.app.presentation.model.ColorVM;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.model.widget.QAVM;
import com.goshop.app.presentation.model.widget.ReviewsVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailMapper {

    private static final String SIZE = "Size";

    private static final String COLOR = "Color";

    public static List<ProductDetailModel> transform(ProductDetailResponse response) {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(getProductTopData(response));
        detailModels.addAll(getProductSummary(response.getProduct().getSummary()));
        detailModels.addAll(getProductsDetail(response.getProduct().getDetails()));
        detailModels.addAll(getProductsDelivery());
        detailModels.addAll(getProductReviews());
        detailModels.addAll(getProductQuestionAnswer());
        detailModels.addAll(getAdditionalInformation());
        detailModels.addAll(getFrequentlyBoughtTogether());
        return detailModels;
    }

    public static List<String> transformBanner(ProductDetailResponse response) {
        List<String> images = new ArrayList<>();
        images.addAll(response.getProduct().getVideoUrl());
        images.addAll(response.getProduct().getImages());
        return images;
    }

    private static ProductDetailTopVM getProductTopData(ProductDetailResponse response) {
        List<ColorVM> colorVMS = transformColorVMs(response);
        List<SizeVM> sizeVMS = transformSizeVMs(response);
        PDPProductData productData = response.getProduct();
        PriceData priceData = productData.getPrice();
        return new ProductDetailTopVM(
            productData.getSku(),
            productData.getName(),
            NumberFormater.formaterPrice(priceData.getRM().getOriginal()),
            NumberFormater.formaterPrice(priceData.getRM().getDiscounted()),
            NumberFormater.formaterBrackets(priceData.getRM().getDiscountTitle()),
            colorVMS, sizeVMS, "1");
    }

    public static List<ColorVM> transformColorVMs(ProductDetailResponse response) {
        List<ColorVM> colorVMS = new ArrayList<>();
        List<SuperAttributeData> superAttributeDatas = response.getProduct().getSuperAttribute();
        for (SuperAttributeData attributeData : superAttributeDatas) {
            if (attributeData.getName().equals(COLOR)) {
                List<VariantData> colorDatas = attributeData.getVariant();
                for (VariantData data : colorDatas) {
                    colorVMS.add(
                        new ColorVM(attributeData.getId(), attributeData.getName(), data.getId(),
                            data.getName()));
                }
            }
        }
        return colorVMS;
    }

    public static List<SizeVM> transformSizeVMs(ProductDetailResponse response) {
        List<SizeVM> sizeVMS = new ArrayList<>();
        List<SuperAttributeData> superAttributeDatas = response.getProduct().getSuperAttribute();
        for (SuperAttributeData attributeData : superAttributeDatas) {
            if (attributeData.getName().equals(SIZE)) {
                List<VariantData> sizeDatas = attributeData.getVariant();
                for (VariantData data : sizeDatas) {
                    sizeVMS.add(
                        new SizeVM(attributeData.getId(), attributeData.getName(), data.getId(),
                            data.getName()));
                }
            }
        }
        return sizeVMS;
    }

    private static List<ProductDetailModel> getProductSummary(String summary) {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, Const.TITLE_PRODUCT_SUMMARY));
        detailModels.add(new PdpSingleTextVM(summary));
        return detailModels;
    }

    private static List<ProductDetailModel> getProductsDetail(String detail) {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, Const.TITLE_DETAIL));
        detailModels.add(new PdpSingleTextVM(detail));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private static List<ProductDetailModel> getProductsDelivery() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(false, false, "Delivery Info"));
        detailModels.add(new ProductDetailModel(ProductDetailModel.DETAIL_DELIVERY_INFO));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private static List<ProductDetailModel> getProductReviews() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Reviews"));
        List<ReviewsVM> reviewsVMS = new ArrayList<>();
        ReviewsVM reviewsVM = new ReviewsVM(4, "Lorem ipsum dolor sit amet",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla quam velit",
            "User Name", "1/2/18");
        reviewsVMS.add(reviewsVM);
        reviewsVMS.add(reviewsVM);
        detailModels.add(new PdpReviewsVM(5, "(100)", reviewsVMS));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private static List<ProductDetailModel> getProductQuestionAnswer() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Q&A"));

        QAVM qavm = new QAVM("3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ",
            "1/2/2018");
        List<QAVM> qavms = new ArrayList<>();
        qavms.add(qavm);
        qavms.add(qavm);
        detailModels.add(new PdpQAVM("10", "10", qavms));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private static List<ProductDetailModel> getAdditionalInformation() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(true, true, "Additional Information"));

        List<PdpAdditionalItemVM> additionalItemVMS = new ArrayList<>();

        additionalItemVMS.add(new PdpAdditionalItemVM("A/S Processing Standard", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Quality Guarantee Period", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Basic Constitution", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Precaution", "N/A"));
        additionalItemVMS
            .add(new PdpAdditionalItemVM("Return/Cancel Processing Standard", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Model Name", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Material", "N/A"));
        additionalItemVMS.add(new PdpAdditionalItemVM("Product Features", "N/A"));
        detailModels.add(new PdpAdditionalInformationVM(additionalItemVMS));
        return detailModels;
    }

    //TODO(helen) this is mock data
    private static List<ProductDetailModel> getFrequentlyBoughtTogether() {
        List<ProductDetailModel> detailModels = new ArrayList<>();
        detailModels.add(new PdpExpandTitleVM(false, false, "Frequently Bought Together"));
        ProductsVM productsVM = new ProductsVM();
        ProductPriceRMVM rmvm = new ProductPriceRMVM("25% OFF", "RM 149.00", "RM 200.00");
        ProductPriceVM priceVM = new ProductPriceVM(rmvm);
        productsVM.setImage("");
        productsVM.setTitle("Manjung Korean Crispy Seaweed 2");
        productsVM.setPriceVM(priceVM);
        List<ProductsVM> productsVMS = new ArrayList<>();
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        productsVMS.add(productsVM);
        detailModels.add(new PdpFrequentlyBoughtTogetherVM(productsVMS));
        return detailModels;
    }


}

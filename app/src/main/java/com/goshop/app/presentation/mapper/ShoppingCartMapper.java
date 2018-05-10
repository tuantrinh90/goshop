package com.goshop.app.presentation.mapper;

import com.goshop.app.R;
import com.goshop.app.data.model.response.CartDataResponse;
import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.data.model.response.common.SuperAttributeData;
import com.goshop.app.presentation.model.BillingVM;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.common.ProductVM;
import com.goshop.app.utils.NumberFormater;
import com.goshop.app.utils.TextFormater;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartMapper {

    private static final String COMMA = ", ";

    private static final String END = "; ";

    public static ShoppingCartProductVM transform(CartDataResponse response) {
        List<ProductData> productDatas = response.getCart().getProducts();
        List<ProductVM> productVMS = new ArrayList<>();
        for (ProductData data : productDatas) {
            ProductVM productVM = new ProductVM();
            productVM.setTitle(data.getName());
            productVM.setId(data.getSku());
            productVM.setQuoteItemId(data.getQuoteItemId());
            productVM.setAmount(data.getQty());
            productVM.setImage(data.getImage());
            productVM.setImageDefault(R.drawable.ic_image_404_small);
            RMData rmData = data.getPrice().getRM();
            productVM.setNowPrice(NumberFormater.formaterPrice(rmData.getDiscounted()));
            productVM.setOldPrice(NumberFormater.formaterPrice(rmData.getOriginal()));
            productVM.setPercent(rmData.getDiscountTitle());
            List<SuperAttributeData> attributeDatas = data.getSuperAttributes();
            String attribute = "";
            for (SuperAttributeData attributeData : attributeDatas) {
                attribute = attribute + attributeData.getName() + COMMA + attributeData
                    .getVariantName() + END;
            }
            productVM.setAttribute(attribute);
            productVMS.add(productVM);
        }
        ShoppingCartProductVM shoppingCartProductVM = new ShoppingCartProductVM();
        shoppingCartProductVM.setId(response.getCart().getQuoteId());
        if (productVMS.size() > 0) {
            shoppingCartProductVM.setProductVMS(productVMS);
            BillingData billingData = response.getCart().getBilling();
            BillingVM billingVM = new BillingVM();
            billingVM.setBillingDiscountAmount(billingData.getRm().getDiscount().getAmount());
            billingVM.setBillingDiscountCode(
                TextFormater.formatBillingCode(billingData.getRm().getDiscount().getCode()));
            billingVM.setBillingShipping(
                NumberFormater.formaterPrice(billingData.getRm().getShipping()));
            billingVM.setBillingSubTotal(
                NumberFormater.formaterPrice(billingData.getRm().getSubTotal()));
            billingVM.setBillingTotal(NumberFormater.formaterPrice(billingData.getRm().getTotal()));
            billingVM.setBillingEGiftCode(
                TextFormater.formatBillingCode(billingData.getRm().geteGiftCard().getCode()));
            billingVM.setBillingEGiftAmount(billingData.getRm().geteGiftCard().getAmount());
            billingVM.setBillingPointsApplied(
                TextFormater.formatBillingCode(billingData.getRm().getGoshopPoints().getApplied()));
            billingVM.setBillingPointsAmount(billingData.getRm().getGoshopPoints().getAmount());
            shoppingCartProductVM.setBillingVM(billingVM);
        }
        return shoppingCartProductVM;
    }

    public static int transformCartCount(CartDataResponse response) {
        List<ProductData> productDatas = response.getCart().getProducts();
        int count = 0;
        for (ProductData data : productDatas) {
            count = count + Integer.parseInt(data.getQty());
        }
        return count;
    }

}

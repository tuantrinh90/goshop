package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ShoppingCartResponse;
import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
import com.goshop.app.presentation.model.ShoppingCartApplyVM;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.ShoppingCartProductVM;
import com.goshop.app.presentation.model.widget.ProductCartListVM;
import com.goshop.app.presentation.model.widget.ProductListModel;
import com.goshop.app.presentation.model.widget.ProductPriceRMVM;
import com.goshop.app.presentation.model.widget.ProductPriceVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartMapper {

    public static List<ShoppingCartModel> transform(ShoppingCartResponse response) {
        List<ShoppingCartModel> cartModels = new ArrayList<>();
        List<ProductData> productDatas = response.getCart().getProducts();
        List<ProductListModel> listModels = new ArrayList<>();
        for(ProductData data:productDatas) {
            ProductsVM productsVM = new ProductsVM();
            productsVM.setTitle(data.getName());
            productsVM.setId(data.getSku());
            productsVM.setAmount(data.getQty());
            productsVM.setImage(data.getImage());
            RMData rmData = data.getPrice().getRM();
            ProductPriceRMVM rmvm = new ProductPriceRMVM(rmData.getDiscountTitle(), rmData.getDiscounted(), rmData.getOriginal());
            ProductPriceVM priceVM = new ProductPriceVM(rmvm);
            productsVM.setPriceVM(priceVM);
            productsVM.setAttributes(data.getAttributes());
            listModels.add(new ProductCartListVM(productsVM));
        }

        if(listModels.size() > 0) {
            cartModels.add(new ShoppingCartProductVM(listModels));
            BillingData billingData = response.getCart().getBilling();
            ShoppingCartApplyVM cartApplyVM = new ShoppingCartApplyVM();
            cartApplyVM.setDiscount(NumberFormater.formaterDiscountPrice(billingData.getRm().getDiscount()));
            cartApplyVM.setShipping(NumberFormater.formaterPrice(billingData.getRm().getShipping()));
            cartApplyVM.setSubTotal(NumberFormater.formaterPrice(billingData.getRm().getSubTotal()));
            cartApplyVM.setTotal(NumberFormater.formaterPrice(billingData.getRm().getTotal()));
            cartModels.add(cartApplyVM);
        }
        return cartModels;
    }

}

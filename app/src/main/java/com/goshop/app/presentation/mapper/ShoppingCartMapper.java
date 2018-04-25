package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.ShoppingCartResponse;
import com.goshop.app.data.model.response.common.BillingData;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.data.model.response.common.RMData;
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

    public static ShoppingCartProductVM transform(ShoppingCartResponse response) {

        List<ProductData> productDatas = response.getCart().getProducts();
        List<ProductListModel> listModels = new ArrayList<>();
        for (ProductData data : productDatas) {
            ProductsVM productsVM = new ProductsVM();
            productsVM.setTitle(data.getName());
            productsVM.setId(data.getSku());
            productsVM.setAmount(data.getQty());
            productsVM.setImage(data.getImage());
            RMData rmData = data.getPrice().getRM();
            ProductPriceRMVM rmvm = new ProductPriceRMVM(rmData.getDiscountTitle(),
                rmData.getDiscounted(), rmData.getOriginal());
            ProductPriceVM priceVM = new ProductPriceVM(rmvm);
            productsVM.setPriceVM(priceVM);
            productsVM.setAttributes(data.getAttributes());
            listModels.add(new ProductCartListVM(productsVM));
        }
        ShoppingCartProductVM shoppingCartProductVM = new ShoppingCartProductVM();
        shoppingCartProductVM.setId(response.getCart().getQuoteId());
        if (listModels.size() > 0) {
            shoppingCartProductVM.setProductListModels(listModels);
            BillingData billingData = response.getCart().getBilling();
            shoppingCartProductVM.setDiscount(billingData.getRm().getDiscount());
            shoppingCartProductVM
                .setShipping(NumberFormater.formaterPrice(billingData.getRm().getShipping()));
            shoppingCartProductVM
                .setSubTotal(NumberFormater.formaterPrice(billingData.getRm().getSubTotal()));
            shoppingCartProductVM
                .setTotal(NumberFormater.formaterPrice(billingData.getRm().getTotal()));
        }
        return shoppingCartProductVM;
    }

}

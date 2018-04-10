package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.data.model.response.common.ProductData;
import com.goshop.app.presentation.model.WishlistVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistMapper {

    private static final String ATTR_BEST = "Best Selling";

    private static final String ATTR_NEW = "New";

    public static List<WishlistVM> transform(Response<MyWishlistResponse> response) {
        List<WishlistVM> wishlistVMS = new ArrayList<>();
        List<ProductData> productDatas = response.getData().getProduct();
        if (productDatas.size() > 0) {
            WishlistVM wishlistVM;
            for (ProductData wishlistData : productDatas) {
                wishlistVM = new WishlistVM();
                wishlistVM.setTitle(wishlistData.getName());
                wishlistVM.setAttr("");
                wishlistVM.setOldPrice(
                    NumberFormater.formaterMoney(wishlistData.getPrice().getRM().getOriginal()));
                wishlistVM
                    .setNowPrice(NumberFormater
                        .formaterMoney(wishlistData.getPrice().getRM().getDiscounted()));
                wishlistVM.setPercent(wishlistData.getPrice().getRM().getDiscountTitle());
                wishlistVM.setSku(wishlistData.getSku());
                wishlistVM.setLink(wishlistData.getLink());
                wishlistVM.setThumb(wishlistData.getImage());
                List<String> attributes = wishlistData.getAttributes();
                if (attributes.size() > 0) {
                    for (String attr : attributes) {
                        if (attr.equals(ATTR_NEW)) {
                            wishlistVM.setNew(true);
                            break;
                        }
                    }

                    for (String attr : attributes) {
                        if (attr.equals(ATTR_BEST)) {
                            wishlistVM.setBest(true);
                            break;
                        }
                    }
                }
                wishlistVMS.add(wishlistVM);
            }
        } else {
            //todo
        }
        return wishlistVMS;
    }
}

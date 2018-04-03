package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.response.MyWishlistResponse;
import com.goshop.app.presentation.model.WishlistVM;
import com.goshop.app.utils.NumberFormater;

import java.util.ArrayList;
import java.util.List;

public class MyWishlistMapper {

    public static List<WishlistVM> transform(MyWishlistResponse response) {
        List<WishlistVM> wishlistVMS = new ArrayList<>();
        List<MyWishlistResponse.Datas.WishlistData> wishlistDatas = response.getData()
            .getWishlist();
        WishlistVM wishlistVM;
        for (MyWishlistResponse.Datas.WishlistData wishlistData : wishlistDatas) {
            wishlistVM = new WishlistVM();
            wishlistVM.setTitle(wishlistData.getProduct_name());
            wishlistVM.setAttr("");
            wishlistVM.setOldPrice(NumberFormater.formaterPrice(wishlistData.getOriginal_price()));
            wishlistVM
                .setNowPrice(NumberFormater.formaterPrice(wishlistData.getDiscounted_price()));
            wishlistVM.setSku(wishlistData.getSku());
            wishlistVMS.add(wishlistVM);
        }
        return wishlistVMS;
    }
}

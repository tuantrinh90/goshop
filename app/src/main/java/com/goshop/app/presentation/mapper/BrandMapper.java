package com.goshop.app.presentation.mapper;

import com.goshop.app.data.model.BrandsResponse;
import com.goshop.app.data.model.response.BrandListData;
import com.goshop.app.data.model.response.Response;
import com.goshop.app.presentation.model.BrandsListVM;

import java.util.ArrayList;
import java.util.List;

public class BrandMapper {

    public static List<BrandsListVM> transform(Response<BrandsResponse> response, int page) {
        List<BrandsListVM> brandsVMList = new ArrayList<>();
        if (response != null && response.getData() != null && !response.getData().getBrands().isEmpty()) {
            for (BrandListData brandList : response.getData().getBrands()) {
                BrandsListVM brandsListVM = new BrandsListVM();
                brandsListVM.setId(brandList.getId());
                brandsListVM.setName(brandList.getName());
                brandsListVM.setImage(brandList.getImage());
                brandsListVM.setLink(brandList.getLink());
                brandsVMList.add(brandsListVM);
            }
        }
        return brandsVMList;
    }
}

package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.ProductFilterListVM;

public class BrandsDetailFilterListVM extends BrandsDetailModel {

    private ProductFilterListVM filterListVM;

    public BrandsDetailFilterListVM(ProductFilterListVM filterListVM) {

        super(BrandsDetailModel.VIEW_TYPE_DETAIL_FILGER_LIST);
        this.filterListVM = filterListVM;
    }

    public ProductFilterListVM getFilterListVM() {
        return filterListVM;
    }

    public void setFilterListVM(ProductFilterListVM filterListVM) {
        this.filterListVM = filterListVM;
    }
}

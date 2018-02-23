package com.goshop.app.presentation.model;

import java.util.List;

public class FilterMenuCategoryVM extends FilterMenuModel {

    private List<String> categorys;

    public FilterMenuCategoryVM(List<String> categorys) {
        super(FilterMenuModel.FILTER_CATEGORY);
        this.categorys = categorys;
    }

    public List<String> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<String> categorys) {
        this.categorys = categorys;
    }
}

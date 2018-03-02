package com.goshop.app.presentation.model;

import java.util.List;

public class FilterMenuFlowButtonVM extends FilterMenuModel {

    private List<String> categorys;

    public FilterMenuFlowButtonVM(List<String> categorys) {
        super(FilterMenuModel.FILTER_FLOWBUTTONS);
        this.categorys = categorys;
    }

    public List<String> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<String> categorys) {
        this.categorys = categorys;
    }
}

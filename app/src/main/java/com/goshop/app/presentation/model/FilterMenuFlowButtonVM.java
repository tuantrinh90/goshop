package com.goshop.app.presentation.model;

import java.util.List;

public class FilterMenuFlowButtonVM extends FilterMenuModel {

    private List<FilterFlowVM> filterFlowVMS;

    public FilterMenuFlowButtonVM(List<FilterFlowVM> filterFlowVMS) {
        super(FilterMenuModel.FILTER_FLOWBUTTONS);
        this.filterFlowVMS = filterFlowVMS;
    }

    public List<FilterFlowVM> getFilterFlowVMS() {
        return filterFlowVMS;
    }

    public void setFilterFlowVMS(
        List<FilterFlowVM> filterFlowVMS) {
        this.filterFlowVMS = filterFlowVMS;
    }

}

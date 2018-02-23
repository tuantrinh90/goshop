package com.goshop.app.presentation.model.widget;

public class WidgetSearchResultVM extends WidgetViewModel {

    private SearchResultDataVM data;

    private String name;

    public WidgetSearchResultVM(SearchResultDataVM data) {
        super(WidgetViewModel.VIEW_TYPE_SEARCH_RESULT);
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SearchResultDataVM getData() {
        return data;
    }

    public void setData(SearchResultDataVM data) {
        this.data = data;
    }


}

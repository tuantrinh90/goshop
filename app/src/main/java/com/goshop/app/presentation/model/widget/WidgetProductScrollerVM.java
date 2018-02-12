package com.goshop.app.presentation.model.widget;

/**
 * Created by helen on 2018/2/11.
 */

public class WidgetProductScrollerVM extends WidgetViewModel {

    private ProductCountVM count;

    private ProductDataVM data;

    private ProductDetailsVM details;

    private String id;

    private String name;

    private ProductPageVM page;

    private String title;

    public WidgetProductScrollerVM(String title, ProductDataVM data) {
        super(WidgetViewModel.VIEW_TYPE_PRODUCT_SCROLLER);
        this.title = title;
        this.data = data;
    }

    public ProductCountVM getCount() {
        return count;
    }

    public void setCount(ProductCountVM count) {
        this.count = count;
    }

    public ProductDataVM getData() {
        return data;
    }

    public void setData(ProductDataVM data) {
        this.data = data;
    }

    public ProductDetailsVM getDetails() {
        return details;
    }

    public void setDetails(ProductDetailsVM details) {
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductPageVM getPage() {
        return page;
    }

    public void setPage(ProductPageVM page) {
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

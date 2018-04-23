package com.goshop.app.presentation.model.widget;

import java.util.List;

public class WidgetProductScrollerVM extends WidgetViewModel {

    private String countTotal;

    private String detailLink;

    private String detailTitle;

    private String pageCurrent;

    private String pageNext;

    private List<VideoProductsVM> productsVMS;

    public WidgetProductScrollerVM(List<VideoProductsVM> productsVMS) {
        super(WidgetViewModel.VIEW_TYPE_PRODUCT_SCROLLER);
        this.productsVMS = productsVMS;
    }

    public List<VideoProductsVM> getProductsVMS() {
        return productsVMS;
    }

    public void setProductsVMS(
        List<VideoProductsVM> productsVMS) {
        this.productsVMS = productsVMS;
    }

    public String getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(String countTotal) {
        this.countTotal = countTotal;
    }

    public String getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(String pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public String getPageNext() {
        return pageNext;
    }

    public void setPageNext(String pageNext) {
        this.pageNext = pageNext;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailLink() {
        return detailLink;
    }

    public void setDetailLink(String detailLink) {
        this.detailLink = detailLink;
    }


}

package com.goshop.app.presentation.model;

import com.goshop.app.presentation.model.widget.VideoProductsVM;

import java.util.List;

public class BrandsDetailVM {

    private List<VideoProductsVM> filterProductsVMS;

    private int logoDefaut;

    private String logoSummary;

    private String logoUrl;

    private List<SortVM> sortVMS;

    public BrandsDetailVM(String logoUrl, int logoDefaut, String logoSummary,
        List<VideoProductsVM> filterProductsVMS,
        List<SortVM> sortVMS) {
        this.logoUrl = logoUrl;
        this.logoDefaut = logoDefaut;
        this.logoSummary = logoSummary;
        this.filterProductsVMS = filterProductsVMS;
        this.sortVMS = sortVMS;
    }

    public String getLogoSummary() {
        return logoSummary;
    }

    public void setLogoSummary(String logoSummary) {
        this.logoSummary = logoSummary;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public int getLogoDefaut() {
        return logoDefaut;
    }

    public void setLogoDefaut(int logoDefaut) {
        this.logoDefaut = logoDefaut;
    }

    public List<VideoProductsVM> getFilterProductsVMS() {
        return filterProductsVMS;
    }

    public void setFilterProductsVMS(
        List<VideoProductsVM> filterProductsVMS) {
        this.filterProductsVMS = filterProductsVMS;
    }

    public List<SortVM> getSortVMS() {
        return sortVMS;
    }

    public void setSortVMS(List<SortVM> sortVMS) {
        this.sortVMS = sortVMS;
    }
}

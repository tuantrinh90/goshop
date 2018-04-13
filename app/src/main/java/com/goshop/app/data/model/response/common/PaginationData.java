package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

public class PaginationData {

    @SerializedName("current_page")
    private int currentPage;

    private int limit;

    private String next;

    private String previous;

    /**
     * total_pages : 5
     * current_page : 2
     * limit : 10
     * next : http://<domain-name>/<base-path>/catalog/product/<sku>/reviews?website_id=1
     * &store_id=3&page=3&limit=10
     * previous : http://<domain-name>/<base-path>/catalog/product/<sku>/reviews?website_id=1
     * &store_id=3&page=1&limit=10
     */

    @SerializedName("total_pages")
    private int totalPages;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}

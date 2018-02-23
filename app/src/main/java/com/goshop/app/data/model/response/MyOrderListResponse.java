package com.goshop.app.data.model.response;

import com.goshop.app.data.model.Reponse;

import java.util.List;

public class MyOrderListResponse extends Reponse {

    private List<ResultsBean> results;

    private int status;

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {

        private int availability;

        private String brand;

        private String brandId;

        private int canViewPdp;

        private String category;

        private String color;

        private String date;

        private String id;

        private String image;

        private String itemId;

        private String name;

        private List<String> options;

        private String orderId;

        private String orderSn;

        private String price;

        private String productId;

        private int qty;

        private String size;

        private String status;

        private String statusCode;

        private String total;

        private String totalFormatted;

        private int type;

        private String vendorDisplayName;

        private String vendor_id;

        private int visibility;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getCanViewPdp() {
            return canViewPdp;
        }

        public void setCanViewPdp(int canViewPdp) {
            this.canViewPdp = canViewPdp;
        }

        public int getAvailability() {
            return availability;
        }

        public void setAvailability(int availability) {
            this.availability = availability;
        }

        public int getVisibility() {
            return visibility;
        }

        public void setVisibility(int visibility) {
            this.visibility = visibility;
        }

        public String getVendorDisplayName() {
            return vendorDisplayName;
        }

        public void setVendorDisplayName(String vendorDisplayName) {
            this.vendorDisplayName = vendorDisplayName;
        }

        public String getVendor_id() {
            return vendor_id;
        }

        public void setVendor_id(String vendor_id) {
            this.vendor_id = vendor_id;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        public String getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(String statusCode) {
            this.statusCode = statusCode;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderSn() {
            return orderSn;
        }

        public void setOrderSn(String orderSn) {
            this.orderSn = orderSn;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getTotalFormatted() {
            return totalFormatted;
        }

        public void setTotalFormatted(String totalFormatted) {
            this.totalFormatted = totalFormatted;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


    }
}

package com.goshop.app.data.model.response;

import com.goshop.app.data.model.Reponse;

import java.util.List;

/**
 * Created by img on 2018/1/29.
 */

public class MyOrderListResponse extends Reponse{

    /**
     * total : 1
     * results : [{"orderId":"311704","orderSn":"910312525","date":"21 Mar 2017",
     * "total":"208.00","totalFormatted":"RM 208.00","status":"Awaiting Cash Transfer",
     * "suborders":[{"statusCode":"pending","status":"Verifying Payment","id":"910312525-01",
     * "items":[{"productId":"145071","itemId":"467363","name":"PS4 DUALSHOCK®4 Wireless
     * Controller (Wave Blue)","brand":"PlayStation","brandId":"4813","category":"Others",
     * "qty":1,"price":"208.00","image":"catalog/product/594/u/g/ug100011ds4blue-(1).jpg",
     * "options":[],"canViewPdp":1,"availability":1,"visibility":1,
     * "vendorDisplayName":"USEDGAME","vendor_id":"594"}]}]}]
     * status : 1
     */

    private int total;

    private int status;

    private List<ResultsBean> results;

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

        /**
         * orderId : 311704
         * orderSn : 910312525
         * date : 21 Mar 2017
         * total : 208.00
         * totalFormatted : RM 208.00
         * status : Awaiting Cash Transfer
         * suborders : [{"statusCode":"pending","status":"Verifying Payment","id":"910312525-01",
         * "items":[{"productId":"145071","itemId":"467363","name":"PS4 DUALSHOCK®4 Wireless
         * Controller (Wave Blue)","brand":"PlayStation","brandId":"4813","category":"Others",
         * "qty":1,"price":"208.00","image":"catalog/product/594/u/g/ug100011ds4blue-(1).jpg",
         * "options":[],"canViewPdp":1,"availability":1,"visibility":1,
         * "vendorDisplayName":"USEDGAME","vendor_id":"594"}]}]
         */

        private String orderId;

        private String orderSn;

        private String date;

        private String total;

        private String totalFormatted;

        private String status;

        private List<SubordersBean> suborders;

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

        public List<SubordersBean> getSuborders() {
            return suborders;
        }

        public void setSuborders(List<SubordersBean> suborders) {
            this.suborders = suborders;
        }

        public static class SubordersBean {

            /**
             * statusCode : pending
             * status : Verifying Payment
             * id : 910312525-01
             * items : [{"productId":"145071","itemId":"467363","name":"PS4 DUALSHOCK®4 Wireless
             * Controller (Wave Blue)","brand":"PlayStation","brandId":"4813",
             * "category":"Others","qty":1,"price":"208.00",
             * "image":"catalog/product/594/u/g/ug100011ds4blue-(1).jpg","options":[],
             * "canViewPdp":1,"availability":1,"visibility":1,"vendorDisplayName":"USEDGAME",
             * "vendor_id":"594"}]
             */

            private String statusCode;

            private String status;

            private String id;

            private List<ItemsBean> items;

            public String getStatusCode() {
                return statusCode;
            }

            public void setStatusCode(String statusCode) {
                this.statusCode = statusCode;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {

                /**
                 * productId : 145071
                 * itemId : 467363
                 * name : PS4 DUALSHOCK®4 Wireless Controller (Wave Blue)
                 * brand : PlayStation
                 * brandId : 4813
                 * category : Others
                 * qty : 1
                 * price : 208.00
                 * image : catalog/product/594/u/g/ug100011ds4blue-(1).jpg
                 * options : []
                 * canViewPdp : 1
                 * availability : 1
                 * visibility : 1
                 * vendorDisplayName : USEDGAME
                 * vendor_id : 594
                 */

                private String productId;

                private String itemId;

                private String name;

                private String brand;

                private String brandId;

                private String category;

                private int qty;

                private String price;

                private String image;

                private int canViewPdp;

                private int availability;

                private int visibility;

                private String vendorDisplayName;

                private String vendor_id;

                private List<?> options;

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

                public List<?> getOptions() {
                    return options;
                }

                public void setOptions(List<?> options) {
                    this.options = options;
                }
            }
        }
    }
}

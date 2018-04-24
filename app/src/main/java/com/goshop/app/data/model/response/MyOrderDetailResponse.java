//package com.goshop.app.data.model.response;
//
//import java.util.List;
//
//public class MyOrderDetailResponse {
//
//    private BanktransferBean banktransfer;
//
//    private BillingAddressBean billingAddress;
//
//    private String customerName;
//
//    private String date;
//
//    private String grandTotal;
//
//    private int isBanktransfer;
//
//    private int isPickupInStore;
//
//    private int isRPayment;
//
//    private String orderComment;
//
//    private String orderId;
//
//    private String paymentCode;
//
//    private String paymentMethod;
//
//    private PickupAddressBean pickupAddress;
//
//    private ShippingAddressBean shippingAddress;
//
//    private String shippingFee;
//
//    private String state;
//
//    private int status;
//
//    private List<SubordersBean> suborders;
//
//    private String subtotal;
//
//    public String getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public String getSubtotal() {
//        return subtotal;
//    }
//
//    public void setSubtotal(String subtotal) {
//        this.subtotal = subtotal;
//    }
//
//    public String getShippingFee() {
//        return shippingFee;
//    }
//
//    public void setShippingFee(String shippingFee) {
//        this.shippingFee = shippingFee;
//    }
//
//    public String getGrandTotal() {
//        return grandTotal;
//    }
//
//    public void setGrandTotal(String grandTotal) {
//        this.grandTotal = grandTotal;
//    }
//
//    public ShippingAddressBean getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(ShippingAddressBean shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }
//
//    public BillingAddressBean getBillingAddress() {
//        return billingAddress;
//    }
//
//    public void setBillingAddress(BillingAddressBean billingAddress) {
//        this.billingAddress = billingAddress;
//    }
//
//    public PickupAddressBean getPickupAddress() {
//        return pickupAddress;
//    }
//
//    public void setPickupAddress(PickupAddressBean pickupAddress) {
//        this.pickupAddress = pickupAddress;
//    }
//
//    public String getPaymentMethod() {
//        return paymentMethod;
//    }
//
//    public void setPaymentMethod(String paymentMethod) {
//        this.paymentMethod = paymentMethod;
//    }
//
//    public String getOrderComment() {
//        return orderComment;
//    }
//
//    public void setOrderComment(String orderComment) {
//        this.orderComment = orderComment;
//    }
//
//    public int getIsBanktransfer() {
//        return isBanktransfer;
//    }
//
//    public void setIsBanktransfer(int isBanktransfer) {
//        this.isBanktransfer = isBanktransfer;
//    }
//
//    public BanktransferBean getBanktransfer() {
//        return banktransfer;
//    }
//
//    public void setBanktransfer(BanktransferBean banktransfer) {
//        this.banktransfer = banktransfer;
//    }
//
//    public int getIsRPayment() {
//        return isRPayment;
//    }
//
//    public void setIsRPayment(int isRPayment) {
//        this.isRPayment = isRPayment;
//    }
//
//    public int getIsPickupInStore() {
//        return isPickupInStore;
//    }
//
//    public void setIsPickupInStore(int isPickupInStore) {
//        this.isPickupInStore = isPickupInStore;
//    }
//
//    public String getPaymentCode() {
//        return paymentCode;
//    }
//
//    public void setPaymentCode(String paymentCode) {
//        this.paymentCode = paymentCode;
//    }
//
//    public List<SubordersBean> getSuborders() {
//        return suborders;
//    }
//
//    public void setSuborders(List<SubordersBean> suborders) {
//        this.suborders = suborders;
//    }
//
//    public static class ShippingAddressBean {
//
//        private String city;
//
//        private String country;
//
//        private String fax;
//
//        private String firstname;
//
//        private String lastname;
//
//        private String postcode;
//
//        private String region;
//
//        private String street;
//
//        private String telephone;
//
//        public String getFirstname() {
//            return firstname;
//        }
//
//        public void setFirstname(String firstname) {
//            this.firstname = firstname;
//        }
//
//        public String getLastname() {
//            return lastname;
//        }
//
//        public void setLastname(String lastname) {
//            this.lastname = lastname;
//        }
//
//        public String getCountry() {
//            return country;
//        }
//
//        public void setCountry(String country) {
//            this.country = country;
//        }
//
//        public String getRegion() {
//            return region;
//        }
//
//        public void setRegion(String region) {
//            this.region = region;
//        }
//
//        public String getCity() {
//            return city;
//        }
//
//        public void setCity(String city) {
//            this.city = city;
//        }
//
//        public String getStreet() {
//            return street;
//        }
//
//        public void setStreet(String street) {
//            this.street = street;
//        }
//
//        public String getPostcode() {
//            return postcode;
//        }
//
//        public void setPostcode(String postcode) {
//            this.postcode = postcode;
//        }
//
//        public String getTelephone() {
//            return telephone;
//        }
//
//        public void setTelephone(String telephone) {
//            this.telephone = telephone;
//        }
//
//        public String getFax() {
//            return fax;
//        }
//
//        public void setFax(String fax) {
//            this.fax = fax;
//        }
//    }
//
//    public static class BillingAddressBean {
//
//    }
//
//    public static class PickupAddressBean {
//
//    }
//
//    public static class BanktransferBean {
//
//    }
//
//    public static class SubordersBean {
//
//        private int availability;
//
//        private String brand;
//
//        private int brandId;
//
//        private int canViewPdp;
//
//        private String category;
//
//        private String image;
//
//        private String itemId;
//
//        private String name;
//
//        private List<?> options;
//
//        private String price;
//
//        private String productId;
//
//        private int qty;
//
//        private String status;
//
//        private int stockQty;
//
//        private int visibility;
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public String getProductId() {
//            return productId;
//        }
//
//        public void setProductId(String productId) {
//            this.productId = productId;
//        }
//
//        public String getItemId() {
//            return itemId;
//        }
//
//        public void setItemId(String itemId) {
//            this.itemId = itemId;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getBrand() {
//            return brand;
//        }
//
//        public void setBrand(String brand) {
//            this.brand = brand;
//        }
//
//        public int getBrandId() {
//            return brandId;
//        }
//
//        public void setBrandId(int brandId) {
//            this.brandId = brandId;
//        }
//
//        public String getCategory() {
//            return category;
//        }
//
//        public void setCategory(String category) {
//            this.category = category;
//        }
//
//        public int getQty() {
//            return qty;
//        }
//
//        public void setQty(int qty) {
//            this.qty = qty;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
//        }
//
//        public String getImage() {
//            return image;
//        }
//
//        public void setImage(String image) {
//            this.image = image;
//        }
//
//        public int getCanViewPdp() {
//            return canViewPdp;
//        }
//
//        public void setCanViewPdp(int canViewPdp) {
//            this.canViewPdp = canViewPdp;
//        }
//
//        public int getAvailability() {
//            return availability;
//        }
//
//        public void setAvailability(int availability) {
//            this.availability = availability;
//        }
//
//        public int getVisibility() {
//            return visibility;
//        }
//
//        public void setVisibility(int visibility) {
//            this.visibility = visibility;
//        }
//
//        public int getStockQty() {
//            return stockQty;
//        }
//
//        public void setStockQty(int stockQty) {
//            this.stockQty = stockQty;
//        }
//
//        public List<?> getOptions() {
//            return options;
//        }
//
//        public void setOptions(List<?> options) {
//            this.options = options;
//        }
//    }
//}

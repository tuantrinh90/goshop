package com.goshop.app.data.model.response;

import java.util.List;

/**
 * Created by img on 2018/1/31.
 */

public class MyOrderDetailReponse {

    /**
     * orderId : 44752
     * date : 11 Jan 2018
     * status : processing
     * status : 1
     * customerName : Test Test
     * subtotal : HK$1,461.00
     * shippingFee : HK$0.00
     * grandTotal : HK$1,461.00
     * shippingAddress : {"firstname":"Test","lastname":"Test","country":"Hong Kong",
     * "region":"Discovery Bay & Tung Chung","city":"Eeeee","street":"Weeeeeee","postcode":"123",
     * "telephone":"123456789","fax":"123456789"}
     * billingAddress : {"firstname":"Test","lastname":"Test","country":"Hong Kong",
     * "region":"Discovery Bay & Tung Chung","city":"Eeeee","street":"Weeeeeee","postcode":"123",
     * "telephone":"123456789","fax":"123456789"}
     * pickupAddress : {}
     * paymentMethod :     <p><span>PayPal Express Checkout</span></p>
     <table>
     <tbody>
     <tr>
     <td>Payer Email:</td>
     </tr>
     <tr>
     <td>wnppayment-buyer@mailinator.com</td>
     </tr>
     </tbody>
     </table>

     * orderComment : asdfasd fasd fasd fsda er g fgd . afsd as df asd fdsa afd sasdf asdf asdf
     * qerf feqfeq f sda sadf sad dsfa as df afs d fqefeq qe fas d df ads
     jjjjjjwe
     asfd sadfk sdf as df asd f
     asdf as df asd
     * isBanktransfer : 0
     * banktransfer : {}
     * isRPayment : 0
     * isPickupInStore : 0
     * paymentCode : paypal_express
     * suborders : [{"items":[{"productId":"10383","itemId":"149038","name":"DogNog Refill Weight
     * : 8oz","brand":"Steve's Real Food","brandId":422,"category":"Hip & Joint Support","qty":1,
     * "price":"298.00","image":"catalog/product/s/t/steve_s.jpg","options":[],"canViewPdp":1,
     * "availability":1,"visibility":1,"stockQty":9}]},{"items":[{"productId":"566",
     * "itemId":"149039","name":"Butcher & Bushel Chicken Wing & Thigh Dinner Weight : 12.7oz",
     * "brand":"Castor & Pollux","brandId":492,"category":null,"qty":4,"price":"26.00",
     * "image":"catalog/product/b/u/butcher_bushel_group.jpg","options":[],"canViewPdp":1,
     * "availability":1,"visibility":1,"stockQty":14}]},{"items":[{"productId":"566",
     * "itemId":"149040","name":"Butcher & Bushel Shredded Chicken Dinner Weight : 12.7oz",
     * "brand":"Castor & Pollux","brandId":492,"category":null,"qty":4,"price":"26.00",
     * "image":"catalog/product/b/u/butcher_bushel_group.jpg","options":[],"canViewPdp":1,
     * "availability":1,"visibility":1,"stockQty":5}]},{"items":[{"productId":"8",
     * "itemId":"149041","name":"Wild Kangaroo & Apples Weight : 4lb","brand":"Addiction",
     * "brandId":33,"category":"","qty":1,"price":"215.00",
     * "image":"catalog/product/_/2/_20150711162111_17051_43.png","options":[],"canViewPdp":1,
     * "availability":0,"visibility":1,"stockQty":0}]},{"items":[{"productId":"8",
     * "itemId":"149042","name":"Wild Kangaroo & Apples Weight : 20lb","brand":"Addiction",
     * "brandId":33,"category":"Weight Control","qty":1,"price":"740.00",
     * "image":"catalog/product/_/2/_20150711162111_17051_43.png","options":[],"canViewPdp":1,
     * "availability":1,"visibility":1,"stockQty":4}]}]
     */

    private String orderId;

    private String date;

    private String state;

    private int status;

    private String customerName;

    private String subtotal;

    private String shippingFee;

    private String grandTotal;

    private ShippingAddressBean shippingAddress;

    private BillingAddressBean billingAddress;

    private PickupAddressBean pickupAddress;

    private String paymentMethod;

    private String orderComment;

    private int isBanktransfer;

    private BanktransferBean banktransfer;

    private int isRPayment;

    private int isPickupInStore;

    private String paymentCode;

    private List<SubordersBean> suborders;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public ShippingAddressBean getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddressBean shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BillingAddressBean getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddressBean billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PickupAddressBean getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(PickupAddressBean pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public int getIsBanktransfer() {
        return isBanktransfer;
    }

    public void setIsBanktransfer(int isBanktransfer) {
        this.isBanktransfer = isBanktransfer;
    }

    public BanktransferBean getBanktransfer() {
        return banktransfer;
    }

    public void setBanktransfer(BanktransferBean banktransfer) {
        this.banktransfer = banktransfer;
    }

    public int getIsRPayment() {
        return isRPayment;
    }

    public void setIsRPayment(int isRPayment) {
        this.isRPayment = isRPayment;
    }

    public int getIsPickupInStore() {
        return isPickupInStore;
    }

    public void setIsPickupInStore(int isPickupInStore) {
        this.isPickupInStore = isPickupInStore;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public List<SubordersBean> getSuborders() {
        return suborders;
    }

    public void setSuborders(List<SubordersBean> suborders) {
        this.suborders = suborders;
    }

    public static class ShippingAddressBean {

        /**
         * firstname : Test
         * lastname : Test
         * country : Hong Kong
         * region : Discovery Bay & Tung Chung
         * city : Eeeee
         * street : Weeeeeee
         * postcode : 123
         * telephone : 123456789
         * fax : 123456789
         */

        private String firstname;

        private String lastname;

        private String country;

        private String region;

        private String city;

        private String street;

        private String postcode;

        private String telephone;

        private String fax;

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getPostcode() {
            return postcode;
        }

        public void setPostcode(String postcode) {
            this.postcode = postcode;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getFax() {
            return fax;
        }

        public void setFax(String fax) {
            this.fax = fax;
        }
    }

    public static class BillingAddressBean {

    }

    public static class PickupAddressBean {

    }

    public static class BanktransferBean {

    }

    public static class SubordersBean{

        /**
         * productId : 10383
         * itemId : 149038
         * name : DogNog Refill Weight : 8oz
         * brand : Steve's Real Food
         * brandId : 422
         * category : Hip & Joint Support
         * qty : 1
         * price : 298.00
         * image : catalog/product/s/t/steve_s.jpg
         * options : []
         * canViewPdp : 1
         * availability : 1
         * visibility : 1
         * stockQty : 9
         */

        private String productId;

        private String itemId;

        private String name;

        private String brand;

        private int brandId;

        private String category;

        private int qty;

        private String price;

        private String image;

        private int canViewPdp;

        private int availability;

        private int visibility;

        private int stockQty;

        private List<?> options;

        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

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

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
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

        public int getStockQty() {
            return stockQty;
        }

        public void setStockQty(int stockQty) {
            this.stockQty = stockQty;
        }

        public List<?> getOptions() {
            return options;
        }

        public void setOptions(List<?> options) {
            this.options = options;
        }
    }
}

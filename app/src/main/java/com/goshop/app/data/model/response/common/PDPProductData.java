package com.goshop.app.data.model.response.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PDPProductData {

    @SerializedName("additional_information")
    private List<AdditionalInformationData> additionalInformation;

    private String availability;

    private List<String> categories;

    private boolean cod;

    private String details;

    @SerializedName("free_gift")
    private List<FreeGiftData> freeGift;

    private List<String> images;

    private List<String> labels;

    private String link;

    private String name;

    private PriceData price;

    /**
     * sku : 9102820
     * name : Manjung Korean Crispy Seaweed 3
     * images : ["https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg","https://image.goshop
     * .com.my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg","https://image
     * .goshop.com.my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg"]
     * video_url : ["https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_400.jpg"]
     * link : /prd/9102820
     * categories : ["123","456"]
     * cod : true
     * availability : In Stock
     * summary : Meylana Jubah Amanina Set
     * details : Lorem ipsum
     * free_gift : [{"sku":"123","name":"Free gift","image":"https://image.goshop.com
     * .my/resources/ms/image/contents/prd/22/32/9102820_01_35.jpg"}]
     * price : {"RM":{"original":"200.00","discounted":"149.00","discount_title":"25% OFF"}}
     * labels : ["New","Best Selling"]
     * super_attribute : [{"id":"361","name":"Size","variant":[{"id":"1709","name":"S"},
     * {"id":"1701","name":"L"}]},{"id":"362","name":"Color","variant":[{"id":"1709",
     * "name":"Red"},{"id":"1701","name":"Blue"}]}]
     * additional_information : [{"attribute_label":"Brands","value_label":"Meylana Jubah
     * Amanina"}]
     */

    private String sku;

    private String summary;

    @SerializedName("super_attribute")
    private List<SuperAttributeData> superAttribute;

    @SerializedName("video_url")
    private List<String> videoUrl;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isCod() {
        return cod;
    }

    public void setCod(boolean cod) {
        this.cod = cod;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public PriceData getPrice() {
        return price;
    }

    public void setPrice(PriceData price) {
        this.price = price;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(List<String> videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<FreeGiftData> getFreeGift() {
        return freeGift;
    }

    public void setFreeGift(List<FreeGiftData> freeGift) {
        this.freeGift = freeGift;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<SuperAttributeData> getSuperAttribute() {
        return superAttribute;
    }

    public void setSuperAttribute(List<SuperAttributeData> superAttribute) {
        this.superAttribute = superAttribute;
    }

    public List<AdditionalInformationData> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(
        List<AdditionalInformationData> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

}

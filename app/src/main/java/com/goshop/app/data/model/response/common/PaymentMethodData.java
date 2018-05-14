package com.goshop.app.data.model.response.common;

import java.util.List;

public class PaymentMethodData {
    /**
     * id : 123
     * name : Online Banking
     * months : [3,6,9]
     */

    private String id;

    private List<String> months;

    private String name;

    /**
     * code : apgbanktrasfer
     * title : Bank Transfer
     */

    private String code;

    private String title;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<String> getMonths() {
        return months;
    }

    public void setMonths(List<String> months) {
        this.months = months;
    }
}

package com.goshop.app.data.model.response;

import java.util.List;

public class MyEGiftResponse extends Response {

    /**
     * data : {"eGiftCard":[{"code":"ABCDE","balance":"RM 120.00","status":"Active",
     * "sentby":"User","expire":"2018-02-01"},{"code":"ABCDE","balance":"RM 120.00",
     * "status":"Active","sentby":"User","expire":"2018-02-01"}]}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        private List<EGiftCardData> eGiftCard;

        public List<EGiftCardData> getEGiftCard() {
            return eGiftCard;
        }

        public void setEGiftCard(List<EGiftCardData> eGiftCard) {
            this.eGiftCard = eGiftCard;
        }

        public static class EGiftCardData {

            private String balance;

            /**
             * code : ABCDE
             * balance : RM 120.00
             * status : Active
             * sentby : User
             * expire : 2018-02-01
             */

            private String code;

            private String expire;

            private String sentby;

            private String status;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getSentby() {
                return sentby;
            }

            public void setSentby(String sentby) {
                this.sentby = sentby;
            }

            public String getExpire() {
                return expire;
            }

            public void setExpire(String expire) {
                this.expire = expire;
            }
        }
    }
}

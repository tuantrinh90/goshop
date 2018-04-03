package com.goshop.app.data.model.response;

public class ProfileResponse extends Response {

    /**
     * data : {"customer":{"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
     * "mobile_number":"601012345678","language":{"id":1,"name":"Malay"},"dob":"1993-06-12",
     * "race":{"id":1,"name":"Malay"},"wishlist_tems_count":2,"cart_items_count":5,
     * "available_goshop_points":1000}}
     * message : {"display_message":"","status":"success"}
     */

    private Datas data;

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    public static class Datas {

        /**
         * customer : {"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
         * "mobile_number":"601012345678","language":{"id":1,"name":"Malay"},"dob":"1993-06-12",
         * "race":{"id":1,"name":"Malay"},"wishlist_tems_count":2,"cart_items_count":5,
         * "available_goshop_points":1000}
         */

        private CustomerData customer;

        public CustomerData getCustomer() {
            return customer;
        }

        public void setCustomer(CustomerData customer) {
            this.customer = customer;
        }

        public static class CustomerData {

            private int available_goshop_points;

            private int cart_items_count;

            private String dob;

            private String email;

            /**
             * id : 123124
             * title : Mr
             * name : Abc Def
             * email : abc@xyz.com
             * mobile_number : 601012345678
             * language : {"id":1,"name":"Malay"}
             * dob : 1993-06-12
             * race : {"id":1,"name":"Malay"}
             * wishlist_tems_count : 2
             * cart_items_count : 5
             * available_goshop_points : 1000
             */

            private int id;

            private LanguageData language;

            private String mobile_number;

            private String name;

            private RaceData race;

            private String title;

            private int wishlist_tems_count;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getMobile_number() {
                return mobile_number;
            }

            public void setMobile_number(String mobile_number) {
                this.mobile_number = mobile_number;
            }

            public LanguageData getLanguage() {
                return language;
            }

            public void setLanguage(LanguageData language) {
                this.language = language;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public RaceData getRace() {
                return race;
            }

            public void setRace(RaceData race) {
                this.race = race;
            }

            public int getWishlist_tems_count() {
                return wishlist_tems_count;
            }

            public void setWishlist_tems_count(int wishlist_tems_count) {
                this.wishlist_tems_count = wishlist_tems_count;
            }

            public int getCart_items_count() {
                return cart_items_count;
            }

            public void setCart_items_count(int cart_items_count) {
                this.cart_items_count = cart_items_count;
            }

            public int getAvailable_goshop_points() {
                return available_goshop_points;
            }

            public void setAvailable_goshop_points(int available_goshop_points) {
                this.available_goshop_points = available_goshop_points;
            }

            public static class LanguageData {

                /**
                 * id : 1
                 * name : Malay
                 */

                private int id;

                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public static class RaceData {

                /**
                 * id : 1
                 * name : Malay
                 */

                private int id;

                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }

}

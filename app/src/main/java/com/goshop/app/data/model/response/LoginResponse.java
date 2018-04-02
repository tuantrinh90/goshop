package com.goshop.app.data.model.response;

public class LoginResponse extends Response{

    /**
     * data : {"customer":{"id":123124,"title":"Mr","name":"Abc Def","email":"abc@xyz.com",
     * "mobile_number":12345678,"language":{"id":1,"name":"Malay"},"dob":"1991-06-20",
     * "race":{"id":1,"name":"Indian"},"max_failed_login":5,"failed_login_attempt":2,
     * "token":{"token":"8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5","expiration":"3600"}}}
     * message : {"display_message":"You have logged in successfully","status":"success"}
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
         * "mobile_number":12345678,"language":{"id":1,"name":"Malay"},"dob":"1991-06-20",
         * "race":{"id":1,"name":"Indian"},"max_failed_login":5,"failed_login_attempt":2,
         * "token":{"token":"8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5","expiration":"3600"}}
         */

        private Customer customer;

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public static class Customer {

            private String dob;

            private String email;

            private int failed_login_attempt;

            /**
             * id : 123124
             * title : Mr
             * name : Abc Def
             * email : abc@xyz.com
             * mobile_number : 12345678
             * language : {"id":1,"name":"Malay"}
             * dob : 1991-06-20
             * race : {"id":1,"name":"Indian"}
             * max_failed_login : 5
             * failed_login_attempt : 2
             * token : {"token":"8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5","expiration":"3600"}
             */

            private int id;

            private Language language;

            private int max_failed_login;

            private String mobile_number;

            private String name;

            private Race race;

            private String title;

            private TokenBean token;

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

            public Language getLanguage() {
                return language;
            }

            public void setLanguage(Language language) {
                this.language = language;
            }

            public String getDob() {
                return dob;
            }

            public void setDob(String dob) {
                this.dob = dob;
            }

            public Race getRace() {
                return race;
            }

            public void setRace(Race race) {
                this.race = race;
            }

            public int getMax_failed_login() {
                return max_failed_login;
            }

            public void setMax_failed_login(int max_failed_login) {
                this.max_failed_login = max_failed_login;
            }

            public int getFailed_login_attempt() {
                return failed_login_attempt;
            }

            public void setFailed_login_attempt(int failed_login_attempt) {
                this.failed_login_attempt = failed_login_attempt;
            }

            public TokenBean getToken() {
                return token;
            }

            public void setToken(TokenBean token) {
                this.token = token;
            }

            public static class Language {

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

            public static class Race {

                /**
                 * id : 1
                 * name : Indian
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

            public static class TokenBean {

                private String expiration;

                /**
                 * token : 8s4ht6x8rlmq9k3cjigpqgvf3cfn1nd5
                 * expiration : 3600
                 */

                private String token;

                public String getToken() {
                    return token;
                }

                public void setToken(String token) {
                    this.token = token;
                }

                public String getExpiration() {
                    return expiration;
                }

                public void setExpiration(String expiration) {
                    this.expiration = expiration;
                }
            }
        }
    }

}

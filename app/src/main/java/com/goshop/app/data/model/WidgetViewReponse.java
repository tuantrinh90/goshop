package com.goshop.app.data.model;

import java.util.List;

public class WidgetViewReponse extends Reponse {

    private List<WidgetlistBean> widgetlist;

    public List<WidgetlistBean> getWidgetlist() {
        return widgetlist;
    }

    public void setWidgetlist(List<WidgetlistBean> widgetlist) {
        this.widgetlist = widgetlist;
    }

    public static class WidgetlistBean {

        private AutoPlayBean autoPlay;

        private WidgetDataBean data;

        /**
         * id : 1001
         * name : Carousel
         * data : {"items":[{"image":"https://image.goshop.com
         * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg",
         * "link":"/prd/20052232"},{"image":"https://image.goshop.com
         * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg",
         * "link":"/prolandSKU/20052232"},{"image":"https://image.goshop.com
         * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg",
         * "link":"/promotionlandBanner/20052232"},{"image":"https://image.goshop.com
         * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg","link":"/prd/20052232"}]}
         * title :
         * autoPlay : {"enabled":"true","duration":"500","loop":"8","direction":"right"}
         * pageTitle :
         */

        private String id;

        private String name;

        private String pageTitle;

        private String title;

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

        public WidgetDataBean getData() {
            return data;
        }

        public void setData(WidgetDataBean data) {
            this.data = data;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public AutoPlayBean getAutoPlay() {
            return autoPlay;
        }

        public void setAutoPlay(AutoPlayBean autoPlay) {
            this.autoPlay = autoPlay;
        }

        public String getPageTitle() {
            return pageTitle;
        }

        public void setPageTitle(String pageTitle) {
            this.pageTitle = pageTitle;
        }

        public static class WidgetDataBean {

            private List<WidgetItemsBean> items;

            public List<WidgetItemsBean> getItems() {
                return items;
            }

            public void setItems(List<WidgetItemsBean> items) {
                this.items = items;
            }

            public static class WidgetItemsBean {

                /**
                 * image : https://image.goshop.com
                 * .my/resources/ms/image/contents/prd/22/32/20052232_01_400.jpg
                 * link : /prd/20052232
                 */

                private String image;

                private String link;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }
            }
        }

        public static class AutoPlayBean {

            private String direction;

            private String duration;

            /**
             * enabled : true
             * duration : 500
             * loop : 8
             * direction : right
             */

            private String enabled;

            private String loop;

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getLoop() {
                return loop;
            }

            public void setLoop(String loop) {
                this.loop = loop;
            }

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }
        }
    }
//todo  wait for api

}

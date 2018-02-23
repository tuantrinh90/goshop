package com.goshop.app.data.model.response;

import java.io.Serializable;
import java.util.List;

public class HomeResponse {

    private List<BottomSlide> bottomSlide;

    private List<CenterVideo> centerVideo;

    private String content;

    private int itemType;

    private int spanSize;

    private List<TopBanner> topBanner;

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getItemType() {
        return itemType;
    }

    public List<TopBanner> getTopBanner() {
        return topBanner;
    }

    public void setTopBanner(
        List<TopBanner> topBanner) {
        this.topBanner = topBanner;
    }

    public List<CenterVideo> getCenterVideo() {
        return centerVideo;
    }

    public void setCenterVideo(List<CenterVideo> centerVideo) {
        this.centerVideo = centerVideo;
    }

    public List<BottomSlide> getBottomSlide() {
        return bottomSlide;
    }

    public void setBottomSlide(
        List<BottomSlide> bottomSlide) {
        this.bottomSlide = bottomSlide;
    }

    public static class TopBanner implements Serializable {

        private String img;

        //ic_search productDetail promotion noSkip
        private String type;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class CenterVideo {

        private List<CenterVideoList> centerVideoList;

        private CenterVideoMsg centerVideoMsg;

        private int itemType;

        private int position;

        private PrevAndNext prevAndNext;

        public int getItemType() {
            return itemType;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public CenterVideoMsg getCenterVideoMsg() {
            return centerVideoMsg;
        }

        public void setCenterVideoMsg(CenterVideoMsg centerVideoMsg) {
            this.centerVideoMsg = centerVideoMsg;
        }

        public List<CenterVideoList> getCenterVideoList() {
            return centerVideoList;
        }

        public void setCenterVideoList(
            List<CenterVideoList> centerVideoList) {
            this.centerVideoList = centerVideoList;
        }

        public PrevAndNext getPrevAndNext() {
            return prevAndNext;
        }

        public void setPrevAndNext(PrevAndNext prevAndNext) {
            this.prevAndNext = prevAndNext;
        }

        public static class CenterVideoMsg {

            private String videoMsg;

            public String getVideoMsg() {
                return videoMsg;
            }

            public void setVideoMsg(String videoMsg) {
                this.videoMsg = videoMsg;
            }
        }

        public static class CenterVideoList {

            private String imgUrl;

            private int itemType;

            private String productName;

            private String productPrice;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(String productPrice) {
                this.productPrice = productPrice;
            }
        }

        public static class PrevAndNext {

            private String imgUrls;

            private String productName;

            private String productPrice;

            public String getImgUrls() {
                return imgUrls;
            }

            public void setImgUrls(String imgUrls) {
                this.imgUrls = imgUrls;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(String productPrice) {
                this.productPrice = productPrice;
            }
        }
    }

    public static class BottomSlide implements Serializable {

        private List<BottomSlideChild> bottomSlideChildren;

        private String headImageUrl;

        private String slideTitle;

        private int viewType;

        public String getHeadImageUrl() {
            return headImageUrl;
        }

        public void setHeadImageUrl(String headImageUrl) {
            this.headImageUrl = headImageUrl;
        }

        public String getSlideTitle() {
            return slideTitle;
        }

        public void setSlideTitle(String slideTitle) {
            this.slideTitle = slideTitle;
        }

        public int getViewType() {
            return viewType;
        }

        public void setViewType(int viewType) {
            this.viewType = viewType;
        }

        public List<BottomSlideChild> getBottomSlideChildren() {
            return bottomSlideChildren;
        }

        public void setBottomSlideChildren(
            List<BottomSlideChild> bottomSlideChildren) {
            this.bottomSlideChildren = bottomSlideChildren;
        }

        public static class BottomSlideChild {

            private String imageUrl;

            private String productName;

            private String productPrice;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(String productPrice) {
                this.productPrice = productPrice;
            }
        }
    }
}

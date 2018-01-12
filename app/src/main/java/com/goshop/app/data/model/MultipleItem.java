package com.goshop.app.data.model;

import java.util.List;

/**
 * Created by img on 2018/1/5.
 */

public class MultipleItem {

    private int itemType;

    private int spanSize;

    private TopBanner topBanner;

    private List<CenterVideo> centerVideo;

    private List<BottomSlide> bottomSlide;

    private String content;

    public MultipleItem(int itemType, int spanSize, String content) {
        this.itemType = itemType;
        this.spanSize = spanSize;
        this.content = content;
    }

    public MultipleItem(int itemType, String content) {
        this.itemType = itemType;
        this.content = content;
    }

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

    public TopBanner getTopBanner() {
        return topBanner;
    }

    public void setTopBanner(TopBanner topBanner) {
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

    public static class TopBanner {

        private List<String> imgs;

        public TopBanner(List<String> imgs) {
            this.imgs = imgs;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }
    }

    public static class CenterVideo {

        private int position;

        private CenterVideoMsg centerVideoMsg;

        private List<CenterVideoList> centerVideoList;

        private PrevAndNext prevAndNext;

        private int itemType;

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

            private String productName;

            private String productPrice;

            private int itemType;

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

    public static class BottomSlide {

        private String headImageUrl;

        private String slideTitle;

        private List<BottomSlideChild> bottomSlideChildren;

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

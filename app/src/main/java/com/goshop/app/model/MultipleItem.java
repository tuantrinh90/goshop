package com.goshop.app.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by img on 2018/1/5.
 */

public class MultipleItem implements MultiItemEntity {
    private int itemType;
    private int spanSize;
    private TopBanner topBanner;
    private List<CenterVideo> centerVideo;
    private BottomSlide bottomSlide;

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

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public static class TopBanner{
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
    public static class CenterVideo implements MultiItemEntity{
        private int position;

        private CenterVideoMsg centerVideoMsg;
        private CenterVideoList centerVideoList;
        private PrevAndNext prevAndNext;
        private int itemType;

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

        @Override
        public int getItemType() {
            return itemType;
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

        public CenterVideoList getCenterVideoList() {
            return centerVideoList;
        }

        public void setCenterVideoList(CenterVideoList centerVideoList) {
            this.centerVideoList = centerVideoList;
        }

        public PrevAndNext getPrevAndNext() {
            return prevAndNext;
        }

        public void setPrevAndNext(PrevAndNext prevAndNext) {
            this.prevAndNext = prevAndNext;
        }

        public static class CenterVideoMsg{
            private String videoMsg;



            public String getVideoMsg() {
                return videoMsg;
            }

            public void setVideoMsg(String videoMsg) {
                this.videoMsg = videoMsg;
            }
        }

        public static class CenterVideoList{
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

    public static class BottomSlide{
        List<BottomSlideItem> bottomSlideItems;
        public static class BottomSlideItem {

        }
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

    public BottomSlide getBottomSlide() {
        return bottomSlide;
    }

    public void setBottomSlide(BottomSlide bottomSlide) {
        this.bottomSlide = bottomSlide;
    }
}

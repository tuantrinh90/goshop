package com.goshop.app.utils;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by img on 2018/1/5.
 */

public class ServiceData {
    static String productName= GoShopApplication.getAppContext().getResources().getString(R.string.home_item_test_product_name);
    static String productPrice=GoShopApplication.getAppContext().getResources().getString(R.string.home_item_test_product_price);
    public static List<MultipleItem> getBaseData(){
        List<MultipleItem> list = new ArrayList<>();
        list.addAll(getTopBannerData());
        list.add(new MultipleItem(Const.HOME_TOP_CATEGORY, ""));
        list.addAll(getContentVideoData());
        list.addAll(getBottomSlidedata());
        return list;
    }

    public static List<MultipleItem> getTopBannerData() {
        List<MultipleItem> list = new ArrayList<>();
        //top banner
        List<String> imgs= Arrays.asList(Const.HOME_TEST_IMG1,
                Const.HOME_TEST_IMG2,
                Const.HOME_TEST_IMG3);
        MultipleItem.TopBanner topbanner=new MultipleItem.TopBanner(imgs);
        MultipleItem multipleItemTopBanner= new MultipleItem(Const.HOME_TOP_BANNER,"");
        multipleItemTopBanner.setTopBanner(topbanner);
        list.add(multipleItemTopBanner);

        return list;
    }

    public static List<MultipleItem> getContentVideoData(){
        List<MultipleItem> list = new ArrayList<>();
        List<MultipleItem.CenterVideo> centerVideos = new ArrayList<>();

        for (int i=0;i<4;i++){
            MultipleItem.CenterVideo centerVideo=new MultipleItem.CenterVideo();
            MultipleItem.CenterVideo.CenterVideoMsg centerVideoMsg=new MultipleItem.CenterVideo.CenterVideoMsg();
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_VIDEO);
            centerVideoMsg.setVideoMsg("我是第"+i+"頁");
            centerVideo.setPosition(i);
            centerVideo.setCenterVideoMsg(centerVideoMsg);
//            JToolUtils.printObject(centerVideo);
            List<MultipleItem.CenterVideo.CenterVideoList> centerVideoLists=new ArrayList<>();
            for (int j=0;j<2;j++){
                MultipleItem.CenterVideo.CenterVideoList centerVideoList= new MultipleItem.CenterVideo.CenterVideoList();
                centerVideoList.setImgUrl(Const.HOME_TEST_IMG1);
                centerVideoList.setProductName(productName+j);
                centerVideoList.setProductPrice(productPrice);
                centerVideo.setItemType(1);
                centerVideoLists.add(centerVideoList);
            }
            centerVideo.setCenterVideoList(centerVideoLists);

//            JToolUtils.printObject(centerVideo);
            MultipleItem.CenterVideo.PrevAndNext prevAndNext=new MultipleItem.CenterVideo.PrevAndNext();
            prevAndNext.setImgUrls(Const.HOME_TEST_IMG1);
            prevAndNext.setProductName(productName+i);
            prevAndNext.setProductPrice(productPrice);
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT);
            centerVideo.setPrevAndNext(prevAndNext);
            centerVideos.add(centerVideo);
        }
//        JToolUtils.printObject(centerVideos);


        MultipleItem multipleItemTopBanner= new MultipleItem(Const.HOME_CENTER_VIDEO,"");
        multipleItemTopBanner.setCenterVideo(centerVideos);
        list.add(multipleItemTopBanner);
        return list;
    }

    public static List<MultipleItem> getBottomSlidedata(){
        List<MultipleItem> multipleItems=new ArrayList<>();
        MultipleItem bottomSldieItem= new MultipleItem(Const.HOME_CENTER_VIDEO,"");
        List<MultipleItem.BottomSlide> bottomSlides=new ArrayList<>();
        for (int i=0;i<3;i++){
            String headImageUrl=Const.HOME_TEST_IMG3;
            MultipleItem.BottomSlide bottomSlideHeader=new MultipleItem.BottomSlide();
            bottomSlideHeader.setHeadImageUrl(headImageUrl);
            bottomSlideHeader.setViewType(Const.BOTTOM_SLIDE_HEADER_IMG);
            bottomSlides.add(bottomSlideHeader);
            MultipleItem.BottomSlide bottomSlideTitle=new MultipleItem.BottomSlide();
            bottomSlideTitle.setViewType(Const.BOTTOM_SLIDE_TITLE);
            bottomSlideTitle.setSlideTitle(GoShopApplication.getAppContext().getResources().getString(R.string.home_bottom_slide_title));
            bottomSlides.add(bottomSlideTitle);
            MultipleItem.BottomSlide bottomSlideItem=new MultipleItem.BottomSlide();
            List<MultipleItem.BottomSlide.BottomSlideChild> bottomSlideChildren=new ArrayList<>();
            for (int j=0;j<10;j++){
                MultipleItem.BottomSlide.BottomSlideChild bottomSlideBody=new MultipleItem.BottomSlide.BottomSlideChild();
                bottomSlideBody.setProductName(productName);
                bottomSlideBody.setProductPrice(productPrice);
                bottomSlideBody.setImageUrl(Const.HOME_TEST_IMG2);
                bottomSlideChildren.add(bottomSlideBody);
            }
            bottomSlideItem.setViewType(Const.BOTTOM_SLIDE_BODY);
            bottomSlideItem.setBottomSlideChildren(bottomSlideChildren);
            bottomSlides.add(bottomSlideItem);
        }
        bottomSldieItem.setBottomSlide(bottomSlides);
        multipleItems.add(bottomSldieItem);
        return multipleItems;
    }


}

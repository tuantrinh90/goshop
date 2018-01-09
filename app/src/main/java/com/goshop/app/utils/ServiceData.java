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

    public static List<MultipleItem> getBaseData(){
        List<MultipleItem> list = new ArrayList<>();
        list.addAll(getTopBannerData());
        list.add(new MultipleItem(Const.HOME_TOP_CATEGORY, ""));
        list.addAll(getContentVideoData());
        list.add(new MultipleItem(Const.HOME_BOTTOM_SLIDE, ""));
        list.add(new MultipleItem(Const.HOME_BOTTOM_SLIDE, ""));
        list.add(new MultipleItem(Const.HOME_BOTTOM_SLIDE, ""));
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
        String productName= GoShopApplication.getAppContext().getResources().getString(R.string.home_item_test_product_name);
        String productPrice=GoShopApplication.getAppContext().getResources().getString(R.string.home_item_test_product_price);

        List<MultipleItem> list = new ArrayList<>();
        List<MultipleItem.CenterVideo> centerVideos = new ArrayList<>();

        for (int i=0;i<1;i++){
            MultipleItem.CenterVideo centerVideo=new MultipleItem.CenterVideo();
            MultipleItem.CenterVideo.CenterVideoMsg centerVideoMsg=new MultipleItem.CenterVideo.CenterVideoMsg();
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_VIDEO);
            centerVideoMsg.setVideoMsg("我是第"+i+"頁");
            centerVideo.setPosition(i);
            centerVideo.setCenterVideoMsg(centerVideoMsg);
//            JToolUtils.printObject(centerVideo);
            MultipleItem.CenterVideo.CenterVideoList centerVideoList= new MultipleItem.CenterVideo.CenterVideoList();
            centerVideoList.setImgUrl(Const.HOME_TEST_IMG1);
            centerVideoList.setProductName(productName+i);
            centerVideoList.setProductPrice(productPrice);
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_LIST);
            centerVideo.setCenterVideoList(centerVideoList);
//            JToolUtils.printObject(centerVideo);
            MultipleItem.CenterVideo.PrevAndNext prevAndNext=new MultipleItem.CenterVideo.PrevAndNext();
            prevAndNext.setImgUrls(Const.HOME_TEST_IMG1);
            prevAndNext.setProductName(productName+i);
            prevAndNext.setProductPrice(productPrice);
            centerVideo.setItemType(Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT);
            centerVideo.setPrevAndNext(prevAndNext);
            JToolUtils.printObject(centerVideo);
//            centerVideos.add(centerVideo);
        }
//        JToolUtils.printObject(centerVideos);


        MultipleItem multipleItemTopBanner= new MultipleItem(Const.HOME_CENTER_VIDEO,"");
        multipleItemTopBanner.setCenterVideo(centerVideos);
        list.add(multipleItemTopBanner);
        return list;
    }


}

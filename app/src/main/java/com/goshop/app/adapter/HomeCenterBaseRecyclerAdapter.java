package com.goshop.app.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.goshop.app.Const;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by img on 2018/1/5.
 */

public class HomeCenterBaseRecyclerAdapter extends BaseMultiItemQuickAdapter<MultipleItem.CenterVideo,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public HomeCenterBaseRecyclerAdapter(@Nullable List data) {
        super(data);
        addItemType(Const.HOME_CENTER_VIDEO_CHILD_VIDEO, R.layout.item_home_center_banner_adapter_t3_inside_video_t1);
        addItemType(Const.HOME_CENTER_VIDEO_CHILD_LIST, R.layout.item_home_center_banner_adapter_t3_inside_video_bottom_list_t2);
        addItemType(Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT, R.layout.item_home_center_banner_adapter_t3_inside_prev_next_t3);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem.CenterVideo centerVideo) {
        switch (centerVideo.getItemType()){
            case Const.HOME_CENTER_VIDEO_CHILD_VIDEO:
                Logger.e("HOME_CENTER_VIDEO_CHILD_VIDEO");
                break;
            case Const.HOME_CENTER_VIDEO_CHILD_LIST:
                Logger.e("HOME_CENTER_VIDEO_CHILD_LIST");
                break;
            case Const.HOME_CENTER_VIDEO_CHILD_PREV_NEXT:
                Logger.e("HOME_CENTER_VIDEO_CHILD_PREV_NEXT");
                break;
        }

//        final String title = data.get(helper.getAdapterPosition());
//        helper.setText(R.id.tv_title,title);
//        helper.setOnClickListener(R.id.tv_title, new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(v.getContext(),"item"+ title+" 被点击了",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}

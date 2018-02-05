package com.goshop.app.adapter;

import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.utils.AnimUtils;
import com.jakewharton.rxbinding2.view.RxView;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by img on 2018/1/5.
 */
public class HomeCenterBaseRecyclerAdapter extends RecyclerView.Adapter {

    List<HomeResponse.CenterVideo> centerVideos = new ArrayList<>();

    public HomeCenterBaseRecyclerAdapter(
        List<HomeResponse.CenterVideo> centerVideos) {
        this.centerVideos = centerVideos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View centerVideo = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_home_center_video_adapter_t3_inside, parent, false);
        viewHolder = new HomeCenterVideoList(centerVideo);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeCenterVideoList homeCenterVideoList = (HomeCenterVideoList) holder;
        HomeCenterChildViewListAdapter homeCenterChildViewListAdapter = new
            HomeCenterChildViewListAdapter(
            centerVideos.get(position).getCenterVideoList());
        homeCenterChildViewListAdapter.setExpand(false);
        RxView.clicks(homeCenterVideoList.rlDownArrows).subscribe(v -> {
            boolean isExpand = homeCenterChildViewListAdapter.isExpand();
            AnimUtils.rotateArrow(homeCenterVideoList.ivArrow,!isExpand);
            homeCenterChildViewListAdapter.setExpand(!isExpand);
            homeCenterChildViewListAdapter.notifyDataSetChanged();
        });

        homeCenterVideoList.viewVideo
            .setText(centerVideos.get(position).getCenterVideoMsg().getVideoMsg());
        homeCenterVideoList.recyclerView.setLayoutManager(
            new LinearLayoutManager(homeCenterVideoList.recyclerView.getContext()));
        homeCenterVideoList.recyclerView.setAdapter(homeCenterChildViewListAdapter);
    }

    @Override
    public int getItemCount() {
        return centerVideos.size();
    }

    static class HomeCenterVideoList extends RecyclerView.ViewHolder {

        @BindView(R.id.view_video)
        TextView viewVideo;

        @BindView(R.id.rv_home_center_video_list)
        RecyclerView recyclerView;

        @BindView(R.id.rl_home_center_bottom_video_down_arrows)
        RelativeLayout rlDownArrows;

        @BindView(R.id.iv_arrow)
        ImageView ivArrow;

        public HomeCenterVideoList(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

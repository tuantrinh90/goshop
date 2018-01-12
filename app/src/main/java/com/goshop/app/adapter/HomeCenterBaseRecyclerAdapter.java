package com.goshop.app.adapter;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by img on 2018/1/5.
 */
public class HomeCenterBaseRecyclerAdapter extends RecyclerView.Adapter {

    List<MultipleItem.CenterVideo> centerVideos = new ArrayList<>();

    public HomeCenterBaseRecyclerAdapter(
        List<MultipleItem.CenterVideo> centerVideos) {
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
        homeCenterVideoList.rlDownArrows.setOnClickListener(
            v -> Toast.makeText(GoShopApplication.getAppContext(), "down arrows", Toast.LENGTH_SHORT).show());
        homeCenterVideoList.viewVideo
            .setText(centerVideos.get(position).getCenterVideoMsg().getVideoMsg());
        homeCenterVideoList.recyclerView.setLayoutManager(
            new LinearLayoutManager(homeCenterVideoList.recyclerView.getContext()));
        homeCenterVideoList.recyclerView.setAdapter(
            new HomeCenterChildViewListAdapter(centerVideos.get(position).getCenterVideoList()));
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

        public HomeCenterVideoList(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

package com.goshop.app.adapter;

import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by img on 2018/1/10.
 */
public class HomeCenterChildViewListAdapter extends RecyclerView.Adapter {

    List<HomeResponse.CenterVideo.CenterVideoList> centerVideoLists = new ArrayList<>();
    private boolean isExpand;
    private final static int NOT_EXPAND_VISIBLE_COUNT=1;
    public HomeCenterChildViewListAdapter(
        List<HomeResponse.CenterVideo.CenterVideoList> centerVideoLists) {
        this.centerVideoLists = centerVideoLists;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View centerVideoLists = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_home_center_video_adapter_t3_inside_list_insider, parent, false);
        return new CenterVideoListHolder(centerVideoLists);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CenterVideoListHolder listHolder = (CenterVideoListHolder) holder;
        listHolder.ivVideoListIcon.setBackgroundResource(R.mipmap.ic_launcher);
        listHolder.tvVideoListName.setText(centerVideoLists.get(position).getProductName());
        listHolder.tvVideoListOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        listHolder.tvVideoListPrice.setText(centerVideoLists.get(position).getProductPrice());
        //TODO joyson will delete after require
        listHolder.tvBuyNow.setOnClickListener(
            v -> Toast.makeText(v.getContext(), "buy now", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return isExpand?centerVideoLists.size():NOT_EXPAND_VISIBLE_COUNT;
    }

    public static class CenterVideoListHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_center_video_list_icon)
        ImageView ivVideoListIcon;

        @BindView(R.id.tv_video_list_name)
        TextView tvVideoListName;

        @BindView(R.id.tv_video_last_old_price)
        TextView tvVideoListOldPrice;

        @BindView(R.id.tv_video_list_price)
        TextView tvVideoListPrice;

        @BindView(R.id.tv_video_item_buy_now)
        TextView tvBuyNow;

        public CenterVideoListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public boolean isExpand() {
        return isExpand;
    }
}

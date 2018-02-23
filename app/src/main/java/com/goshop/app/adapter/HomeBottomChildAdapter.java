package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.data.model.response.HomeResponse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeBottomChildAdapter extends RecyclerView.Adapter {

    List<HomeResponse.BottomSlide.BottomSlideChild> bottomSlideChildren = new ArrayList<>();

    public HomeBottomChildAdapter(
        List<HomeResponse.BottomSlide.BottomSlideChild> bottomSlideChildren) {
        this.bottomSlideChildren = bottomSlideChildren;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_home_bottom_sideslip_image_and_text_t4, parent, false);

        return new BottomSlideItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BottomSlideItemHolder bottomSlideItemHolder = (BottomSlideItemHolder) holder;
        HomeResponse.BottomSlide.BottomSlideChild bottomSlideChild = bottomSlideChildren
            .get(position);
        Glide.with(bottomSlideItemHolder.ivBottomIcon.getContext())
            .load(bottomSlideChild.getImageUrl()).into(bottomSlideItemHolder.ivBottomIcon);
        bottomSlideItemHolder.tvProductName.setText(bottomSlideChild.getProductName());
        bottomSlideItemHolder.tvProductPrice.setText(bottomSlideChild.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return bottomSlideChildren.size();
    }

    static class BottomSlideItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_home_bottom_item)
        ImageView ivBottomIcon;

        @BindView(R.id.tv_home_bottom_item_name)
        TextView tvProductName;

        @BindView(R.id.tv_home_bottom_item_price)
        TextView tvProductPrice;

        public BottomSlideItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

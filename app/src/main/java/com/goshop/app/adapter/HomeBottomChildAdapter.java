package com.goshop.app.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.data.model.MultipleItem;
import com.goshop.app.utils.JToolUtils;

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

/**
 * Created by img on 2018/1/5.
 */

public class HomeBottomChildAdapter extends RecyclerView.Adapter {
    List<MultipleItem.BottomSlide.BottomSlideChild> bottomSlideChildren=new ArrayList<>();

    public HomeBottomChildAdapter(
        List<MultipleItem.BottomSlide.BottomSlideChild> bottomSlideChildren) {
        this.bottomSlideChildren = bottomSlideChildren;
        JToolUtils.printObject(bottomSlideChildren);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_home_bottom_sideslip_image_and_text_t4, parent, false);
                viewHolder = new BottomSlideItemHolder(itemView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BottomSlideItemHolder bottomSlideItemHolder = (BottomSlideItemHolder) holder;
        MultipleItem.BottomSlide.BottomSlideChild bottomSlideChild = bottomSlideChildren
            .get(position);
        Glide.with(bottomSlideItemHolder.ivBottomIcon.getContext()).load(bottomSlideChild.getImageUrl()).into(bottomSlideItemHolder.ivBottomIcon);
        bottomSlideItemHolder.tvProductName.setText(bottomSlideChild.getProductName());
        bottomSlideItemHolder.tvProductPrice.setText(bottomSlideChild.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return bottomSlideChildren.size();
    }

    static class BottomSlideItemHolder extends RecyclerView.ViewHolder{
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

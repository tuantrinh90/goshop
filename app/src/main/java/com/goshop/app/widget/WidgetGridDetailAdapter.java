package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.PdpFrequentlyDataVM;
import com.goshop.app.presentation.model.WidgetGridDetailVM;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/1/12.
 */
public class WidgetGridDetailAdapter extends RecyclerView.Adapter {

    private List<WidgetGridDetailVM> detailVMS;

    public WidgetGridDetailAdapter(List<WidgetGridDetailVM> detailVMS) {
        this.detailVMS = detailVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_grid_detail, parent, false);
        return new GridDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GridDetailViewHolder) holder).bindingData(detailVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return detailVMS.size();
    }

    class GridDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_grid_pic)
        ImageView ivGridPic;

        @BindView(R.id.tv_grid_percent)
        CustomBoldTextView tvGridPercent;

        @BindView(R.id.tv_grid_title)
        CustomTextView tvGridTitle;

        @BindView(R.id.tv_grid_old)
        CustomTextView tvGridOld;

        @BindView(R.id.tv_grid_now_price)
        CustomBoldTextView tvGridNowPrice;

        public GridDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(WidgetGridDetailVM detailVM) {
            Glide.with(itemView.getContext()).load(detailVM.getImageUrl()).asBitmap()
                .error(detailVM.getIconDefault())
                .into(ivGridPic);
            tvGridPercent.setText(detailVM.getPercent());
            tvGridTitle.setText(detailVM.getTitle());
            tvGridOld.setText(detailVM.getOld());
            tvGridNowPrice.setText(detailVM.getNow());
            tvGridOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}

package com.goshop.app.widget;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductItemVM;
import com.goshop.app.widget.WidgetListener.OnProductItemClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetProductItemlAdapter extends RecyclerView.Adapter {

    private final String RM = "RM ";

    private List<ProductItemVM> detailVMS;

    private OnProductItemClickListener onProductItemClickListener;

    public WidgetProductItemlAdapter(OnProductItemClickListener onProductItemClickListener,
        List<ProductItemVM> detailVMS) {
        this.onProductItemClickListener = onProductItemClickListener;
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

        @BindView(R.id.tv_grid_now_price)
        CustomBoldTextView tvGridNowPrice;

        @BindView(R.id.tv_grid_old)
        CustomTextView tvGridOld;

        @BindView(R.id.tv_grid_percent)
        CustomBoldTextView tvGridPercent;

        @BindView(R.id.tv_grid_title)
        CustomTextView tvGridTitle;

        public GridDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ProductItemVM detailVM) {
            Glide.with(itemView.getContext()).load(detailVM.getImage()).asBitmap()
                .error(detailVM.getImageDefault())
                .into(ivGridPic);
            tvGridPercent.setText(detailVM.getPrice().getRm().getDiscountTitle());
            tvGridTitle.setText(detailVM.getTitle());
            String oldPrice = RM + detailVM.getPrice().getRm().getOriginal();
            String nowPrice = RM + detailVM.getPrice().getRm().getDiscounted();
            tvGridOld.setText(oldPrice);
            tvGridNowPrice.setText(nowPrice);
            tvGridOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            itemView
                .setOnClickListener(v -> onProductItemClickListener.onProductItemClick(detailVM));
        }
    }
}

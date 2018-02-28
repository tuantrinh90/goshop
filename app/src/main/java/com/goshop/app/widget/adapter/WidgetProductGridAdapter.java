package com.goshop.app.widget.adapter;

import com.bumptech.glide.Glide;
import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetProductGridAdapter extends RecyclerView.Adapter {

    private OnProductItemClickListener onProductItemClickListener;

    private List<ProductsVM> productsVMS;

    public WidgetProductGridAdapter(OnProductItemClickListener onProductItemClickListener,
        List<ProductsVM> detailVMS) {
        this.onProductItemClickListener = onProductItemClickListener;
        this.productsVMS = detailVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_grid_detail, parent, false);
        return new GridDetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((GridDetailViewHolder) holder).bindingData(productsVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return productsVMS.size();
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

        void bindingData(ProductsVM productsVM) {
            Glide.with(itemView.getContext()).load(productsVM.getImage()).asBitmap()
                .error(R.drawable.ic_bought)
                .into(ivGridPic);
            tvGridPercent.setText(productsVM.getPriceVM().getRm().getDiscountTitle());
            tvGridTitle.setText(productsVM.getTitle());
            String oldPrice = productsVM.getPriceVM().getRm().getOriginal();
            String nowPrice = productsVM.getPriceVM().getRm().getDiscounted();
            tvGridOld.setText(oldPrice);
            tvGridNowPrice.setText(nowPrice);
            tvGridOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            itemView
                .setOnClickListener(v -> onProductItemClickListener.onProductItemClick(productsVM));
        }
    }
}

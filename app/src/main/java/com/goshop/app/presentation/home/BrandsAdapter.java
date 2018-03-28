package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.BrandsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandsAdapter extends RecyclerView.Adapter {

    private List<BrandsVM> brandsVMS;

    private OnBrandsItemClickListener onBrandsItemClickListener;

    public BrandsAdapter(List<BrandsVM> brandsVMS,
        OnBrandsItemClickListener onBrandsItemClickListener) {
        this.brandsVMS = brandsVMS;
        this.onBrandsItemClickListener = onBrandsItemClickListener;
    }

    public void setUpdateDatas(List<BrandsVM> brandsVMS) {
        this.brandsVMS.clear();
        this.brandsVMS = brandsVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View brandView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_brands, parent, false);
        return new BrandsPageViewHolder(brandView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((BrandsPageViewHolder) holder).bindingData(brandsVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return brandsVMS.size();
    }

    public interface OnBrandsItemClickListener {

        void onBrandsItemClick();
    }

    class BrandsPageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_brands_detail)
        ImageView ivBrandsDetail;

        @BindView(R.id.iv_brands_logo)
        ImageView ivBrandsLogo;

        @BindView(R.id.iv_brands_thumb_first)
        ImageView ivBrandsThumbFirst;

        @BindView(R.id.iv_brands_thumb_four)
        ImageView ivBrandsThumbFour;

        @BindView(R.id.iv_brands_thumb_second)
        ImageView ivBrandsThumbSecond;

        @BindView(R.id.iv_brands_thumb_third)
        ImageView ivBrandsThumbThird;

        @BindView(R.id.tv_brands_name)
        RobotoMediumTextView tvBrandsName;

        @BindView(R.id.view_brand_divider)
        View viewBrandDivider;

        public BrandsPageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(BrandsVM brandsVM, int position) {
            viewBrandDivider.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            itemView.setOnClickListener(v -> onBrandsItemClickListener.onBrandsItemClick());
        }
    }
}

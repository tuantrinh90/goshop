package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.presentation.model.BrandsDetailFilterListVM;
import com.goshop.app.presentation.model.BrandsDetailModel;
import com.goshop.app.presentation.model.BrandsDetailTopVM;
import com.goshop.app.widget.listener.OnFilterMenuClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.viewholder.FilterListViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BrandsDetailAdapter extends RecyclerView.Adapter {

    private List<BrandsDetailModel> brandsDetailModels;

    private OnFilterMenuClickListener filterMenuClickListener;

    private OnProductItemClickListener onProductItemClickListener;

    public BrandsDetailAdapter(
        List<BrandsDetailModel> brandsDetailModels) {
        this.brandsDetailModels = brandsDetailModels;
    }

    public void setUpdateDatas(List<BrandsDetailModel> brandsDetailModels) {
        this.brandsDetailModels.clear();
        this.brandsDetailModels = brandsDetailModels;
        notifyDataSetChanged();
    }

    public void setOnProductItemClickListener(
        OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    public void setOnFilterMenuClickListener(OnFilterMenuClickListener filterMenuClickListener) {
        this.filterMenuClickListener = filterMenuClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case BrandsDetailModel.VIEW_TYPE_DETAIL_TOP:
                View topView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_brands_detail_top, parent, false);
                viewHolder = new DetailTopViewHolder(topView);
                break;
            case BrandsDetailModel.VIEW_TYPE_DETAIL_FILGER_LIST:
                View filterView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_filter_list, parent, false);
                viewHolder = new FilterListViewHolder(filterView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BrandsDetailModel brandsDetailModel = brandsDetailModels.get(position);
        if (holder instanceof DetailTopViewHolder) {
            ((DetailTopViewHolder) holder).bindingData((BrandsDetailTopVM) brandsDetailModel);
        } else if (holder instanceof FilterListViewHolder) {
            ((FilterListViewHolder) holder).bindingData(
                ((BrandsDetailFilterListVM) brandsDetailModel).getFilterListVM(),
                onProductItemClickListener, filterMenuClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return brandsDetailModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return brandsDetailModels.size();
    }

    class DetailTopViewHolder extends RecyclerView.ViewHolder {

        public DetailTopViewHolder(View itemView) {
            super(itemView);
        }

        void bindingData(BrandsDetailTopVM detailTopVM) {

        }
    }
}

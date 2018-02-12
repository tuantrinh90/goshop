package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetOnAirVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.widget.WidgetListener.OnBannerItemClickListener;
import com.goshop.app.widget.WidgetListener.OnProductItemClickListener;
import com.goshop.app.widget.WidgetListener.OnSinglePicturClickListener;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by helen on 2018/2/10.
 */

public class WidgetViewAdapter extends RecyclerView.Adapter {

    private OnBannerItemClickListener onBannerItemClickListener;

    private OnProductItemClickListener onProductItemClickListener;

    private OnSinglePicturClickListener onSinglePicturClickListener;

    private List<WidgetViewModel> widgetViewModels;

    public WidgetViewAdapter(
        List<WidgetViewModel> widgetViewModels) {
        this.widgetViewModels = widgetViewModels;
    }

    public void setOnProductItemClickListener(
        OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    public void setOnBannerItemClickListener(OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    public void setOnSinglePicturClickListener(
        OnSinglePicturClickListener onSinglePicturClickListener) {
        this.onSinglePicturClickListener = onSinglePicturClickListener;
    }

    public void setUpdateDatas(List<WidgetViewModel> widgetViewModels) {
        this.widgetViewModels.clear();
        this.widgetViewModels = widgetViewModels;
        //TODO(helen) this will delete after finish debug
        Log.d("WidgetViewAdapter", "size:" + widgetViewModels.size());
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case WidgetViewModel.VIEW_TYPE_BANNER:
                View bannerView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_banner, viewGroup, false);
                viewHolder = new WidgetBannerViewHolder(bannerView);
                break;
            case WidgetViewModel.VIEW_TYPE_ON_AIR:
                View onAirView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_on_air, viewGroup, false);
                viewHolder = new WidgetOnAirViewHolder(onAirView);
                break;
            case WidgetViewModel.VIEW_TYPE_SINGLE_PICTURE:
                View singleView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_single_picture, viewGroup, false);
                viewHolder = new WidgetSinglePictureViewHolder(singleView);
                break;
            case WidgetViewModel.VIEW_TYPE_PRODUCT_SCROLLER:
                View horizontalView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_horizontal, viewGroup, false);
                viewHolder = new WidgetProductScrollerViewHolder(horizontalView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        WidgetViewModel widgetViewModel = widgetViewModels.get(position);
        if (viewHolder instanceof WidgetBannerViewHolder) {
            ((WidgetBannerViewHolder) viewHolder)
                .bindingData((WidgetCarouselVM) widgetViewModel, onBannerItemClickListener);
        } else if (viewHolder instanceof WidgetOnAirViewHolder) {
            ((WidgetOnAirViewHolder) viewHolder).bindingData((WidgetOnAirVM) widgetViewModel);
        } else if (viewHolder instanceof WidgetSinglePictureViewHolder) {
            ((WidgetSinglePictureViewHolder) viewHolder).bindingData(
                (WidgetSinglePictureVM) widgetViewModel, onSinglePicturClickListener);
        } else if (viewHolder instanceof WidgetProductScrollerViewHolder) {
            ((WidgetProductScrollerViewHolder) viewHolder).bindingData(
                (WidgetProductScrollerVM) widgetViewModel, onProductItemClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return widgetViewModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return widgetViewModels.size();
    }
}

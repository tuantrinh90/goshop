package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.presentation.model.WidgetBannerVM;
import com.goshop.app.presentation.model.WidgetViewModel;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by helen on 2018/2/10.
 */

public class WidgetViewAdapter extends RecyclerView.Adapter{

    List<WidgetViewModel> widgetViewModels;

    public WidgetViewAdapter(
        List<WidgetViewModel> widgetViewModels) {
        this.widgetViewModels = widgetViewModels;
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
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        WidgetViewModel widgetViewModel = widgetViewModels.get(i);
        if(viewHolder instanceof WidgetBannerViewHolder) {
            ((WidgetBannerViewHolder) viewHolder).bindingData((WidgetBannerVM) widgetViewModel);
        }
    }

    @Override
    public int getItemCount() {
        return widgetViewModels.size();
    }

    @Override
    public int getItemViewType(int position) {
        return widgetViewModels.get(position).getViewType();
    }
}

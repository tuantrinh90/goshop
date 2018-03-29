package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.presentation.model.widget.AdditionalInformationVM;
import com.goshop.app.presentation.model.widget.WidgetCarouselVM;
import com.goshop.app.presentation.model.widget.WidgetPDPQaVM;
import com.goshop.app.presentation.model.widget.WidgetPDPReviewsVM;
import com.goshop.app.presentation.model.widget.WidgetPDPTopDetailsVM;
import com.goshop.app.presentation.model.widget.WidgetProductScrollerVM;
import com.goshop.app.presentation.model.widget.WidgetSinglePictureVM;
import com.goshop.app.presentation.model.widget.WidgetTitleExpandVM;
import com.goshop.app.presentation.model.widget.WidgetVideoPlayerVM;
import com.goshop.app.presentation.model.widget.WidgetViewModel;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnChannelItemClickListener;
import com.goshop.app.widget.listener.OnProductBuyClickListener;
import com.goshop.app.widget.listener.OnProductItemClickListener;
import com.goshop.app.widget.listener.OnReviewsViewMoreClickListener;
import com.goshop.app.widget.listener.OnSinglePicturClickListener;
import com.goshop.app.widget.viewholder.PDPQaViewHolder;
import com.goshop.app.widget.viewholder.PDPReviewsViewHolder;
import com.goshop.app.widget.viewholder.WidgetBannerViewHolder;
import com.goshop.app.widget.viewholder.WidgetVideoPlayerViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class WidgetViewAdapter extends RecyclerView.Adapter implements WidgetTitleViewHolder
    .ExpandTitleClickListener {

    private List<WidgetViewModel> allWidgetViewModels;

    private OnProductBuyClickListener buyClickListener;

    private List<WidgetViewModel> displayModels;

    private OnBannerItemClickListener onBannerItemClickListener;

    private OnChannelItemClickListener onChannelItemClickListener;

    private OnProductItemClickListener onProductItemClickListener;

    private OnReviewsViewMoreClickListener onReviewsViewMoreClickListener;

    private OnSinglePicturClickListener onSinglePicturClickListener;

    public WidgetViewAdapter(
        List<WidgetViewModel> widgetViewModels) {
        allWidgetViewModels = new ArrayList<>();
        this.displayModels = widgetViewModels;
    }

    public void setOnProductItemClickListener(
        OnProductItemClickListener onProductItemClickListener) {
        this.onProductItemClickListener = onProductItemClickListener;
    }

    public void setOnBannerItemClickListener(OnBannerItemClickListener onBannerItemClickListener) {
        this.onBannerItemClickListener = onBannerItemClickListener;
    }

    public void setOnProductBuyClickListener(OnProductBuyClickListener buyClickListener) {
        this.buyClickListener = buyClickListener;
    }

    public void setOnSinglePicturClickListener(
        OnSinglePicturClickListener onSinglePicturClickListener) {
        this.onSinglePicturClickListener = onSinglePicturClickListener;
    }

    public void setOnReviewsViewMoreClickListener(
        OnReviewsViewMoreClickListener onReviewsViewMoreClickListener) {
        this.onReviewsViewMoreClickListener = onReviewsViewMoreClickListener;
    }

    public void setUpdateDatas(List<WidgetViewModel> widgetViewModels) {
        this.displayModels.clear();
        this.allWidgetViewModels.clear();
        this.allWidgetViewModels = widgetViewModels;
        expandAll(allWidgetViewModels);
        notifyDataSetChanged();
    }

    private void expandAll(List<WidgetViewModel> widgetViewModels) {
        for (WidgetViewModel model : widgetViewModels) {
            if (model instanceof WidgetTitleExpandVM) {
                ((WidgetTitleExpandVM) model)
                    .setExpand(((WidgetTitleExpandVM) model).isClickable());
            }
        }
        displayModels.addAll(widgetViewModels);
    }

    @Override
    public void expand(int position) {
        int expandPosition = allWidgetViewModels.indexOf(displayModels.get(position));
        int insert = position;
        int count = 0;
        for (int i = expandPosition + 1; i < allWidgetViewModels.size() && (allWidgetViewModels
            .get(i)
            .getViewType() != WidgetViewModel.VIEW_TYPE_EXPAND_TITLE); i++) {
            count++;
            insert++;
            displayModels.add(insert, allWidgetViewModels.get(i));
        }
        //Todo this part need to decide
        notifyDataSetChanged();
//        notifyItemRangeInserted(position + 1, count);
    }

    @Override
    public void closed(int position) {
        int closePosition = allWidgetViewModels.indexOf(displayModels.get(position));
        int count = 0;
        for (int i = closePosition + 1; i < allWidgetViewModels.size() && (allWidgetViewModels
            .get(i)
            .getViewType() != WidgetViewModel.VIEW_TYPE_EXPAND_TITLE); i++) {
            count++;
            displayModels.remove(position + 1);
        }
        //Todo this part need to decide
        notifyDataSetChanged();
//        notifyItemRangeRemoved(position + 1, count);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case WidgetViewModel.VIEW_TYPE_BANNER:
                View bannerView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_trending_top_banner, viewGroup, false);
                viewHolder = new WidgetBannerViewHolder(bannerView);
                break;
            case WidgetViewModel.VIEW_TYPE_VIDEOPLAYER:
                View onAirView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_trending_videoplayer, viewGroup, false);
                viewHolder = new WidgetVideoPlayerViewHolder(onAirView);
                break;
            case WidgetViewModel.VIEW_TYPE_SINGLE_PICTURE:
                View singleView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_trending_single_banner, viewGroup, false);
                viewHolder = new WidgetSinglePictureViewHolder(singleView);
                break;
            case WidgetViewModel.VIEW_TYPE_PRODUCT_SCROLLER:
                View horizontalView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_horizontal, viewGroup, false);
                viewHolder = new WidgetProductScrollerViewHolder(horizontalView);
                break;
            case WidgetViewModel.VIEW_TYPE_EXPAND_TITLE:
                View expandTitleView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_expand_title, viewGroup, false);
                viewHolder = new WidgetTitleViewHolder(expandTitleView, this);
                break;
            case WidgetViewModel.VIEW_TYPE_PDP_TOP_DETAILS:
                View pdpTopDetailView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_pdp_top_details, viewGroup, false);
                viewHolder = new WidgetPDPTopDetailViewHolder(pdpTopDetailView);
                break;
            case WidgetViewModel.VIEW_TYPE_ADDITIONAL_INFORMATION:
                View additionalInfoView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_additional_information, viewGroup, false);
                viewHolder = new AdditionalInformationViewHolder(additionalInfoView);
                break;
            case WidgetViewModel.VIEW_TYPE_SINGLE_TEXT:
                View summaryView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_pdp_product_summary, viewGroup, false);
                viewHolder = new WidgetSingleTextViewHolder(summaryView);
                break;
            case WidgetViewModel.VIEW_TYPE_DELIVERY_INFO:
                View deliveryView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_delivery_info, viewGroup, false);
                viewHolder = new DeliveryViewHolder(deliveryView);
                break;
            case WidgetViewModel.VIEW_TYPE_PDP_QA:
                View qaView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_qa, viewGroup, false);
                viewHolder = new PDPQaViewHolder(qaView);
                break;
            case WidgetViewModel.VIEW_TYPE_PDP_REVIEWS:
                View reviewsView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_widget_reviews, viewGroup, false);
                viewHolder = new PDPReviewsViewHolder(reviewsView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        WidgetViewModel widgetViewModel = displayModels.get(position);
        if (viewHolder instanceof WidgetBannerViewHolder) {
            ((WidgetBannerViewHolder) viewHolder)
                .bindingData((WidgetCarouselVM) widgetViewModel, onBannerItemClickListener);
        } else if (viewHolder instanceof WidgetVideoPlayerViewHolder) {
            ((WidgetVideoPlayerViewHolder) viewHolder)
                .bindingData((WidgetVideoPlayerVM) widgetViewModel, onProductItemClickListener,
                    buyClickListener);
        } else if (viewHolder instanceof WidgetSinglePictureViewHolder) {
            ((WidgetSinglePictureViewHolder) viewHolder).bindingData(
                (WidgetSinglePictureVM) widgetViewModel, onSinglePicturClickListener);
        } else if (viewHolder instanceof WidgetProductScrollerViewHolder) {
            ((WidgetProductScrollerViewHolder) viewHolder).bindingData(
                (WidgetProductScrollerVM) widgetViewModel, onProductItemClickListener);
        } else if (viewHolder instanceof WidgetTitleViewHolder) {
            ((WidgetTitleViewHolder) viewHolder)
                .bindingData((WidgetTitleExpandVM) widgetViewModel, position);
        } else if (viewHolder instanceof WidgetPDPTopDetailViewHolder) {
            ((WidgetPDPTopDetailViewHolder) viewHolder).bindingData(
                (WidgetPDPTopDetailsVM) widgetViewModel);
        } else if (viewHolder instanceof AdditionalInformationViewHolder) {
            ((AdditionalInformationViewHolder) viewHolder).bindingData(
                (AdditionalInformationVM) widgetViewModel);
        } else if (viewHolder instanceof PDPQaViewHolder) {
            ((PDPQaViewHolder) viewHolder).bindingData((WidgetPDPQaVM) widgetViewModel);
        } else if (viewHolder instanceof PDPReviewsViewHolder) {
            ((PDPReviewsViewHolder) viewHolder)
                .bindingData((WidgetPDPReviewsVM) widgetViewModel, onReviewsViewMoreClickListener);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return displayModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return displayModels.size();
    }


}

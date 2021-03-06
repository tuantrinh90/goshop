package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.FlowLayout;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularCheckBox;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.model.FilterFlowVM;
import com.goshop.app.presentation.model.FilterMenuExpandVM;
import com.goshop.app.presentation.model.FilterMenuFlowButtonVM;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.FilterMenuPriceVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilterDrawerAdapter extends RecyclerView.Adapter {

    private List<FilterMenuModel> displayModels;

    private List<FilterMenuModel> menuModels;

    public FilterDrawerAdapter(
        List<FilterMenuModel> menuModels) {
        this.displayModels = menuModels;
        this.menuModels = new ArrayList<>();
    }

    public void updateDatas(List<FilterMenuModel> menuModels) {
        this.menuModels.clear();
        this.menuModels = menuModels;
        expandAll();
        notifyDataSetChanged();
    }

    private void expandAll() {
        this.displayModels.clear();
        for (FilterMenuModel filterMenuModel : menuModels) {
            if (filterMenuModel instanceof FilterMenuExpandVM) {
                ((FilterMenuExpandVM) filterMenuModel).setExpand(true);
            }
        }
        displayModels.addAll(menuModels);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case FilterMenuModel.FILTER_EXPAND:
                View expandView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_expand_title, parent, false);
                viewHolder = new ExpandViewHolder(expandView);
                break;
            case FilterMenuModel.FILTER_FLOWBUTTONS:
                View categoryView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_category, parent, false);
                viewHolder = new FlowButtonViewHolder(categoryView);
                break;
            case FilterMenuModel.FILTER_PRICE:
                View priceView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_filter_menu_price, parent, false);
                viewHolder = new PriceViewHolder(priceView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FilterMenuModel filterMenuModel = displayModels.get(position);
        if (holder instanceof ExpandViewHolder) {
            ((ExpandViewHolder) holder).bindingData((FilterMenuExpandVM) filterMenuModel, position);
        } else if (holder instanceof FlowButtonViewHolder) {
            ((FlowButtonViewHolder) holder).bindingData((FilterMenuFlowButtonVM) filterMenuModel);
        } else if (holder instanceof PriceViewHolder) {
            ((PriceViewHolder) holder).bindingData((FilterMenuPriceVM) filterMenuModel);
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

    private void expand(int position) {

        int expandPosition = menuModels.indexOf(displayModels.get(position));
        int insert = position;
        int count = 0;
        for (int i = expandPosition + 1; i < menuModels.size() && (menuModels.get(i)
            .getViewType() != FilterMenuExpandVM.FILTER_EXPAND); i++) {
            count++;
            insert++;
            displayModels.add(insert, menuModels.get(i));
        }
        notifyDataSetChanged();
    }

    private void closeUp(int position) {
        int closePosition = menuModels.indexOf(displayModels.get(position));
        int count = 0;
        for (int i = closePosition + 1; i < menuModels.size() && (menuModels.get(i)
            .getViewType() != FilterMenuExpandVM.FILTER_EXPAND); i++) {
            count++;
            displayModels.remove(position + 1);
        }
        notifyDataSetChanged();
    }

    class ExpandViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_search_filter_expand)
        ImageView ivItemSearchFilterExpand;

        @BindView(R.id.rl_filter_expand_title)
        RelativeLayout rlFilterExpandTitle;

        @BindView(R.id.tv_item_search_filter_expand)
        RobotoLightTextView tvItemSearchFilterExpand;

        public ExpandViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(FilterMenuExpandVM expandVM, int position) {
            tvItemSearchFilterExpand.setText(expandVM.getTitle());
            if (expandVM.isHasIcon()) {
                ivItemSearchFilterExpand.setVisibility(View.VISIBLE);
                ivItemSearchFilterExpand.setSelected(expandVM.isExpand());
                rlFilterExpandTitle.setSelected(expandVM.isExpand());
                itemView.setOnClickListener(
                    v -> {
                        expandVM.setExpand(!expandVM.isExpand());
                        ivItemSearchFilterExpand.setSelected(expandVM.isExpand());
                        rlFilterExpandTitle.setSelected(expandVM.isExpand());
                        if (expandVM.isExpand()) {
                            expand(position);
                        } else {
                            closeUp(position);
                        }
                    });
            } else {
                ivItemSearchFilterExpand.setVisibility(View.GONE);
                rlFilterExpandTitle.setSelected(true);
            }

        }
    }

    class FlowButtonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.flow_search_filter)
        FlowLayout flowSearchFilter;

        public FlowButtonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(FilterMenuFlowButtonVM categoryVM) {
            List<FilterFlowVM> filterFlowVMS = categoryVM.getFilterFlowVMS();

            LayoutInflater mInflater = LayoutInflater.from(itemView.getContext());
            for (int i = 0; i < filterFlowVMS.size(); i++) {
                RobotoRegularCheckBox categoryCheckView = (RobotoRegularCheckBox) mInflater
                    .inflate(R.layout.item_checkbox,
                        flowSearchFilter, false);
                categoryCheckView.setText(filterFlowVMS.get(i).getName());
                categoryCheckView.setOnCheckedChangeListener(((buttonView, isChecked) -> {
                    if (isChecked) {
                        //todo wait for design
                    }
                }));
                flowSearchFilter.addView(categoryCheckView);
            }
        }
    }

    class BrandsViewHolder extends RecyclerView.ViewHolder {

        public BrandsViewHolder(View itemView) {
            super(itemView);
            //TODO  need decide
//            ButterKnife.bind(this, itemView);
        }
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.et_search_filter_max)
        RobotoRegularEditText etSearchFilterMax;

        @BindView(R.id.et_search_filter_min)
        RobotoRegularEditText etSearchFilterMin;

        public PriceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(FilterMenuPriceVM priceVM) {
        }
    }
}

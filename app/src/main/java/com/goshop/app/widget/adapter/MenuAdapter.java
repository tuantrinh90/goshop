package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.MenuHearderVM;
import com.goshop.app.presentation.model.MenuItemVM;
import com.goshop.app.presentation.model.MenuModel;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter {

    private List<MenuModel> menuModels;

    private OnSlideMenuItemClickListener onSlideMenuItemClickListener;

    public MenuAdapter(List<MenuModel> menuModels) {
        this.menuModels = menuModels;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case MenuModel.MENU_HEADER:
                View headerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_slide_menu_header, parent, false);
                viewHolder = new HeaderViewHolder(headerView);
                break;
            case MenuModel.MENU_ITEM:
                View iconView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_slide_menu_item, parent, false);
                viewHolder = new ItemViewHolder(iconView);
                break;
            case MenuModel.MENU_DIVIDER:
                View dividerView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_slide_menu_divider, parent, false);
                viewHolder = new DividerViewHolder(dividerView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).bindingData((MenuItemVM) menuModels.get(position), position);
        } else if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder)
                .bindingData((MenuHearderVM) menuModels.get(position), position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return menuModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }

    public void setOnSlideMenuItemClickListener(
        OnSlideMenuItemClickListener onSlideMenuItemClickListener) {
        this.onSlideMenuItemClickListener = onSlideMenuItemClickListener;
    }

    public void updateSelection(int position) {
        for (int i = 0; i < menuModels.size(); i++) {
            MenuModel model = menuModels.get(i);
            if (model instanceof MenuItemVM) {
                ((MenuItemVM) model).setSelect(position == i);
            }
        }
        notifyDataSetChanged();
    }

    public void updateLoginState(boolean loginState) {
        MenuModel model = menuModels.get(0);
        if (model instanceof MenuHearderVM) {
            Log.d("updateSelection", "boolen" + (loginState));
            ((MenuHearderVM) model).setLoginState(loginState);
        }
        notifyDataSetChanged();
    }

    public interface OnSlideMenuItemClickListener {

        void onHeaderUserClick(int position);

        void onHeaderLoginClick(int position);

        void onItemClick(int position);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rl_slide_user_info)
        RelativeLayout rlSlideUserInfo;

        @BindView(R.id.tv_slide_sign_up)
        RobotoMediumTextView tvSlideSignUp;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MenuHearderVM menuHearderVM, int position) {
            rlSlideUserInfo.setVisibility(menuHearderVM.isLoginState() ? View.VISIBLE : View.GONE);
            tvSlideSignUp.setVisibility(menuHearderVM.isLoginState() ? View.GONE : View.VISIBLE);
            rlSlideUserInfo
                .setOnClickListener(v -> onSlideMenuItemClickListener.onHeaderUserClick(position));
            tvSlideSignUp
                .setOnClickListener(v -> onSlideMenuItemClickListener.onHeaderLoginClick(position));
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_menu_item)
        ImageView ivMenuItem;

        @BindView(R.id.ll_menu_item)
        LinearLayout llMenuItem;

        @BindView(R.id.tv_menu_item)
        RobotoRegularTextView tvMenuItem;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(MenuItemVM itemVM, int position) {
            if (itemVM.getIcon() == 0) {
                ivMenuItem.setVisibility(View.GONE);
            } else {
                ivMenuItem.setVisibility(View.VISIBLE);
                ivMenuItem.setBackgroundResource(itemVM.getIcon());
                ivMenuItem.setSelected(itemVM.isSelect());
            }
            tvMenuItem.setText(itemVM.getTitle());
            tvMenuItem.setSelected(itemVM.isSelect());
            llMenuItem.setSelected(itemVM.isSelect());
            llMenuItem.setOnClickListener(v -> {
                //todo need decide
//                updateSelection(position);
                onSlideMenuItemClickListener.onItemClick(position);
            });
        }
    }

    class DividerViewHolder extends RecyclerView.ViewHolder {

        public DividerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

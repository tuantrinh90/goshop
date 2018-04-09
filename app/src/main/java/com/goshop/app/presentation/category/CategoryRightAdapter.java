package com.goshop.app.presentation.category;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.CategoryRightChildVM;
import com.goshop.app.presentation.model.CategoryRightMenuModel;
import com.goshop.app.presentation.model.CategoryRightParentVM;
import com.goshop.app.widget.listener.OnCategoryItemClickListener;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryRightAdapter extends RecyclerView.Adapter {

    private List<CategoryRightMenuModel> displayModels;

    private OnCategoryItemClickListener onChildItemClickListener;

    private List<CategoryRightMenuModel> rightMenuModels;

    public CategoryRightAdapter(
        List<CategoryRightMenuModel> rightMenuModels,
        OnCategoryItemClickListener onChildItemClickListener) {
        this.rightMenuModels = new ArrayList<>();
        this.displayModels = rightMenuModels;
        this.onChildItemClickListener = onChildItemClickListener;
    }

    public void setUpdateRightModels(List<CategoryRightMenuModel> rightMenuModels) {
        this.rightMenuModels.clear();
        this.rightMenuModels = rightMenuModels;
        if (this.rightMenuModels.size() > 0) {
            singleExpand(0);
        }
        notifyDataSetChanged();
    }

    private void singleExpand(int position) {
        boolean addChild = false;
        displayModels.clear();
        for (int i = 0; i < rightMenuModels.size(); i++) {
            CategoryRightMenuModel rightMenuModel = rightMenuModels.get(i);
            if (rightMenuModel instanceof CategoryRightParentVM) {
                displayModels.add(rightMenuModel);
                ((CategoryRightParentVM) rightMenuModel).setExpand(i == position);
                addChild = (i == position);
            } else {
                if (addChild) {
                    displayModels.add(rightMenuModel);
                }
            }
        }
        notifyDataSetChanged();
    }

    public int getModelPosition(int position) {
        return rightMenuModels.indexOf(displayModels.get(position));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case CategoryRightMenuModel.VIEW_TYPE_CHILD:
                View childView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_category_right_child, parent, false);
                viewHolder = new ChildViewHolder(childView);
                break;
            case CategoryRightMenuModel.VIEW_TYPE_PARENT:
                View parentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_category_right_parent, parent, false);
                viewHolder = new ParentViewHolder(parentView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CategoryRightMenuModel rightMenuModel = displayModels.get(position);
        if (holder instanceof ParentViewHolder) {
            ((ParentViewHolder) holder)
                .bindingData((CategoryRightParentVM) rightMenuModel, position);
        } else if (holder instanceof ChildViewHolder) {
            ((ChildViewHolder) holder).bindingData((CategoryRightChildVM) rightMenuModel);
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


    class ParentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_category_expand)
        ImageView ivItemCategoryExpand;

        @BindView(R.id.tv_category_right_parent)
        RobotoRegularTextView tvCategoryRightParent;

        public ParentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(CategoryRightParentVM parentVM, int position) {
            tvCategoryRightParent.setText(parentVM.getTitle());
            ivItemCategoryExpand.setSelected(parentVM.isExpand());
            itemView.setOnClickListener(v -> singleExpand(getModelPosition(position)));
        }
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_category_child)
        RobotoLightTextView tvItemCategoryChild;

        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(CategoryRightChildVM childVM) {
            tvItemCategoryChild.setText(childVM.getTitle());
            itemView.setOnClickListener(v -> onChildItemClickListener.onChildItemClick(childVM));
        }
    }
}

package com.goshop.app.presentation.category;

import com.goshop.app.R;
import com.goshop.app.common.view.expandablerecyclerview.holder.BaseViewHolder;
import com.goshop.app.presentation.model.CategoriesChildVM;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryChildViewHolder extends BaseViewHolder {

    private final ImageView ivArrow;

    private final TextView tvParent;

    private final TextView tvChild;

    public CategoryChildViewHolder(Context ctx, View itemView,
        int viewType) {
        super(ctx, itemView, viewType);
        ivArrow = itemView.findViewById(R.id.iv_item_category_expand);
        tvParent = itemView.findViewById(R.id.tv_category_right_parent);
        tvChild = itemView.findViewById(R.id.tv_item_category_child);
    }

    @Override
    public int getChildViewResId() {
        return R.id.ll_child;
    }

    @Override
    public int getGroupViewResId() {
        return R.id.rl_parent;
    }

    public void bindChildData(CategoriesChildVM categoriesChildVM, int position) {
        tvChild.setText(categoriesChildVM.getName());
    }

    public void bindGroupData(String groupData, int position) {
        tvParent.setText(groupData);
    }

}

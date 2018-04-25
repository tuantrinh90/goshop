package com.goshop.app.presentation.category;

import com.goshop.app.R;
import com.goshop.app.common.view.expandablerecyclerview.adapter.BaseRecyclerViewAdapter;
import com.goshop.app.common.view.expandablerecyclerview.bean.RecyclerViewData;
import com.goshop.app.presentation.model.CategoriesChildVM;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class CategoryChildAdapter extends BaseRecyclerViewAdapter<String,
    CategoriesChildVM, CategoryChildViewHolder> {

    private LayoutInflater inflater;

    public CategoryChildAdapter(Context ctx,
        List<RecyclerViewData> recyclerViewDatas) {
        super(ctx, recyclerViewDatas);
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getGroupView(ViewGroup parent) {
        return inflater.inflate(R.layout.item_category_right_parent, parent, false);
    }

    @Override
    public View getChildView(ViewGroup parent) {
        return inflater.inflate(R.layout.item_category_right_child, parent, false);
    }

    @Override
    public CategoryChildViewHolder createRealViewHolder(Context ctx, View view, int viewType) {
        return new CategoryChildViewHolder(ctx, view, viewType);
    }

    @Override
    public void onBindGroupHolder(CategoryChildViewHolder holder, int groupPos, int position,
        String groupData) {
        holder.bindGroupData(groupData, position);
    }

    @Override
    public void onBindChildHolder(CategoryChildViewHolder holder, int groupPos, int childPos,
        int position, CategoriesChildVM childData) {
        holder.bindChildData(childData, position);
    }
}

package com.goshop.app.common.view.expandablerecyclerview.listener;

import com.goshop.app.common.view.expandablerecyclerview.bean.GroupItem;
import android.view.View;

@SuppressWarnings("ALL")
public interface OnRecyclerViewListener {

    interface OnItemClickListener {

        void onGroupItemClick(int position, int groupPosition, View view, GroupItem item);

        void onChildItemClick(int position, int groupPosition, int childPosition, View view);
    }
}

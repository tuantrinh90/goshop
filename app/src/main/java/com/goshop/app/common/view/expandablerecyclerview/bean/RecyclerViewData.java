package com.goshop.app.common.view.expandablerecyclerview.bean;

import java.util.List;

@SuppressWarnings("ALL")
public class RecyclerViewData<T, S> {

    private GroupItem groupItem;

    /**
     * @param isExpand When the data is initialized, the group data is expanded.
     */
    public RecyclerViewData(T groupData, List<S> childDatas, boolean isExpand) {
        this.groupItem = new GroupItem(groupData, childDatas, isExpand);
    }

    public RecyclerViewData(T groupData, List<S> childDatas) {
        this.groupItem = new GroupItem(groupData, childDatas, false);
    }

    public GroupItem getGroupItem() {
        return groupItem;
    }

    public void setGroupItem(GroupItem groupItem) {
        this.groupItem = groupItem;
    }

    public T getGroupData() {
        return (T) groupItem.getGroupData();
    }

    public void removeChild(int position) {
        if (null == groupItem || !groupItem.hasChilds()) {
            return;
        }
        groupItem.getChildDatas().remove(position);
    }

    public S getChild(int childPosition) {
        return (S) groupItem.getChildDatas().get(childPosition);
    }

}

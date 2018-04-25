package com.goshop.app.common.view.expandablerecyclerview.bean;

import java.util.List;

@SuppressWarnings("ALL")
public class GroupItem<T, S> extends BaseItem {

    //head data
    private T groupData;

    //child Datas
    private List<S> childDatas;

    //Whether to expand ,expand by default.
    private boolean isExpand = true;

    //Returns a parent node
    @Override
    public boolean isParent() {
        return true;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void onExpand() {
        isExpand = !isExpand;
    }

    public GroupItem(T groupData, List<S> childDatas, boolean isExpand) {
        this.groupData = groupData;
        this.childDatas = childDatas;
        this.isExpand = isExpand;
    }

    public boolean hasChilds() {
        if (getChildDatas() == null || getChildDatas().isEmpty()) {
            return false;
        }
        return true;
    }

    public List<S> getChildDatas() {
        return childDatas;
    }

    public void setChildDatas(List<S> childDatas) {
        this.childDatas = childDatas;
    }

    public T getGroupData() {
        return groupData;
    }
}

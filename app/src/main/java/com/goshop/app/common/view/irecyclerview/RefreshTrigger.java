package com.goshop.app.common.view.irecyclerview;

@SuppressWarnings("ALL")
public interface RefreshTrigger {

    void onStart(boolean automatic, int headerHeight, int finalHeight);

    void onMove(boolean finished, boolean automatic, int moved);

    void onRefresh();

    void onRelease();

    void onComplete();

    void onReset();
}

package com.goshop.app.presentation.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ChannelVM;
import com.goshop.app.presentation.model.TVShowVM;
import com.goshop.app.widget.adapter.ChannelAdapter;
import com.goshop.app.widget.listener.OnChannelItemClickListener;
import com.goshop.app.widget.listener.OnTVShowItemsClickListener;
import com.longtailvideo.jwplayer.JWPlayerView;

import org.mightyfrog.widget.CenteringRecyclerView;



import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TVShowPageFragment extends BaseFragment<TVShowPageContract.Presenter> implements
    TVShowPageContract.View, OnTVShowItemsClickListener, OnChannelItemClickListener,
    TVShowLeftAdapter.JWPlayerListener {

    @BindView(R.id.appbarlayout_tvshow)
    AppBarLayout appBarLayoutTvShow;

    boolean isSelectScroll = false;

    @BindView(R.id.recyclerview_tvshow_channel)
    RecyclerView recyclerViewTvShowChannel;

    @BindView(R.id.recyclerview_calendar)
    RecyclerView recyclerviewCalendar;

    @BindView(R.id.recyclerview_left)
    CenteringRecyclerView recyclerviewLeft;

    @BindView(R.id.recyclerview_right)
    CenteringRecyclerView recyclerviewRight;

    @BindView(R.id.tv_calandar)
    RobotoRegularTextView tvCalandar;

    private TVShowCalendarAdapter calendarAdapter;

    private ChannelAdapter channelAdapter;

    private List<ChannelVM> channelVMS;

    //todo this is mock data
    private String currentDay = "15";

    private TVShowLeftAdapter leftAdapter;

    private int leftIndex, rightIndex;

    private LinearLayoutManager leftManager;

    private boolean move = false;

    private boolean moveRight = false;

    private TVShowRightAdapter rightAdapter;

    private LinearLayoutManager rightManager;

    private List<TVShowVM> tvShowVMDatas;

    private int currentLast, currentPos;
    private MainPageActivity mainPageActivity;

    public static TVShowPageFragment getInstance() {
        return new TVShowPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainPageActivity) {
            mainPageActivity = (MainPageActivity) context;
        }
    }

    private void initData() {
        //TODO wait for api
        mPresenter.tvShowRequest(null);
        channelVMS = mPresenter.getChannels();
        channelAdapter.setUpdateData(channelVMS);
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_tv_page;
    }

    public void initView() {
        tvShowVMDatas = new ArrayList<>();
        channelVMS = new ArrayList<>();
        initRecyclerView();
        initRecyclerViewListener();
        appBarLayoutListener();
    }

    private void initRecyclerView() {
        LinearLayoutManager channelManager = new LinearLayoutManager(getActivity());
        channelManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager calendarManager = new LinearLayoutManager(getContext());
        calendarManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        leftManager = new LinearLayoutManager(getContext());
        rightManager = new LinearLayoutManager(getContext());
        recyclerViewTvShowChannel.setLayoutManager(channelManager);
        recyclerviewCalendar.setLayoutManager(calendarManager);
        recyclerviewLeft.setLayoutManager(leftManager);
        recyclerviewRight.setLayoutManager(rightManager);

        channelAdapter = new ChannelAdapter(new ArrayList<>());
        calendarAdapter = new TVShowCalendarAdapter(new ArrayList<>(), currentDay);
        leftAdapter = new TVShowLeftAdapter(getActivity(), new ArrayList<>());
        rightAdapter = new TVShowRightAdapter(new ArrayList<>());
        recyclerViewTvShowChannel.setAdapter(channelAdapter);
        recyclerviewCalendar.setAdapter(calendarAdapter);
        recyclerviewLeft.setAdapter(leftAdapter);
        recyclerviewRight.setAdapter(rightAdapter);

        channelAdapter.setOnChannelItemClickListener(this);
        rightAdapter.setOnTVShowRightItemClickListener(this);
        calendarAdapter.setOnCalendarItemClickListener(this);
        leftAdapter.setJWPlayerListener(this);
    }

    private void initRecyclerViewListener() {
        recyclerviewLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstItemPosition = leftManager.findFirstVisibleItemPosition();
                if (move) {
                    move = false;
                    int n = leftIndex - firstItemPosition;
                    if (0 <= n && n < recyclerviewLeft.getChildCount()) {
                        int top = recyclerviewLeft.getChildAt(n).getTop();
                        recyclerviewLeft.smoothScrollBy(0, top);
                    }
                } else {
                    switch (newState) {
                        case RecyclerView.SCROLL_STATE_IDLE:
                            moveScrollItemLeftListToRight();
//                                    View childView = leftManager
//                                            .findViewByPosition(firstItemPosition);
//                                    int childViewHeight = childView.getHeight();
//                                    int childViewTop = childView.getTop();
//                                    Log.d("tuan", "childViewHeight + childViewTop:  " + childViewHeight + "," + childViewTop);
//                                    if (Math.abs(childViewTop) == recyclerView.getPaddingTop() || Math
//                                            .abs(childViewTop) == recyclerView.getPaddingTop() * 2) {
//                                    } else if (Math.abs(childViewTop) >= childViewHeight / 2.0f) {
//                                        int nextPosition = firstItemPosition + 1;
//                                        Log.d("tuan", "firstItemPosition + nextPosition:  " + firstItemPosition + "," + nextPosition);
//                                        Log.d("tuan", "lastItemPosition:  " + lastItemPosition);
//                                        scollRightToPosition(nextPosition);
//                                        rightAdapter.updateCurrentVMS(nextPosition);
//                                        calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(nextPosition).getDay());
//                                    } else {
//                                        scollRightToPosition(firstItemPosition);
//                                        rightAdapter.updateCurrentVMS(firstItemPosition);
//                                        calendarAdapter.updateSelectCalendar(
//                                                tvShowVMDatas.get(firstItemPosition).getDay());
//                                    }
                            break;
                    }
                }
            }

        });


        recyclerviewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
//                if (moveRight) {
//                    moveRight = false;
                int n = rightIndex - rightManager.findFirstVisibleItemPosition();
                if (0 <= n && n < recyclerviewRight.getChildCount()) {
                    int top = recyclerviewRight.getChildAt(n).getTop();
                    recyclerviewRight.smoothScrollBy(0, top);
                }
            }
//            }
//
        });
    }


    private void appBarLayoutListener() {
        appBarLayoutTvShow
                .addOnOffsetChangedListener((AppBarLayout appBarLayout, int verticalOffset) -> {
                            if (Math.abs(verticalOffset) >= appBarLayoutTvShow.getTotalScrollRange()) {
                                tvCalandar.setVisibility(View.VISIBLE);
                                tvCalandar.setText(currentDay);
                            } else {
                                tvCalandar.setVisibility(View.GONE);
                            }
                        }
                );

    }

    private void scollRightToPosition(int position) {
        rightIndex = position;
        int firstItem = rightManager.findFirstVisibleItemPosition();
        int lastItem = rightManager.findLastVisibleItemPosition();
        if (position <= firstItem) {
            recyclerviewRight.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            int n = rightIndex - firstItem;
            if (0 <= n && n < recyclerviewRight.getChildCount()) {
                int top = recyclerviewRight.getChildAt(n).getTop();
                recyclerviewRight.smoothScrollBy(0, top);
            }
        } else {
            recyclerviewRight.smoothScrollToPosition(position);
            moveRight = true;
        }
    }

    private void moveScrollItemLeftListToRight() {
        int firstItemPosition = leftManager.findFirstVisibleItemPosition();
        int lastItemPosition = leftManager.findLastVisibleItemPosition();

        if (firstItemPosition == 0 && rightAdapter.getCurrentPosition() != 0) {
            rightAdapter.updateCurrentVMS(firstItemPosition);
            recyclerviewRight.scrollToPosition(firstItemPosition);
            calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(firstItemPosition).getDay());

        } else if (lastItemPosition == tvShowVMDatas.size() && rightAdapter.getCurrentPosition() != 0) {
            rightAdapter.updateCurrentVMS(lastItemPosition);
            recyclerviewRight.scrollToPosition(lastItemPosition);
            calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(lastItemPosition).getDay());

        } else if (0 < firstItemPosition && lastItemPosition == firstItemPosition + 1) {
            rightAdapter.updateCurrentVMS(lastItemPosition);
            recyclerviewRight.scrollToPosition(lastItemPosition);
            calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(lastItemPosition).getDay());

        } else {
            if (currentLast <= lastItemPosition && rightAdapter.getCurrentPosition() != 0) {
                currentPos = (int) Math.ceil((firstItemPosition + lastItemPosition) / 2);
                recyclerviewRight.head(currentPos);
                rightAdapter.updateCurrentVMS(currentPos);
                calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(currentPos).getDay());
            } else {
                currentPos = (int) Math.floor((firstItemPosition + lastItemPosition) / 2);
                recyclerviewRight.head(currentPos);
                rightAdapter.updateCurrentVMS(currentPos);
                calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(currentPos).getDay());
            }

            currentLast = lastItemPosition;
        }
    }


    @Override
    public void inject() {
        initPresenterComponent().inject(this);
    }

    @Override
    public void showTvShowResult(List<TVShowVM> tvShowVMS) {
        tvShowVMDatas.clear();
        tvShowVMDatas = tvShowVMS;
        calendarAdapter.setUpdateDatas(tvShowVMDatas, currentDay);
        leftAdapter.setUpdateDatas(tvShowVMDatas);
        rightAdapter.setUpdateDatas(tvShowVMDatas);
        for (TVShowVM tvShowVM : tvShowVMDatas) {
            if (tvShowVM.getDay().equals(currentDay)) {
//                recyclerviewLeft.head(tvShowVMDatas.indexOf(tvShowVM));
//                rightAdapter.updateCurrentVMS(tvShowVMDatas.indexOf(tvShowVM));
//                recyclerviewRight.head(tvShowVMDatas.indexOf(tvShowVM));
//                //scollRightToPosition(tvShowVMDatas.indexOf(tvShowVM));
//                calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(tvShowVMDatas.indexOf(tvShowVM)).getDay());
                moveLeftToPosition(tvShowVMDatas.indexOf(tvShowVM));
                break;
            }
        }
    }

    private void moveLeftToPosition(int index) {
        leftIndex = index;
        int firstItemL = leftManager.findFirstVisibleItemPosition();
        int lastItemL = leftManager.findLastVisibleItemPosition();

        if (index <= firstItemL) {
            recyclerviewLeft.smoothScrollToPosition(index);
        } else if (index <= lastItemL) {
            int topLeft = recyclerviewLeft.getChildAt(index - firstItemL).getTop();
            recyclerviewLeft.smoothScrollBy(0, topLeft);

        } else {
            recyclerviewLeft.smoothScrollToPosition(index);
            move = true;
        }

        //recyclerviewRight.head(index);
        scollRightToPosition(index);
        rightAdapter.updateCurrentVMS(index);
        calendarAdapter.updateSelectCalendar(index);

//        int firstItem = leftManager.findFirstVisibleItemPosition();
//        int lastItem = leftManager.findLastVisibleItemPosition();
//        if (index <= firstItem) {
//            recyclerviewLeft.smoothScrollToPosition(index);
//        } else if (index <= lastItem) {
//            int top = recyclerviewLeft.getChildAt(index - firstItem).getTop();
//            recyclerviewLeft.smoothScrollBy(0, top);
//        } else {
//            recyclerviewLeft.smoothScrollToPosition(index);
//            move = true;
//        }
//        if (!isSelectScroll) {
//            isSelectScroll = false;
//            rightAdapter.updateCurrentVMS(index);
//            recyclerviewRight.head(index);
//            //scollRightToPosition(index);
//            calendarAdapter.updateSelectCalendar(index);
//        }
    }

    @Override
    public void onTVShowRightItemClick(int position) {
        isSelectScroll = true;
        moveLeftToPosition(position);
    }

    @Override
    public void onCalendarItemClick(int position) {
        moveLeftToPosition(position);
    }

    @Override
    public void onChannelItemClick(int position) {
        //todo need decide
    }

    @Override
    public void onFullscreen(boolean isFullScreen, JWPlayerView jwPlayerView) {
        if (isAdded() && mainPageActivity != null) {
            mainPageActivity.onJWPlayerViewFullscreen(isFullScreen, jwPlayerView);
        }
    }

}

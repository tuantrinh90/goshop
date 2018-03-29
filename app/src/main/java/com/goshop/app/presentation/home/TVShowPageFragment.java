package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ChannelVM;
import com.goshop.app.presentation.model.TVShowVM;
import com.goshop.app.widget.adapter.ChannelAdapter;
import com.goshop.app.widget.listener.OnChannelItemClickListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class TVShowPageFragment extends BaseFragment<TVShowPageContract.Presenter> implements
    TVShowPageContract.View, TVShowRightAdapter.OnTVShowRightItemClickListener,
    TVShowCalendarAdapter.OnCalendarItemClickListener, OnChannelItemClickListener {

    @BindView(R.id.appbarlayout_tvshow)
    AppBarLayout appBarLayoutTvShow;

    boolean isSelectScroll = false;

    @BindView(R.id.recyclerview_tvshow_channel)
    RecyclerView recyclerViewTvShowChannel;

    @BindView(R.id.recyclerview_calendar)
    RecyclerView recyclerviewCalendar;

    @BindView(R.id.recyclerview_left)
    RecyclerView recyclerviewLeft;

    @BindView(R.id.recyclerview_right)
    RecyclerView recyclerviewRight;

    @BindView(R.id.tv_calandar)
    RobotoRegularTextView tvCalandar;

    Unbinder unbinder;

    private TVShowCalendarAdapter calendarAdapter;

    private LinearLayoutManager calendarManager;

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

    public static TVShowPageFragment getInstance() {
        return new TVShowPageFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        assert rootView != null;
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public int getContentView() {
        return R.layout.fragment_tv_page;
    }

    @Override
    public void initView() {
        tvShowVMDatas = new ArrayList<>();
        channelVMS = new ArrayList<>();
        initRecyclerView();
        initPresenter();
        initRecyclerViewListener();
        appBarLayoutListener();
        initChannelRecyclerView();
    }

    private void initRecyclerView() {
        calendarManager = new LinearLayoutManager(getContext());
        calendarManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        leftManager = new LinearLayoutManager(getContext());
        rightManager = new LinearLayoutManager(getContext());
        recyclerviewCalendar.setLayoutManager(calendarManager);
        recyclerviewLeft.setLayoutManager(leftManager);
        recyclerviewRight.setLayoutManager(rightManager);

        calendarAdapter = new TVShowCalendarAdapter(new ArrayList<>(), currentDay);
        leftAdapter = new TVShowLeftAdapter(new ArrayList<>());
        rightAdapter = new TVShowRightAdapter(new ArrayList<>());
        recyclerviewCalendar.setAdapter(calendarAdapter);
        recyclerviewLeft.setAdapter(leftAdapter);
        recyclerviewRight.setAdapter(rightAdapter);
        rightAdapter.setOnTVShowRightItemClickListener(this::onTVShowRightItemClick);
        calendarAdapter.setOnCalendarItemClickListener(this::onCalendarItemClick);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerViewListener() {
        recyclerviewLeft.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstItemPosition = leftManager.findFirstVisibleItemPosition();
                int lastItemPosition = leftManager.findLastVisibleItemPosition();
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

                            View childView = leftManager
                                .findViewByPosition(firstItemPosition);
                            int childViewHeight = childView.getHeight();
                            int childViewTop = childView.getTop();
                            if (Math.abs(childViewTop) == recyclerView.getPaddingTop() || Math
                                .abs(childViewTop) == recyclerView.getPaddingTop() * 2) {
                            } else if (Math.abs(childViewTop) >= childViewHeight / 2.0f) {
                                int nextPosition = firstItemPosition + 1;
                                scollRightToPosition(nextPosition);
                                rightAdapter.updateCurrentVMS(nextPosition);
                                calendarAdapter
                                    .updateSelectCalendar(tvShowVMDatas.get(nextPosition).getDay());
                            } else {
                                scollRightToPosition(firstItemPosition);
                                rightAdapter.updateCurrentVMS(firstItemPosition);
                                calendarAdapter.updateSelectCalendar(
                                    tvShowVMDatas.get(firstItemPosition).getDay());
                            }

                            break;
                    }
                }

                if (firstItemPosition == 0 && rightAdapter.getCurrentPosition() != 0) {
                    rightAdapter.updateCurrentVMS(firstItemPosition);
                    scollRightToPosition(firstItemPosition);
                    calendarAdapter
                        .updateSelectCalendar(tvShowVMDatas.get(firstItemPosition).getDay());
                } else if (lastItemPosition == tvShowVMDatas.size() - 1 && rightAdapter
                    .getCurrentPosition() != 0) {
                    rightAdapter.updateCurrentVMS(lastItemPosition);
                    scollRightToPosition(lastItemPosition);
                    calendarAdapter
                        .updateSelectCalendar(tvShowVMDatas.get(lastItemPosition).getDay());
                }
            }
        });

        recyclerviewRight.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (moveRight) {
                    moveRight = false;
                    int n = rightIndex - rightManager.findFirstVisibleItemPosition();
                    if (0 <= n && n < recyclerviewRight.getChildCount()) {
                        int top = recyclerviewRight.getChildAt(n).getTop();
                        recyclerviewRight.smoothScrollBy(0, top);
                    }
                }
            }
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

    private void initChannelRecyclerView() {
        LinearLayoutManager channelManager = new LinearLayoutManager(getActivity());
        channelManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewTvShowChannel.setLayoutManager(channelManager);

        channelAdapter = new ChannelAdapter(new ArrayList<>());
        recyclerViewTvShowChannel.setAdapter(channelAdapter);
        channelAdapter.setOnChannelItemClickListener(this::onChannelItemClick);
    }

    private void scollRightToPosition(int position) {
        rightIndex = position;
        int firstItem = rightManager.findFirstVisibleItemPosition();
        int lastItem = rightManager.findLastVisibleItemPosition();
        if (position <= firstItem) {
            recyclerviewRight.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            int top = recyclerviewRight.getChildAt(position - firstItem).getTop();
            recyclerviewRight.smoothScrollBy(0, top);
        } else {
            recyclerviewRight.smoothScrollToPosition(position);
            moveRight = true;
        }
    }

    @Override
    public void setup() {
        //TODO(helen)wait for api
        mPresenter.tvShowRequest(null);
        channelVMS = mPresenter.getChannels();
        channelAdapter.setUpdateData(channelVMS);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
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
                moveLeftToPosition(tvShowVMDatas.indexOf(tvShowVM));
                break;
            }
        }
    }

    private void moveLeftToPosition(int index) {
        leftIndex = index;
        int firstItem = leftManager.findFirstVisibleItemPosition();
        int lastItem = leftManager.findLastVisibleItemPosition();
        if (index <= firstItem) {
            recyclerviewLeft.smoothScrollToPosition(index);
        } else if (index <= lastItem) {
            int top = recyclerviewLeft.getChildAt(index - firstItem).getTop();
            recyclerviewLeft.smoothScrollBy(0, top);
        } else {
            recyclerviewLeft.smoothScrollToPosition(index);
            move = true;
        }

        if (!isSelectScroll) {
            isSelectScroll = false;
            rightAdapter.updateCurrentVMS(index);
            scollRightToPosition(index);
            calendarAdapter.updateSelectCalendar(tvShowVMDatas.get(index).getDay());
        } else {
            isSelectScroll = false;
        }
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
}

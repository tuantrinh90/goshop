package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.TVShowVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class TVShowPageFragment extends BaseFragment<TVShowPageContract.Presenter> implements
    TVShowPageContract.View, TVShowRightAdapter.OnTVShowRightItemClickListener,
    TVShowCalendarAdapter.OnCalendarItemClickListener {

    @BindView(R.id.appbarlayout_tvshow)
    AppBarLayout appBarLayoutTvShow;

    boolean isSelectScroll = false;

    @BindView(R.id.recyclerview_calendar)
    RecyclerView recyclerviewCalendar;

    @BindView(R.id.recyclerview_left)
    RecyclerView recyclerviewLeft;

    @BindView(R.id.recyclerview_right)
    RecyclerView recyclerviewRight;

    @BindView(R.id.rg_channels)
    RadioGroup rgChannels;

    @BindView(R.id.tv_calandar)
    RobotoRegularTextView tvCalandar;

    Unbinder unbinder;

    private TVShowCalendarAdapter calendarAdapter;

    private LinearLayoutManager calendarManager;

    //todo this is mock data
    private String currentDay = "15";

    private TVShowLeftAdapter leftAdapter;

    private LinearLayoutManager leftManager;

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
        initRecyclerView();
        initPresenter();
        initRecyclerViewListener();
        appBarLayoutListener();
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
                if (!isSelectScroll) {
                    int firstItemPosition = leftManager.findFirstVisibleItemPosition();
                    int lastItemPosition = leftManager.findLastVisibleItemPosition();
                    if (lastItemPosition == leftManager.getItemCount() - 1) {
                        scollRightToPosition(lastItemPosition);
                        rightAdapter.updateCurrentVMS(lastItemPosition);
                    } else {
                        scollRightToPosition(firstItemPosition);
                        rightAdapter.updateCurrentVMS(firstItemPosition);
                    }
                } else {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        isSelectScroll = false;
                    }
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
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

    private void scollRightToPosition(int position) {
        int firstItem = rightManager.findFirstVisibleItemPosition();
        int lastItem = rightManager.findLastVisibleItemPosition();
        if (position <= firstItem) {
            recyclerviewRight.smoothScrollToPosition(position);
        } else if (position <= lastItem) {
            int top = recyclerviewRight.getChildAt(position - firstItem).getTop();
            recyclerviewRight.smoothScrollBy(0, top);
        } else {
            recyclerviewRight.smoothScrollToPosition(position);
        }
    }

    @Override
    public void setup() {
        //TODO(helen)wait for api
        mPresenter.tvShowRequest(null);

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
                recyclerviewLeft.smoothScrollToPosition(tvShowVMDatas.indexOf(tvShowVM));
                break;
            }
        }
    }

    @Override
    public void onTVShowRightItemClick(int position) {
        isSelectScroll = true;
        recyclerviewLeft.smoothScrollToPosition(position);

    }

    @Override
    public void onCalendarItemClick(int position) {
        //todo need decide
//        recyclerviewLeft.smoothScrollToPosition(position);
    }

}

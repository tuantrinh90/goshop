package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.TVVideoLeftVM;
import com.goshop.app.presentation.model.TVVideoRightVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
    TVShowPageContract.View {

    @BindView(R.id.recyclerview_video_left)
    RecyclerView recyclerviewVideoLeft;

    @BindView(R.id.recyclerview_video_right)
    RecyclerView recyclerviewVideoRight;

    @BindView(R.id.rg_channels)
    RadioGroup rgChannels;

    Unbinder unbinder;

    private TVCalendarAdapter calendarAdapter;

    private TVVideoLeftAdapter leftAdapter;

    private TVVideoRightAdapter rightAdapter;

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
        initRecyclerView();
        initPresenter();
    }

    private void initRecyclerView() {
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewVideoLeft.setLayoutManager(leftManager);
        leftAdapter = new TVVideoLeftAdapter(new ArrayList<>());
        recyclerviewVideoLeft.setAdapter(leftAdapter);

        LinearLayoutManager rightManager = new LinearLayoutManager(getActivity());
        rightManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewVideoRight.setLayoutManager(rightManager);
        rightAdapter = new TVVideoRightAdapter(new ArrayList<>());
        recyclerviewVideoRight.setAdapter(rightAdapter);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void setup() {
        //TODO(helen)wait for api
        mPresenter.rightVideoRequest(null);
        mPresenter.leftVideoRequest(null);
        rgChannels.setOnCheckedChangeListener((RadioGroup group, int checkedId) -> {
            switch (checkedId) {
                case R.id.rb_ch118:
                    break;
                case R.id.rb_ch120:
                    break;
                case R.id.rb_ch303:
                    break;
                case R.id.rb_fb_live:
                    break;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showRightVideoResult(List<TVVideoRightVM> videoRightVMS) {
        rightAdapter.setUpdateDatas(videoRightVMS);
    }

    @Override
    public void showLeftVideoResult(List<TVVideoLeftVM> videoLeftVMS) {
        leftAdapter.setUpdateDatas(videoLeftVMS);
    }
}

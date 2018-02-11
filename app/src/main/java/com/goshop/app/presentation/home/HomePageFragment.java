package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseFragment;
import com.goshop.app.presentation.model.WidgetViewModel;
import com.goshop.app.widget.WidgetViewAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

/**
 * Created by helen on 2018/2/11.
 */

public class HomePageFragment extends BaseFragment<HomePageContract.Presenter> implements
    HomePageContract.View {

    @BindView(R.id.recyclerview_home)
    RecyclerView recyclerviewHome;

    Unbinder unbinder;

    private WidgetViewAdapter viewAdapter;

    public static HomePageFragment getInstance() {
        return new HomePageFragment();
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
        return R.layout.fragment_home_page;
    }

    @Override
    public void initView() {
        initPresenter();
        initRecyclerview();
    }

    @Override
    public void setup() {
        //TODO(helen) wait for api
        mPresenter.homePageRequest(null);

    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerview() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerviewHome.setLayoutManager(manager);
        viewAdapter = new WidgetViewAdapter(new ArrayList<>());
        recyclerviewHome.setAdapter(viewAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void homePageResult(List<WidgetViewModel> widgetViewModels) {
        viewAdapter.setUpdateDatas(widgetViewModels);
    }
}

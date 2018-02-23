package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.PointsModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyPointsActivity extends BaseActivity<MyPointsContract.Presenter> implements
    MyPointsContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_points)
    RecyclerView recyclerviewPoints;

    private MyPointsAdapter pointsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo(helen) wait for api
        mPresenter.myPointsRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_points;
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageviewLeftMenu.setOnClickListener(v -> finish());
        initPresenter();
        initRecyclerview();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_point);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerview() {
        pointsAdapter = new MyPointsAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewPoints.setLayoutManager(layoutManager);
        recyclerviewPoints.setAdapter(pointsAdapter);
    }

    @Override
    public void showMyPointsResult(List<PointsModel> pointsModels) {
        pointsAdapter.setUpdateDatas(pointsModels);
    }
}

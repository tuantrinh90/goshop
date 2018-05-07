package com.goshop.app.presentation.goloyalty;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.account.MyPointsActivity;
import com.goshop.app.presentation.model.GoLoyaltyModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class GoLoyaltyActivity extends BaseDrawerActivity<GoLoyaltyContract.Presenter> implements
    GoLoyaltyContract.View, GoLoyaltyAdapter.OnGoLoyaltyItemsClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_go_loyalty)
    RecyclerView recyclerviewGoLoyalty;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private GoLoyaltyAdapter goLoyaltyAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initRecyclerView();
        //todo wait for api
        mPresenter.goLoyaltyRequest(null);
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(recyclerviewGoLoyalty), 200);
    }


    @Override
    public int getContentView() {
        return R.layout.activity_go_loyalty;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_GO_LOYALTY);
        setContentView(getContentView());
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewGoLoyalty.setLayoutManager(layoutManager);
        goLoyaltyAdapter = new GoLoyaltyAdapter(new ArrayList<>());
        recyclerviewGoLoyalty.setAdapter(goLoyaltyAdapter);
        goLoyaltyAdapter.setOnGoLoyaltyItemsClickListener(this);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.go_loyalty);
    }

    @Override
    public void showGoLoyaltyResult(List<GoLoyaltyModel> goLoyaltyModels) {
        goLoyaltyAdapter.setUpdatas(goLoyaltyModels);
    }

    @Override
    public void onPointsItemClick() {
        startActivity(new Intent(this, MyPointsActivity.class));
    }

    @Override
    public void onDealItemClick() {
        startActivity(new Intent(this, RewardsDetailActivity.class));
    }

    @Override
    public void onViewAllClick() {
        startActivity(new Intent(this, AllDealsActivity.class));
    }
}

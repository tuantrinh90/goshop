package com.goshop.app.presentation.goloyalty;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.GoLoyaltyDealsVM;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.search.FilterMenuAdapter;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AllDealsActivity extends BaseActivity<AllDealsContract.Presenter> implements
    AllDealsContract.View, PopWindowUtil.OnPopWindowDismissListener {

    AllDealsAdapter allDealsAdapter;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.ll_filter_menu)
    LinearLayout llFilterMenu;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerviewFilter;

    @BindView(R.id.recycleview_all_deals)
    RecyclerView recycleviewAllDeals;

    @BindView(R.id.rl_drawer_filter)
    RelativeLayout rlDrawerFilter;

    @BindView(R.id.tv_btn_filter_clear)
    RobotoRegularTextView tvBtnFilterClear;

    @BindView(R.id.tv_btn_filter_done)
    RobotoRegularTextView tvBtnFilterDone;

    @BindView(R.id.tv_btn_sort)
    RobotoLightTextView tvBtnSort;

    @BindView(R.id.tv_filter_menu_top)
    RobotoRegularTextView tvFilterMenuTop;

    private FilterMenuAdapter menuAdapter;

    private List<SortVM> sortVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo wait for api
        sortVMS = mPresenter.getSortVMS();
        sortVMS.get(0).setSelect(true);
        tvBtnSort.setText(sortVMS.get(0).getTitle());
        mPresenter.allDealsRequest(null);
        mPresenter.filterMenuRequest(null);
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(recyclerviewFilter), 200);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_all_deals;
    }

    @Override
    public void inject() {
        hideRightMenu();
        sortVMS = new ArrayList<>();
        tvBtnSort.setSelected(false);
        ivSortArrow.setSelected(false);
        initPresenter();
        initRecyclerView();
        initFilterMenuRecyclerView();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycleviewAllDeals.setLayoutManager(manager);
        allDealsAdapter = new AllDealsAdapter(new ArrayList<>());
        recycleviewAllDeals.setAdapter(allDealsAdapter);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterMenuAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.all_deals);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void showAllDealsResult(List<GoLoyaltyDealsVM> dealsVMS) {
        allDealsAdapter.setUpdateDatas(dealsVMS);
    }

    @Override
    public void showFilterMenu(List<FilterMenuModel> filterMenuModels) {
        menuAdapter.updateDatas(filterMenuModels);
    }

    @OnClick({R.id.imageview_left_menu, R.id.iv_btn_filter, R.id.iv_sort_arrow, R.id.tv_btn_sort,
        R.id.tv_btn_filter_clear, R.id.tv_btn_filter_done})
    public void onAllViewClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.iv_btn_filter:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.iv_sort_arrow:
            case R.id.tv_btn_sort:
                ivSortArrow.setSelected(!ivSortArrow.isSelected());
                tvBtnSort.setSelected(!tvBtnSort.isSelected());
                if (tvBtnSort.isSelected()) {
                    PopWindowUtil.showsSortListPop(tvBtnSort, sortVMS, this);
                }
                break;

            case R.id.tv_btn_filter_clear:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_filter_done:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }

    @Override
    public void onPopItemClick(int position) {
        sortVMS.get(position).setSelect(true);
        tvBtnSort.setText(sortVMS.get(position).getTitle());
    }

    @Override
    public void onDismiss() {
        ivSortArrow.setSelected(false);
        tvBtnSort.setSelected(false);
    }
}

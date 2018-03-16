package com.goshop.app.presentation.category;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.search.FilterMenuAdapter;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
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

public class CategoryTreeDetailActivity extends BaseActivity<CategoryTreeDetailContract
    .Presenter> implements CategoryTreeDetailContract.View, CategoryTreeDetailAdapter
    .OnItemClickListener, OnProductItemClickListener, PopWindowUtil.OnPopWindowDismissListener {

    public static final String CATEGORY_DETAIL_TITLE = "title";

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.iv_btn_filter)
    ImageView ivBtnFilter;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.ll_category_nodata)
    LinearLayout llCategoryNodata;

    @BindView(R.id.ll_filter_menu)
    LinearLayout llFilterMenu;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerviewFilter;

    @BindView(R.id.recycleview_category_tree_detail)
    RecyclerView recycleviewCategoryTreeDetail;

    @BindView(R.id.rl_category_tree_filter)
    RelativeLayout rlCategoryTreeFilter;

    @BindView(R.id.rl_drawer_filter)
    RelativeLayout rlDrawerFilter;

    @BindView(R.id.textview_toolbar_title)
    RobotoBoldTextView textviewToolbarTitle;

    @BindView(R.id.tv_btn_filter_clear)
    RobotoRegularTextView tvBtnSearchFilterClear;

    @BindView(R.id.tv_btn_filter_done)
    RobotoRegularTextView tvBtnSearchFilterDone;

    @BindView(R.id.tv_btn_sort)
    RobotoRegularTextView tvBtnSort;

    @BindView(R.id.tv_search_or)
    RobotoRegularTextView tvSearchOr;

    private CategoryTreeDetailAdapter detailAdapter;

    private FilterMenuAdapter menuAdapter;

    private String title;

    private List<SortVM> sortVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntentData();
        //TODO  wait for api
        mPresenter.categoryDetailRequest(null);
        sortVMS = mPresenter.getSortVMS();
        sortVMS.get(0).setSelect(true);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_category_tree_detail;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecyclerview();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerview() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycleviewCategoryTreeDetail.setLayoutManager(gridLayoutManager);
        detailAdapter = new CategoryTreeDetailAdapter(new ArrayList<>(), this);
        recycleviewCategoryTreeDetail.setAdapter(detailAdapter);
    }

    private void initIntentData() {
        title = getIntent().getStringExtra(CATEGORY_DETAIL_TITLE);
        textviewToolbarTitle.setText(title);
    }

    @OnClick({R.id.imageview_left_menu, R.id.iv_btn_filter, R.id.tv_btn_sort, R.id.iv_sort_arrow})
    public void onCategrayDetailsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.iv_btn_filter:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_sort:
            case R.id.iv_sort_arrow:
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
    public void onClick() {
        //todo wait for api
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
    public void categoryDetailResult(List<SearchFilterModel> filterModels) {
        initFilterMenuRecyclerView();
        llCategoryNodata.setVisibility(View.GONE);
        rlCategoryTreeFilter.setVisibility(View.VISIBLE);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        detailAdapter.setDatas(filterModels);
        mPresenter.filterMenuRequest(null);
    }

    @Override
    public void categoryDetailNoData(List<SearchFilterModel> filterModels) {
        llCategoryNodata.setVisibility(View.VISIBLE);
        rlCategoryTreeFilter.setVisibility(View.GONE);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        detailAdapter.setDatas(filterModels);
    }

    @Override
    public void showFilterMenu(List<FilterMenuModel> filterMenuModels) {
        menuAdapter.updateDatas(filterMenuModels);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterMenuAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {

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

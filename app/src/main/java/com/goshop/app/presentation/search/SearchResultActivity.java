package com.goshop.app.presentation.search;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.presentation.model.widget.ProductsVM;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.adapter.FilterDrawerAdapter;
import com.goshop.app.widget.adapter.ProductGridVerticalAdapter;
import com.goshop.app.widget.listener.OnProductItemClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SearchResultActivity extends BaseActivity<SearchResultContract.Presenter> implements
    SearchResultContract.View, SearchResultAdapter.OnItemClickListener,
    OnProductItemClickListener, PopWindowUtil.OnPopWindowDismissListener {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.iv_sort_arrow)
    ImageView ivSortArrow;

    @BindView(R.id.recyclerview_filter)
    RecyclerView recyclerviewFilter;

    @BindView(R.id.recyclerview_search_result_display)
    RecyclerView recyclerviewSearchResultDisplay;

    @BindView(R.id.rl_drawer_filter)
    RelativeLayout rlDrawerFilter;

    @BindView(R.id.tv_btn_filter_clear)
    RobotoRegularTextView tvBtnSearchFilterClear;

    @BindView(R.id.tv_btn_filter_done)
    RobotoRegularTextView tvBtnSearchFilterDone;

    @BindView(R.id.tv_btn_sort)
    RobotoLightTextView tvBtnSort;

    private ProductGridVerticalAdapter gridVerticalAdapter;

    private FilterDrawerAdapter menuAdapter;

    private List<SortVM> sortVMS;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO  wait for api
        mPresenter.searchResultRequest(null);
        mPresenter.filterMenuRequest(null);
        sortVMS = mPresenter.getSortVMS();
        sortVMS.get(0).setSelect(true);
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(recyclerviewSearchResultDisplay), 200);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_search_result;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initSearchView();
        initPresenter();
        initRecyclerView();
        initFilterMenuRecyclerView();
        initSearchBar();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initSearchView() {
        csetSearch.setDeleteGone();
        String keywords = getIntent().getStringExtra(SearchActivity.KEYWORDS);
        csetSearch.getEditText().setText(keywords);
        csetSearch.getEditText().setSelection(csetSearch.getEditText().getText().length());
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerviewSearchResultDisplay.setLayoutManager(gridLayoutManager);
        //TODO(helen)this divider wait for the design,then decide
//        recyclerviewSearchResultDisplay.addItemDecoration(new CustomGridDivider(this));
        gridVerticalAdapter = new ProductGridVerticalAdapter(new ArrayList<>());
        gridVerticalAdapter.setOnProductItemClickListener(this);
        recyclerviewSearchResultDisplay.setAdapter(gridVerticalAdapter);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterDrawerAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    private void initSearchBar() {
        csetSearch.getEditText().setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                this.finish();
            }
        });
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_sort, R.id.iv_sort_arrow, R.id.iv_btn_filter,
        R.id.tv_btn_filter_clear, R.id.tv_btn_filter_done})
    public void onResultClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_sort:
            case R.id.iv_sort_arrow:
                ivSortArrow.setSelected(!ivSortArrow.isSelected());
                tvBtnSort.setSelected(!tvBtnSort.isSelected());
                if (tvBtnSort.isSelected()) {
                    PopWindowUtil.showsSortListPop(tvBtnSort, sortVMS, this);
                }
                break;
            case R.id.iv_btn_filter:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_filter_clear:
                drawerLayout.closeDrawer(GravityCompat.END);
            case R.id.tv_btn_filter_done:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }

    @Override
    public void showProductsData(List<ProductsVM> productsVMS) {
        gridVerticalAdapter.setUpdateDatas(productsVMS);
    }

    @Override
    public void showFilterMenu(List<FilterMenuModel> filterMenuModels) {
        menuAdapter.updateDatas(filterMenuModels);
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
    public void onClick() {
        startActivity(new Intent(this, ProductDetailActivity.class));
    }

    @Override
    public void onProductItemClick(ProductsVM productItemVM) {
        startActivity(new Intent(this, ProductDetailActivity.class));
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

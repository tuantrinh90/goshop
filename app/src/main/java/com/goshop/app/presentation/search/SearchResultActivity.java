package com.goshop.app.presentation.search;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomGridDivider;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.FilterMenuModel;
import com.goshop.app.presentation.model.SearchFilterModel;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/19.
 */

public class SearchResultActivity extends BaseActivity<SearchResultContract.Presenter> implements
    SearchResultContract.View {

    private static final int NAME_A_Z = 2;

    private static final int NEW_ARRIVALS = 0;

    private static final int PRICE_LOW_HIGH = 1;

    private static final int PROMOTION = 3;

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

    @BindView(R.id.tv_btn_search_filter)
    CustomTextView tvBtnSearchFilter;

    @BindView(R.id.tv_btn_search_filter_clear)
    CustomTextView tvBtnSearchFilterClear;

    @BindView(R.id.tv_btn_search_filter_done)
    CustomTextView tvBtnSearchFilterDone;

    @BindView(R.id.tv_btn_search_sort)
    CustomTextView tvBtnSearchSort;

    private int currentSelectNumber = 0;

    private List<FilterMenuModel> filterMenuModels;

    private FilterMenuAdapter menuAdapter;

    private SearchResultAdapter resultAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.searchResultRequest(null);
        mPresenter.filterMenuRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_search_result;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initSearchView();
        initPresenter();
        initRecyclerView();
        initFilterMenuRecyclerView();
    }

    private void initSearchView() {
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
        recyclerviewSearchResultDisplay.addItemDecoration(new CustomGridDivider(this));
        resultAdapter = new SearchResultAdapter(new ArrayList<>());
        recyclerviewSearchResultDisplay.setAdapter(resultAdapter);
    }

    private void initFilterMenuRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewFilter.setLayoutManager(layoutManager);
        menuAdapter = new FilterMenuAdapter(new ArrayList<>());
        recyclerviewFilter.setAdapter(menuAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_search_sort, R.id.tv_btn_search_filter, R.id
        .tv_btn_search_filter_clear, R.id.tv_btn_search_filter_done})
    public void onResultClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_search_sort:
                ivSortArrow.setSelected(!ivSortArrow.isSelected());
                showSortPop(tvBtnSearchSort, currentSelectNumber);
                break;
            case R.id.tv_btn_search_filter:
                drawerLayout.openDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_search_filter_clear:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
            case R.id.tv_btn_search_filter_done:
                drawerLayout.closeDrawer(GravityCompat.END);
                break;
        }
    }

    public void showSortPop(View parent, int selectNumber) {
        View popView = LayoutInflater.from(this)
            .inflate(R.layout.layout_search_result_sorting_list, null);

        RelativeLayout arrivalLayout = popView.findViewById(R.id.rl_search_result_sorting_arrivals);
        CustomTextView tvArrival = popView.findViewById(R.id.tv_search_result_sorting_arrivals);
        ImageView ivArrival = popView.findViewById(R.id.iv_search_result_sorting_arrivals);

        RelativeLayout priceLayout = popView.findViewById(R.id.rl_search_result_sorting_price);
        CustomTextView tvPrice = popView.findViewById(R.id.tv_search_result_sorting_price);
        ImageView ivPrice = popView.findViewById(R.id.iv_search_result_sorting_price);

        RelativeLayout nameLayout = popView.findViewById(R.id.rl_search_result_sorting_name);
        CustomTextView tvName = popView.findViewById(R.id.tv_search_result_sorting_name);
        ImageView ivName = popView.findViewById(R.id.iv_search_result_sorting_name);

        RelativeLayout promotionLayout = popView
            .findViewById(R.id.rl_search_result_sorting_promotion);
        CustomTextView tvPromotion = popView.findViewById(R.id.tv_search_result_sorting_promotion);
        ImageView ivPromotion = popView.findViewById(R.id.iv_search_result_sorting_promotion);

        ivArrival.setVisibility(View.GONE);
        ivPrice.setVisibility(View.GONE);
        ivName.setVisibility(View.GONE);
        ivPromotion.setVisibility(View.GONE);

        switch (selectNumber) {
            case NEW_ARRIVALS:
                arrivalLayout.setSelected(true);
                tvArrival.setTextIsSelectable(true);
                ivArrival.setVisibility(View.VISIBLE);
                break;
            case PRICE_LOW_HIGH:
                priceLayout.setSelected(true);
                tvPrice.setTextIsSelectable(true);
                ivPrice.setVisibility(View.VISIBLE);
                break;
            case NAME_A_Z:
                nameLayout.setSelected(true);
                tvName.setTextIsSelectable(true);
                ivName.setVisibility(View.VISIBLE);
                break;
            case PROMOTION:
                promotionLayout.setSelected(true);
                tvPromotion.setTextIsSelectable(true);
                ivPromotion.setVisibility(View.VISIBLE);
                break;
            default:
                arrivalLayout.setSelected(true);
                tvArrival.setTextIsSelectable(true);
                ivArrival.setVisibility(View.VISIBLE);
                break;
        }

        PopupWindow popupWindow = new PopupWindow(popView, ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.PopMenuAnimation);
        popupWindow.showAsDropDown(parent);

        arrivalLayout.setOnClickListener(v -> {
            currentSelectNumber = NEW_ARRIVALS;
            tvBtnSearchSort.setText(tvArrival.getText().toString());
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            arrivalLayout.setSelected(true);
            tvArrival.setTextIsSelectable(true);
            ivArrival.setVisibility(View.VISIBLE);
            priceLayout.setSelected(false);
            tvPrice.setTextIsSelectable(false);
            ivPrice.setVisibility(View.GONE);
            nameLayout.setSelected(false);
            tvName.setTextIsSelectable(false);
            ivName.setVisibility(View.GONE);
            promotionLayout.setSelected(false);
            tvPromotion.setTextIsSelectable(false);
            ivPromotion.setVisibility(View.GONE);
            popupWindow.dismiss();
        });
        priceLayout.setOnClickListener(v -> {
            currentSelectNumber = PRICE_LOW_HIGH;
            tvBtnSearchSort.setText(tvPrice.getText().toString());
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            arrivalLayout.setSelected(false);
            tvArrival.setTextIsSelectable(false);
            ivArrival.setVisibility(View.GONE);
            priceLayout.setSelected(true);
            tvPrice.setTextIsSelectable(true);
            ivPrice.setVisibility(View.VISIBLE);
            nameLayout.setSelected(false);
            tvName.setTextIsSelectable(false);
            ivName.setVisibility(View.GONE);
            promotionLayout.setSelected(false);
            tvPromotion.setTextIsSelectable(false);
            ivPromotion.setVisibility(View.GONE);
            popupWindow.dismiss();
        });
        nameLayout.setOnClickListener(v -> {
            currentSelectNumber = NAME_A_Z;
            tvBtnSearchSort.setText(tvName.getText().toString());
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            arrivalLayout.setSelected(false);
            tvArrival.setTextIsSelectable(false);
            ivArrival.setVisibility(View.GONE);
            priceLayout.setSelected(false);
            tvPrice.setTextIsSelectable(false);
            ivPrice.setVisibility(View.GONE);
            nameLayout.setSelected(true);
            tvName.setTextIsSelectable(true);
            ivName.setVisibility(View.VISIBLE);
            promotionLayout.setSelected(false);
            tvPromotion.setTextIsSelectable(false);
            ivPromotion.setVisibility(View.GONE);
            popupWindow.dismiss();
        });
        promotionLayout.setOnClickListener(v -> {
            currentSelectNumber = PROMOTION;
            tvBtnSearchSort.setText(tvPromotion.getText().toString());
            ivSortArrow.setSelected(!ivSortArrow.isSelected());
            arrivalLayout.setSelected(false);
            tvArrival.setTextIsSelectable(false);
            ivArrival.setVisibility(View.GONE);
            priceLayout.setSelected(false);
            tvPrice.setTextIsSelectable(false);
            ivPrice.setVisibility(View.GONE);
            nameLayout.setSelected(false);
            tvName.setTextIsSelectable(false);
            ivName.setVisibility(View.GONE);
            promotionLayout.setSelected(true);
            tvPromotion.setTextIsSelectable(true);
            ivPromotion.setVisibility(View.VISIBLE);
            popupWindow.dismiss();
        });


    }

    @Override
    public void showResult(List<SearchFilterModel> datas) {
        resultAdapter.setDatas(datas);
    }

    @Override
    public void showFilterMenu(List<FilterMenuModel> filterMenuModels) {

        this.filterMenuModels = new ArrayList<>();
        this.filterMenuModels = filterMenuModels;
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
}

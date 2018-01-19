package com.goshop.app.presentation.search;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomGridDivider;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SearchFilterModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

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

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_search_result_display)
    RecyclerView recyclerviewSearchResultDisplay;

    @BindView(R.id.tv_btn_search_arrival)
    CustomTextView tvBtnSearchArrival;

    @BindView(R.id.tv_btn_search_filter)
    CustomTextView tvBtnSearchFilter;

    private SearchResultAdapter resultAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.searchResultRequest(null);
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

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_search_arrival, R.id.tv_btn_search_filter})
    public void onResultClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_search_arrival:
                break;
            case R.id.tv_btn_search_filter:
                break;
        }
    }

    @Override
    public void showResult(List<SearchFilterModel> datas) {
        resultAdapter.setDatas(datas);
    }
}

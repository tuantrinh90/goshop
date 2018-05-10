package com.goshop.app.presentation.search;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.presentation.model.SearchFilterModel;
import com.goshop.app.presentation.shopping.ProductDetailActivity;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class SearchActivity extends BaseActivity<SearchContract.Presenter> implements
    SearchContract.View, SearchFilterAdapter.SearchFilterClickListener, SearchResultAdapter
    .OnItemClickListener {

    public static final String KEYWORDS = "keywords";

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.recyclerview_search_filter)
    RecyclerView recyclerviewSearchFilter;

    @BindView(R.id.recyclerview_search_result)
    RecyclerView recyclerviewSearchResult;

    private CompositeDisposable compositeDisposable;

    private SearchFilterAdapter filterAdapter;

    private SearchResultAdapter resultAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLisetener();
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(recyclerviewSearchResult), 200);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecyclerView();
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewSearchFilter.setLayoutManager(layoutManager);
        filterAdapter = new SearchFilterAdapter(new ArrayList<>(), this);
        recyclerviewSearchFilter.setAdapter(filterAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerviewSearchResult.setLayoutManager(gridLayoutManager);
        //TODO this part need decide
//        recyclerviewSearchResult.addItemDecoration(new CustomGridDivider(this));
        resultAdapter = new SearchResultAdapter(new ArrayList<>(), this);
        recyclerviewSearchResult.setAdapter(resultAdapter);
    }

    private void initLisetener() {
        RxTextView.editorActionEvents(csetSearch.getEditText())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(textViewEditorActionEvent -> {
                startSearchResultScreen(csetSearch.getText());
                KeyBoardUtils.hideKeyboard(csetSearch);
            });

        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxTextView.textChanges(csetSearch.getEditText())
            .skip(1)
            .throttleLast(CustomSearchEditText.FIELD_DELAY, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map(CharSequence::toString)
            .subscribe(keywords -> {
                if (TextUtils.isEmpty(keywords)) {
                    filterAdapter.setDatas(new ArrayList<>());
                    resultAdapter.setDatas(new ArrayList<>());
                } else {
                    mPresenter.searchFilter(keywords);
                }
            }));
    }

    private void startSearchResultScreen(String keyWords) {
        Intent intent = new Intent(this, SearchResultActivity.class);
        intent.putExtra(KEYWORDS, keyWords);
        startActivity(intent);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onSearchClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    @Override
    public void showSuggestResult(List<SearchFilterModel> models) {
        resultAdapter.setDatas(models);
    }

    @Override
    public void showFilterResult(List<SearchFilterModel> models) {
        filterAdapter.setDatas(models);
    }

    @Override
    public void onFilterClick(String keywords) {
        startSearchResultScreen(keywords);
    }

    @Override
    public void onClick() {
        startActivity(new Intent(this, ProductDetailActivity.class));
    }
}

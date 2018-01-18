package com.goshop.app.presentation.search;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomSearchEditText;
import com.goshop.app.utils.KeyBoardUtils;
import com.jakewharton.rxbinding2.widget.RxTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by helen on 2018/1/17.
 */

public class SearchActivity extends BaseActivity<SearchContract.Presenter> implements SearchContract.View {

    @BindView(R.id.cset_search)
    CustomSearchEditText csetSearch;

    @BindView(R.id.recyclerview_search_result)
    RecyclerView recyclerviewSearchResult;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_search;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initLisetener();
    }

    private void initLisetener() {

        RxTextView.editorActionEvents(csetSearch.getEditText())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(textViewEditorActionEvent -> KeyBoardUtils.hideKeyboard(csetSearch));

        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(RxTextView.textChanges(csetSearch.getEditText())
            .skip(1)
            .throttleLast(CustomSearchEditText.FIELD_DELAY, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .map(CharSequence::toString)
            .subscribe(s -> {

//                mPresenter.filter(s);
            }));

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
    public void showNoDataLayout() {

    }

    @Override
    public void hideNoDataLayout() {

    }

    @Override
    public void showFilterResult(String keyWords) {

    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.TermsConditionsVM;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TermsConditionsActivity extends BaseActivity<TermsConditionsContract.Presenter>
    implements TermsConditionsContract.View, TermsConditionsAdapter.OnTermsItemClickListener {

    @BindView(R.id.recyclerview_terms_conditions)
    RecyclerView recyclerviewTermsConditions;

    private TermsConditionsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO  wait for api
        mPresenter.termsConditionsRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_terms_conditions;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.terms_conditions);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewTermsConditions.setLayoutManager(layoutManager);
        adapter = new TermsConditionsAdapter(new ArrayList<>(), this);
        recyclerviewTermsConditions.setAdapter(adapter);
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    @Override
    public void showResult(List<TermsConditionsVM> termsConditionsVMS) {
        adapter.updateDatas(termsConditionsVMS);
    }

    @OnClick({R.id.imageview_left_menu})
    public void OnTermsClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onTermsClick(TermsConditionsVM termsConditionsVM) {
        Intent intent = new Intent(this, WebContentActivity.class);
        intent.putExtra(WebContentActivity.EXTRA_TYPE, termsConditionsVM.getLabel());
        intent.putExtra(WebContentActivity.EXTRA__TITLE, termsConditionsVM.getLabel());
        startActivity(intent);
    }
}

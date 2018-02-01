package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.TermsConditionsVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/29.
 */

public class TermsConditionsActivity extends BaseActivity<TermsConditionsContract.Presenter>
    implements TermsConditionsContract.View {

    @BindView(R.id.recyclerview_terms_conditions)
    RecyclerView recyclerviewTermsConditions;

    private TermsConditionsAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.termsConditionsRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_terms_conditions;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.terms_conditions);
    }

    @Override
    public void inject() {
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewTermsConditions.setLayoutManager(layoutManager);
        adapter = new TermsConditionsAdapter(new ArrayList<>());
        recyclerviewTermsConditions.setAdapter(adapter);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
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
}

package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.FAQVM;

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
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class FAQActivity extends BaseActivity<FAQContract.Presenter> implements FAQContract.View,
    FAQAdapter.OnFAQItemClickListener {

    @BindView(R.id.recyclerview_faq)
    RecyclerView recyclerviewFaq;

    private FAQAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO wait for api
        mPresenter.faqRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_faq;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.faq);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewFaq.setLayoutManager(layoutManager);
        adapter = new FAQAdapter(new ArrayList<>());
        adapter.setOnFAQItemClickListener(this);
        recyclerviewFaq.setAdapter(adapter);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void showResult(List<FAQVM> faqvms) {
        adapter.updateDatas(faqvms);
    }

    @OnClick({R.id.imageview_left_menu})
    public void OnFAQClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(FAQVM faqvm) {
        gotoInfoDetails(faqvm.getLabel());
    }

    private void gotoInfoDetails(String title) {
        Intent intent = new Intent(this, WebContentActivity.class);
        intent.putExtra(WebContentActivity.EXTRA__LINK, title);
        intent.putExtra(WebContentActivity.EXTRA__TITLE, title);
        intent.putExtra(WebContentActivity.EXTRA_TYPE, title);
        startActivity(intent);
    }
}

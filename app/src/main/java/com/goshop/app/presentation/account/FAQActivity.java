package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.FAQVM;

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

public class FAQActivity extends BaseActivity<FAQContract.Presenter> implements FAQContract.View {

    @BindView(R.id.recyclerview_faq)
    RecyclerView recyclerviewFaq;

    private FAQAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.faqRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_faq;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.faq);
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
        recyclerviewFaq.setLayoutManager(layoutManager);
        adapter = new FAQAdapter(new ArrayList<>());
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
}

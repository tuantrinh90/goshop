package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.HelpSupportModel;

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

public class HelpSupportActivity extends BaseActivity<HelpSupportContract.Presenter> implements
    HelpSupportContract.View {

    @BindView(R.id.recyclerview_help)
    RecyclerView recyclerviewHelp;

    private HelpSupportAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen)wait for api
        mPresenter.helpSupportRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_help_support;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.help_support);
    }

    @Override
    public void inject() {
        hideRightMenu();
        initRecyclerView();
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewHelp.setLayoutManager(layoutManager);
        adapter = new HelpSupportAdapter(new ArrayList<>());
        recyclerviewHelp.setAdapter(adapter);
    }

    @Override
    public void showResult(List<HelpSupportModel> helpSupportModels) {
        adapter.updateDatas(helpSupportModels);
    }

    @OnClick({R.id.imageview_left_menu})
    public void OnHelpClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

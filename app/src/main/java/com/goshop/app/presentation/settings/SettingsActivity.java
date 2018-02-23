package com.goshop.app.presentation.settings;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.model.SettingsModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class SettingsActivity extends BaseActivity<SettingsContract.Presenter> implements
    SettingsContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_setting)
    RecyclerView recyclerviewSetting;

    private SettingsAdapter settingsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getSettingsDetail();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_settings;
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageviewLeftMenu.setOnClickListener(v -> finish());
        initRecyclerview();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.settings);
    }

    private void initRecyclerview() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewSetting.setLayoutManager(layoutManager);
        settingsAdapter = new SettingsAdapter(new ArrayList<>());
        recyclerviewSetting.setAdapter(settingsAdapter);
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void showSettingView(List<SettingsModel> settingsModelse) {
        settingsAdapter.setUpdateDatas(settingsModelse);
    }

    @Override
    public void startChangePasswordScreen() {
        startActivity(new Intent(this, ChangePasswordActivity.class));
    }


}

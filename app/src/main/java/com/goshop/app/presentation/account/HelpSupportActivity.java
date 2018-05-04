package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.model.HelpSupportContentVM;
import com.goshop.app.presentation.model.HelpSupportModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class HelpSupportActivity extends BaseDrawerActivity<HelpSupportContract.Presenter>
    implements
    HelpSupportContract.View, HelpSupportAdapter.OnSupportItemClickListener {

    public static final String TYPE_FAQ = "FAQ";

    public static final String TYPE_TERMS_CONDITIONS = "Terms & Conditions";

    public static final String TYPE_CONTACT_US = "Contact Us";

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_help)
    RecyclerView recyclerviewHelp;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private HelpSupportAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    private void initData() {
        mPresenter.helpSupportRequest();
    }


    @Override
    public int getContentView() {
        return R.layout.activity_help_support;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_HELP_AND_SUPPORT);
        setContentView(getContentView());
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewHelp.setLayoutManager(layoutManager);
        adapter = new HelpSupportAdapter(new ArrayList<>());
        adapter.setOnItemClickListener(this);
        recyclerviewHelp.setAdapter(adapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.help_support);
    }

    public void showResult(List<HelpSupportModel> helpSupportModels) {
        adapter.updateDatas(helpSupportModels);
    }

    public void startFAQ() {
        startActivity(new Intent(this, FAQActivity.class));
    }

    public void startContactUs() {
        startActivity(new Intent(this, ContactUsActivity.class));
    }

    public void startTermsAndConditions() {
        startActivity(new Intent(this, TermsConditionsActivity.class));
    }

    @Override
    public void onHelpSupportRequestSuccess(ArrayList<HelpSupportModel> helpSupportResponse) {
        adapter.updateDatas(helpSupportResponse);
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewHelp, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String message) {
        PopWindowUtil.showRequestMessagePop(recyclerviewHelp, message);

    }

    @OnClick({R.id.imageview_left_menu})
    public void OnHelpClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onItemClick(HelpSupportContentVM helpSupportContentVM) {
        switch (helpSupportContentVM.getLabel()) {
            case TYPE_FAQ:
                startFAQ();
                break;
            case TYPE_TERMS_CONDITIONS:
                startTermsAndConditions();
                break;
            case TYPE_CONTACT_US:
                startContactUs();
                break;
            default:
                gotoInfoDetails(helpSupportContentVM.getLink(), helpSupportContentVM.getLabel());
                break;
        }
    }

    private void gotoInfoDetails(String link, String title) {
        Intent intent = new Intent(this, WebContentActivity.class);
        intent.putExtra(WebContentActivity.EXTRA__LINK, link);
        intent.putExtra(WebContentActivity.EXTRA__TITLE, title);
        intent.putExtra(WebContentActivity.EXTRA_TYPE, title);
        startActivity(intent);
    }
}

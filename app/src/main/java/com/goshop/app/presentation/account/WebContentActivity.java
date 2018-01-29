package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomBoldTextView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/29.
 */

public class WebContentActivity extends BaseActivity<WebContentContract.Presenter> implements WebContentContract
    .View {

    public static final String CONTACT_US = "contact_us";

    public static final String CONTENT_TAG = "content";

    public static final String ECMC = "ECMC";

    @BindView(R.id.textview_toolbar_title)
    CustomBoldTextView textviewToolbarTitle;

    @BindView(R.id.wv_content)
    WebView wvContent;

    private String contentTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CONTENT_TAG.equals(CONTACT_US)) {
            textviewToolbarTitle.setText(getResources().getString(R.string.contact_us));
            mPresenter.getContactUsContent();
        } else if (CONTENT_TAG.equals(ECMC)) {
            textviewToolbarTitle.setText(getResources().getString(R.string.ecmc));
            mPresenter.getEcmcContent();
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_web_content;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.ecmc);
    }

    @Override
    public void inject() {
        initWebView();
        initDatas();
        initPresenter();
    }

    private void initWebView() {
        wvContent.setFocusable(true);
        wvContent.requestFocus();
        wvContent.getSettings().setJavaScriptEnabled(true);
        wvContent.getSettings().setAllowFileAccess(true);
        wvContent.getSettings().setPluginState(WebSettings.PluginState.ON);
        wvContent.getSettings().setSupportMultipleWindows(true);
        wvContent.setHorizontalScrollBarEnabled(false);
        wvContent.setVerticalScrollBarEnabled(false);
        wvContent.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wvContent.getSettings().setDomStorageEnabled(true);
        wvContent.getSettings().setDatabaseEnabled(true);
    }

    private void initDatas() {
        contentTag = getIntent().getStringExtra(CONTENT_TAG);
        //TODO(helen) wait for real data
        contentTag = ECMC;
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public void requestResult(String url) {
        wvContent.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (wvContent != null) {
            wvContent.destroy();
            wvContent = null;
        }
    }
}

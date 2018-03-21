package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class WebContentActivity extends BaseActivity<WebContentContract.Presenter> implements
    WebContentContract
    .View {

    public static final String CONTACT_US = "contact_us";

    public static final String CONTENT_TAG = "content";

    public static final String ECMC = "ECMC";

    @BindView(R.id.textview_toolbar_title)
    RobotoMediumTextView textviewToolbarTitle;

    @BindView(R.id.wv_content)
    WebView wvContent;

    @BindView(R.id.progressbar_content)
    ProgressBar progressBarContent;

    private String contentTag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (contentTag.equals(CONTACT_US)) {
            textviewToolbarTitle.setText(getResources().getString(R.string.contact_us));
            mPresenter.getContactUsContent();
        } else if (contentTag.equals(ECMC)) {
            textviewToolbarTitle.setText(getResources().getString(R.string.ecmc));
            mPresenter.getEcmcContent();
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_web_content;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initWebView();
        initDatas();
        initPresenter();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.ecmc);
    }

    @SuppressLint("SetJavaScriptEnabled")
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

        wvContent.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBarContent.setVisibility(View.GONE);
                } else {
                    if(View.GONE == progressBarContent.getVisibility()) {
                        progressBarContent.setVisibility(View.VISIBLE);
                    }
                    progressBarContent.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    private void initDatas() {
        contentTag = getIntent().getStringExtra(CONTENT_TAG);
        //TODO  wait for real data
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
        Log.d("WebContentActivity", "url:" + url);
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

    @OnClick({R.id.imageview_left_menu})
    public void OnWebClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

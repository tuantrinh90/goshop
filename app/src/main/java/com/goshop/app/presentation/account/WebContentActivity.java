package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.utils.PopWindowUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
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
    WebContentContract.View {

    public static final String EXTRA_TYPE = "content_type";

    public static final String EXTRA__LINK = "content_link";

    public static final String EXTRA__TITLE = "content_title";

    @BindView(R.id.textview_toolbar_title)
    RobotoMediumTextView textviewToolbarTitle;

    @BindView(R.id.wv_content)
    WebView wvContent;

    @BindView(R.id.progressbar_content)
    ProgressBar progressBarContent;

    private String title;

    private String link;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
        // TODO: 2018/4/26 this need delete later
        new Handler().postDelayed(() -> PopWindowUtil.showNoApiPop(wvContent), 200);
    }

    private void initView() {
        hideRightMenu();
        initWebView();
    }

    private void initData() {
        link = getIntent().getStringExtra(EXTRA__LINK);
        title = getIntent().getStringExtra(EXTRA__TITLE);
        textviewToolbarTitle.setText(title);

    }

    @Override
    public int getContentView() {
        return R.layout.activity_web_content;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return "";
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
                    if (View.GONE == progressBarContent.getVisibility()) {
                        progressBarContent.setVisibility(View.VISIBLE);
                    }
                    progressBarContent.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        // TODO: 2018/4/24 need real url
        wvContent.loadUrl("https://app.zeplin.io/welcome");
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

    @OnClick({R.id.imageview_left_menu})
    public void OnWebClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }
}

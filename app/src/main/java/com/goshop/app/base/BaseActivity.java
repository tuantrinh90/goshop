package com.goshop.app.base;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.utils.StatusBarUtils;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressWarnings("ALL")
public abstract class BaseActivity<T extends BasePresenter> extends RxLifecycleActivity
    implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Inject
    public T mPresenter;

    @BindView(R.id.imageview_left_menu)
    @Nullable
    ImageView ivLeftMenu;

    @BindView(R.id.imageview_right_menu)
    @Nullable
    ImageView ivRightMenu;

    @BindView(R.id.textview_toolbar_title)
    @Nullable
    RobotoMediumTextView titleToolbar;

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getContentView());
        ButterKnife.bind(this);
        inject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        setToolbar();
        setStatusBar();
    }

    public abstract int getContentView();

    public abstract void inject();

    private void setToolbar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setTitle("");
            actionBar.setDisplayShowTitleEnabled(false);
        }
        if (titleToolbar != null) {
            titleToolbar.setText(getScreenTitle());
        }
    }

    private void setStatusBar() {
        StatusBarUtils.setStatusBarColor(this, R.color.color_greyish_brown);
    }

    public abstract String getScreenTitle();

    public void setToolbarTitle(String title) {
        titleToolbar.setText(title);
    }

    public void showLoadingBar() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this, R.style.ProgressDialogTheme);
            progressDialog.setCancelable(false);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        }
        progressDialog.show();
    }

    public void hideLoadingBar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void hideRightMenu() {
        if (ivRightMenu != null) {
            ivRightMenu.setVisibility(View.GONE);
        }
    }

    public void hideLeftMenu() {
        if (ivLeftMenu != null) {
            ivLeftMenu.setVisibility(View.GONE);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void updateLayoutStatus(View layout, boolean isShow) {
        layout.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }
}

package com.goshop.app.base;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
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
public abstract class BaseActivity<T extends BasePresenter> extends RxLifecycleActivity implements BaseView {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    @Nullable
    Toolbar toolbar;

    @BindView(R.id.textview_toolbar_title)
    @Nullable
    CustomBoldTextView titleToolbar;

    @BindView(R.id.imageview_left_menu)
    @Nullable
    ImageView tvLeftMenu;

    @BindView(R.id.imageview_right_menu)
    @Nullable
    ImageView ivRightMenu;

    @Inject
    public T mPresenter;

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

    public abstract String getScreenTitle();

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

    public void setToolbarTitle(String title){
        titleToolbar.setText(title);
    }

    private void setStatusBar() {
        StatusBarUtils.setStatusBarColor(this, R.color.colorPrimaryDark);
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

    public void setToolbarTextImageTitleOnly() {
        if(ivRightMenu!=null){
            ivRightMenu.setVisibility(View.GONE);
        }
        if(tvLeftMenu!=null) {
            tvLeftMenu.setVisibility(View.GONE);
        }
    }

    public void hideRightMenu() {
        if(ivRightMenu!=null){
            ivRightMenu.setVisibility(View.GONE);
        }
    }

    public Toolbar getToolbar(){
        return toolbar;
    }
}

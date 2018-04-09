package com.goshop.app.base;

import com.goshop.app.R;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

public class BaseDrawerActivity<T extends BasePresenter> extends BaseActivity<T> implements
    MenuAdapter.OnSlideMenuItemClickListener {

    private DrawerLayout drawerLayout;

    private FrameLayout flContentLayout;

    private RecyclerView rvDrawerList;

    private int contentResId;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private MenuUtil menuUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return contentResId;
    }

    @Override
    public void inject() {

    }

    @Override
    public String getScreenTitle() {
        return "";
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        drawerLayout = (DrawerLayout) getLayoutInflater()
            .inflate(R.layout.activity_base_drawer, null);
        flContentLayout = drawerLayout.findViewById(R.id.content_frame);
        rvDrawerList = drawerLayout.findViewById(R.id.rv_menu);
        getLayoutInflater().inflate(layoutResId, flContentLayout, true);
        this.contentResId = layoutResId;
        initMenuUtil();
        initDrawerList();
    }

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initDrawerList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDrawerList.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(
            isLogin ? menuUtil.getLoginMenuModel() : menuUtil.getUnLoginMenuModel());
        rvDrawerList.setAdapter(menuAdapter);
        menuAdapter.setOnSlideMenuItemClickListener(this);
        menuAdapter.updateLoginState(isLogin);
    }

    @Override
    public void onHeaderUserClick(int position) {

    }

    @Override
    public void onHeaderLoginClick(int position) {

    }

    @Override
    public void onItemClick(int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (currentMenu != position) {
            menuUtil.startNewScreen(position);
        }
    }
}

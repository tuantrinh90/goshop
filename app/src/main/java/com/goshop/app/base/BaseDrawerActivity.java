package com.goshop.app.base;

import com.goshop.app.R;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.ButterKnife;

public class BaseDrawerActivity<T extends BasePresenter> extends BaseActivity<T> implements
    MenuAdapter.OnSlideMenuItemClickListener {

    private static final String TAG = "BaseDrawerActivity";

    private DrawerLayout drawerLayout;

    private FrameLayout flContentLayout;

    private RecyclerView rvDrawerList;

    private boolean isLogin = true;

    private MenuAdapter menuAdapter;

    private MenuUtil menuUtil;

    private String currentMenuType=MenuUtil.MENU_TYPE_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getCurrentMenuType() {
        return currentMenuType;
    }

    public void setCurrentMenuType(String currentMenuType) {
        this.currentMenuType = currentMenuType;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        drawerLayout = (DrawerLayout) getLayoutInflater()
            .inflate(R.layout.activity_base_drawer, null);
        flContentLayout = drawerLayout.findViewById(R.id.fl_content);
        rvDrawerList = drawerLayout.findViewById(R.id.rv_menu);
        initMenuUtil();
        initDrawerList();
        getLayoutInflater().inflate(layoutResId, flContentLayout, true);
        super.setContentView(drawerLayout);
        ButterKnife.bind(this);
    }

    @Override
    public int getContentView() {
        return 0;
    }

    @Override
    public void inject() {
        //There is no need to implement it now.
    }

    @Override
    public String getScreenTitle() {
        return "";
    }

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, isLogin, drawerLayout);
    }

    private void initDrawerList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvDrawerList.setLayoutManager(layoutManager);
        menuAdapter = new MenuAdapter(menuUtil.getDrawerListModel());
        if (!TextUtils.isEmpty(currentMenuType)) {
            menuAdapter.updateSelection(currentMenuType);
        }
        rvDrawerList.setAdapter(menuAdapter);
        menuAdapter.setOnSlideMenuItemClickListener(this);
    }

    public void updateDrawerModel() {
        menuUtil.updateLoginState(isLogin);
        menuAdapter.updateDrawerModel(menuUtil.getDrawerListModel());
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onItemClick(MenuModel itemVM, int position) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (!currentMenuType.equals(itemVM.getMenuType())) {
            menuUtil.startNextScreen(itemVM.getMenuType());
        }
    }

    public void closeDrawerLayout() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void openDrawerLayout() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}

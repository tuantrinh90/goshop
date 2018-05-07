package com.goshop.app.base;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.UserHelper;
import com.goshop.app.widget.adapter.MenuAdapter;

import android.support.annotation.LayoutRes;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.FrameLayout;

import butterknife.ButterKnife;

public abstract class BaseDrawerActivity<T extends BasePresenter> extends BaseActivity<T> implements
    MenuAdapter.OnSlideMenuItemClickListener {

    private static final String TAG = "BaseDrawerActivity";

    public static final String LOGIN_STATE = "login_state";

    private DrawerLayout drawerLayout;

    private FrameLayout flContentLayout;

    private RecyclerView rvDrawerList;

    public static boolean isLogin = false;

    private MenuAdapter menuAdapter;

    private MenuUtil menuUtil;

    private String currentMenuType = MenuUtil.MENU_TYPE_HOME;

    public String entranceType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initIntent();
        initToolbar();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(LOGIN_STATE, UserHelper.isLogin());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            isLogin = savedInstanceState.getBoolean(LOGIN_STATE);
        }
    }

    private void initIntent() {
        entranceType = getIntent().getStringExtra(MenuUtil.EXTRA_ENTRANCE);
    }

    private void initToolbar() {
        hideRightMenu();
        if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
            ivLeftMenu.setImageResource(R.drawable.ic_menu);
            unlockDrawerLayout();
        } else {
            ivLeftMenu.setImageResource(R.drawable.ic_icon_back);
            lockDrawerLayout();
        }
    }

    public void setCurrentMenuType(String currentMenuType) {
        this.currentMenuType = currentMenuType;
        menuUtil.setCurrentMenuType(currentMenuType);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        drawerLayout = (DrawerLayout) getLayoutInflater()
            .inflate(R.layout.activity_base_drawer, null);
        flContentLayout = drawerLayout.findViewById(R.id.fl_main_content);
        rvDrawerList = drawerLayout.findViewById(R.id.rv_menu);
        initMenuUtil();
        initDrawerList();
        getLayoutInflater().inflate(layoutResId, flContentLayout, true);
        super.setContentView(drawerLayout);
        ButterKnife.bind(this);
        RobotoMediumTextView titleToolbar = drawerLayout.findViewById(R.id.textview_toolbar_title);
        if (titleToolbar != null) {
            titleToolbar.setText(getScreenTitle());
        }
    }

    public abstract String getScreenTitle();

    private void initMenuUtil() {
        isLogin = UserHelper.isLogin();
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
            if (!isLogin
                && currentMenuType.equals(MenuUtil.MENU_TYPE_HEAD_LOGIN)
                && (itemVM.getMenuType().equals(MenuUtil.MENU_TYPE_GO_LOYALTY)
                || itemVM.getMenuType().equals(MenuUtil.MENU_TYPE_SHOPPING_CART)
                || itemVM.getMenuType().equals(MenuUtil.MENU_TYPE_SETTINGS))
                ) {
                //do nothing
            } else {
                menuUtil.startNextScreen(itemVM.getMenuType());
            }
        }
    }

    public void closeDrawerLayout() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void openDrawerLayout() {
        if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
            KeyBoardUtils.hideKeyboard(this);
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    public void lockDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void unlockDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
}

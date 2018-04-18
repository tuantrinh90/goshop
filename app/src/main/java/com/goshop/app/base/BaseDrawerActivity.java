package com.goshop.app.base;

import com.goshop.app.GoShopApplication;
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
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseDrawerActivity<T extends BasePresenter> extends BaseActivity<T> implements
    MenuAdapter.OnSlideMenuItemClickListener {

    private static final String TAG = "BaseDrawerActivity";

    private DrawerLayout drawerLayout;

    private FrameLayout flContentLayout;

    private RecyclerView rvDrawerList;

    public static boolean isLogin = false;

    private MenuAdapter menuAdapter;

    private MenuUtil menuUtil;

    private String currentMenuType = MenuUtil.MENU_TYPE_HOME;

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
        RobotoMediumTextView titleToolbar = drawerLayout.findViewById(R.id.textview_toolbar_title);
        if (titleToolbar != null) {
            titleToolbar.setText(getScreenTitle());
        }
    }

    public abstract String getScreenTitle();

    private void initMenuUtil() {
        menuUtil = new MenuUtil(this, UserHelper.isLogin(), drawerLayout);
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
}

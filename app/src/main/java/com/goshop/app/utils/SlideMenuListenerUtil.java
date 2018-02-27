package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.login.TestMenuActivity;
import com.goshop.app.presentation.myorder.MyOrderListActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

public class SlideMenuListenerUtil {

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    OnStartNextScreenListener nextScreenListener;

    private Activity activity;

    private int currentMenuId;

    private boolean drawerHasSelect = false;

    private int selectMenuId;

    public SlideMenuListenerUtil(Activity activity, int currentMenuId,
        OnStartNextScreenListener nextScreenListener) {
        this.currentMenuId = currentMenuId;
        this.activity = activity;
        this.nextScreenListener = nextScreenListener;
    }

    public void setSelectMenuId(int menuId) {
        this.selectMenuId = menuId;
    }

    public void setDrawerHasSelect(boolean hasSelect) {
        this.drawerHasSelect = hasSelect;
    }

    public void drawerLisenter(DrawerLayout drawerLayout) {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Intent intent = null;
                if (drawerHasSelect && currentMenuId != selectMenuId) {
                    switch (selectMenuId) {
                        case R.id.tv_slide_sign_up:
                            intent = new Intent(activity, LoginActivity.class);
                            break;
                        case R.id.slide_menu_home:
                            intent = new Intent(activity, MainPageActivity.class);
                            break;
                        case R.id.ll_slide_user_info:
                            intent = new Intent(activity, EditProfileActivity.class);
                            break;
                        case R.id.slide_menu_categories:
                            intent = new Intent(activity, CategoryActivity.class);
                            break;
                        case R.id.slide_menu_go_loyalty:
                            //TODO  this part need to decide
                            break;
                        case R.id.slide_menu_cart:
                            intent = new Intent(activity, ShoppingCartActivity.class);
                            break;
                        case R.id.slide_menu_wishlist:
                            //TODO  this part need to decide
                            break;
                        case R.id.slide_menu_orders:
                            intent = new Intent(activity,
                                MyOrderListActivity.class);
                            break;
                        case R.id.slide_menu_rewards:
                            //TODO  this part need to decide
                            break;
                        case R.id.slide_menu_notifications:
                            intent = new Intent(activity, NotificationActivity.class);
                            break;
                        case R.id.slide_menu_help:
                            intent = new Intent(activity, HelpSupportActivity.class);
                            break;
                        case R.id.slide_menu_setting:
                            intent = new Intent(activity, SettingsActivity.class);
                            break;
                        case R.id.slide_menu_others:
                            intent = new Intent(activity, TestMenuActivity.class);
                            break;
                    }
                }

                drawerHasSelect = false;
                if (intent != null) {
                    intent.putExtra(MENU_KEY, MENU_VALUE);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.slide_menu_in,
                        R.anim.slide_menu_out);
                    //todo this may use later please keep it
//                    nextScreenListener.startNextScreen(intent);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    public interface OnStartNextScreenListener {

        void startNextScreen(Intent intent);
    }
}

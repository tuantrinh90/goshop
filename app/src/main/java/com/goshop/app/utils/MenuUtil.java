package com.goshop.app.utils;

import com.goshop.app.R;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.MyAccountLandingActivity;
import com.goshop.app.presentation.account.MyWishlistActivity;
import com.goshop.app.presentation.account.NotificationActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.goloyalty.GoLoyaltyActivity;
import com.goshop.app.presentation.goloyalty.MyRewardsActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.login.LoginActivity;
import com.goshop.app.presentation.model.MenuHeaderVM;
import com.goshop.app.presentation.model.MenuItemVM;
import com.goshop.app.presentation.model.MenuModel;
import com.goshop.app.presentation.myorder.MyOrdersActivity;
import com.goshop.app.presentation.settings.SettingsActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import java.util.ArrayList;
import java.util.List;

public class MenuUtil {

    public final static int LOGIN_ACCOUNT = 0;

    public final static String MENU_TYPE_HEAD_ACCOUNT = "account";

    public final static String MENU_TYPE_HEAD_LOGIN = "login";

    public final static int LOGIN_MENU_HOME = 1;

    public final static String MENU_TYPE_HOME = "home";

    public final static int LOGIN_MENU_CATEGORIES = 2;

    public final static String MENU_TYPE_CATEGORY = "category";

    public final static int LOGIN_MENU_GO_LOYALTY = 3;

    public final static String MENU_TYPE_GO_LOYALTY = "goLoyalty";

    public final static int LOGIN_MENU_SHOPPING_CART = 4;

    public final static String MENU_TYPE_SHOPPING_CART = "shoppingCart";

    public final static int LOGIN_MENU_MY_WISHLIST = 5;

    public final static String MENU_TYPE_MY_WISHLIST = "myWishlist";

    public final static int LOGIN_MENU_MY_ORDERS = 6;

    public final static String MENU_TYPE_MY_ORDERS = "myOrders";

    public final static int LOGIN_MENU_MY_REWARDS = 7;

    public final static String MENU_TYPE_MY_REWARDS = "myRewards";

    public final static int LOGIN_MENU_NOTIFICATIONS = 8;

    public final static String MENU_TYPE_NOTIFICATIONS = "notifications";

    public final static int LOGIN_MENU_HELP = 10;

    public final static String MENU_TYPE_HELP_AND_SUPPORT = "helpAndSupport";

    public final static int LOGIN_MENU_SETTING = 11;

    public final static String MENU_TYPE_SETTINGS = "settings";

    public final static int LOGIN_MENU_OTHER = 12;

    public final static String MENU_TYPE_OTHER = "other ";

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    public final static int UNLOGIN_LOGIN = 0;

    public final static int UNLOGIN_MENU_CATEGORIES = 2;

    public final static int UNLOGIN_MENU_GO_LOYALTY = 3;

    public final static int UNLOGIN_MENU_HELP = 7;

    public final static int UNLOGIN_MENU_HOME = 1;

    public final static int UNLOGIN_MENU_NOTIFICATIONS = 5;

    public final static int UNLOGIN_MENU_OTHER = 9;

    public final static int UNLOGIN_MENU_SETTINGS = 8;

    public final static int UNLOGIN_MENU_SHOPPING_CART = 4;

    private Activity activity;

    private DrawerLayout drawerLayout;

    private boolean isLogin;

    private String currentMenuType=MENU_TYPE_HOME;

    public MenuUtil(Activity activity, boolean loginState, DrawerLayout drawerLayout) {
        this.activity = activity;
        this.isLogin = loginState;
        this.drawerLayout = drawerLayout;
    }

    public void updateLoginState(boolean loginState) {
        this.isLogin = loginState;
    }

    public List<MenuModel> getLoginMenuModel() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.add(new MenuHeaderVM());
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_home,
            activity.getResources().getString(R.string.home)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_categories,
            activity.getResources().getString(R.string.categories)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_loyalty,
            activity.getResources().getString(R.string.go_loyalty)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_cart,
            activity.getResources().getString(R.string.shopping_cart)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_wishlist,
            activity.getResources().getString(R.string.my_wishlist)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_orders,
            activity.getResources().getString(R.string.my_orders)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_rewards,
            activity.getResources().getString(R.string.my_rewards)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_notification,
            activity.getResources().getString(R.string.notifications)));
        menuModels.add(new MenuModel(MenuModel.MENU_DIVIDER));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.help_support)));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.settings)));
        return menuModels;
    }

    public List<MenuModel> getDrawerListModel() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.clear();
        if (isLogin) {
            menuModels.add(new MenuHeaderVM(MENU_TYPE_HEAD_ACCOUNT));
        }else{
            menuModels.add(new MenuHeaderVM(MENU_TYPE_HEAD_LOGIN));
        }
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_home,
            activity.getResources().getString(R.string.home),MENU_TYPE_HOME));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_categories,
            activity.getResources().getString(R.string.categories),MENU_TYPE_CATEGORY));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_loyalty,
            activity.getResources().getString(R.string.go_loyalty),MENU_TYPE_GO_LOYALTY));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_cart,
            activity.getResources().getString(R.string.shopping_cart),MENU_TYPE_SHOPPING_CART));
        if (isLogin) {
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_wishlist,
                activity.getResources().getString(R.string.my_wishlist),MENU_TYPE_MY_WISHLIST));
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_orders,
                activity.getResources().getString(R.string.my_orders),MENU_TYPE_MY_ORDERS));
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_rewards,
                activity.getResources().getString(R.string.my_rewards),MENU_TYPE_MY_REWARDS));
        }
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_notification,
            activity.getResources().getString(R.string.notifications),MENU_TYPE_NOTIFICATIONS));
        menuModels.add(new MenuModel(MenuModel.MENU_DIVIDER));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.help_support),MENU_TYPE_HELP_AND_SUPPORT));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.settings),MENU_TYPE_SETTINGS));
        return menuModels;
    }

    public List<MenuModel> getUnLoginMenuModel() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.add(new MenuHeaderVM());
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_home,
            activity.getResources().getString(R.string.home)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_categories,
            activity.getResources().getString(R.string.categories)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_loyalty,
            activity.getResources().getString(R.string.go_loyalty)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_cart,
            activity.getResources().getString(R.string.shopping_cart)));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_notification,
            activity.getResources().getString(R.string.notifications)));
        menuModels.add(new MenuModel(MenuModel.MENU_DIVIDER));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.help_support)));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.settings)));
        return menuModels;
    }

    public void startNewScreen(int position) {
        Intent intent = null;
        if (isLogin) {
            switch (position) {
                case LOGIN_ACCOUNT:
                    intent = new Intent(activity, MyAccountLandingActivity.class);
                    break;
                case LOGIN_MENU_HOME:
                    intent = new Intent(activity, MainPageActivity.class);
                    break;
                case LOGIN_MENU_CATEGORIES:
                    intent = new Intent(activity, CategoryActivity.class);
                    break;
                case LOGIN_MENU_GO_LOYALTY:
                    intent = new Intent(activity, GoLoyaltyActivity.class);
                    break;
                case LOGIN_MENU_SHOPPING_CART:
                    intent = new Intent(activity, ShoppingCartActivity.class);
                    break;
                case LOGIN_MENU_MY_WISHLIST:
                    intent = new Intent(activity, MyWishlistActivity.class);
                    break;
                case LOGIN_MENU_MY_ORDERS:
                    intent = new Intent(activity, MyOrdersActivity.class);
                    break;
                case LOGIN_MENU_MY_REWARDS:
                    intent = new Intent(activity, MyRewardsActivity.class);
                    break;
                case LOGIN_MENU_NOTIFICATIONS:
                    intent = new Intent(activity, NotificationActivity.class);
                    break;
                case LOGIN_MENU_HELP:
                    intent = new Intent(activity, HelpSupportActivity.class);
                    break;
                case LOGIN_MENU_SETTING:
                    intent = new Intent(activity, SettingsActivity.class);
                    break;
            }
        } else {
            switch (position) {
                case UNLOGIN_LOGIN:
                    intent = new Intent(activity, LoginActivity.class);
                    break;
                case UNLOGIN_MENU_HOME:
                    intent = new Intent(activity, MainPageActivity.class);
                    break;
                case UNLOGIN_MENU_CATEGORIES:
                    intent = new Intent(activity, CategoryActivity.class);
                    break;
                case UNLOGIN_MENU_GO_LOYALTY:
                    intent = new Intent(activity, GoLoyaltyActivity.class);
                    break;
                case UNLOGIN_MENU_SHOPPING_CART:
                    intent = new Intent(activity, ShoppingCartActivity.class);
                    break;
                case UNLOGIN_MENU_NOTIFICATIONS:
                    intent = new Intent(activity, NotificationActivity.class);
                    break;
                case UNLOGIN_MENU_HELP:
                    intent = new Intent(activity, HelpSupportActivity.class);
                    break;
                case UNLOGIN_MENU_SETTINGS:
                    intent = new Intent(activity, SettingsActivity.class);
                    break;
            }
        }

        if (intent != null) {
            intent.putExtra(MENU_KEY, MENU_VALUE);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_menu_in,
                R.anim.slide_menu_out);
            activity.finish();
        }
    }

    public void startNextScreen(String menuType) {
        Intent intent = null;
        switch (menuType) {
            case MENU_TYPE_HEAD_LOGIN:
                intent = new Intent(activity, LoginActivity.class);
                break;
            case MENU_TYPE_HEAD_ACCOUNT:
                intent = new Intent(activity, MyAccountLandingActivity.class);
                break;
            case MENU_TYPE_HOME:
                intent = new Intent(activity, MainPageActivity.class);
                break;
            case MENU_TYPE_CATEGORY:
                intent = new Intent(activity, CategoryActivity.class);
                break;
            case MENU_TYPE_GO_LOYALTY:
                intent = new Intent(activity, GoLoyaltyActivity.class);
                break;
            case MENU_TYPE_SHOPPING_CART:
                intent = new Intent(activity, ShoppingCartActivity.class);
                intent.putExtra(ShoppingCartActivity.EXTRA_ENTRANCE,
                    ShoppingCartActivity.TYPE_ENTRANCE_DRAWER);
                break;
            case MENU_TYPE_MY_WISHLIST:
                intent = new Intent(activity, MyWishlistActivity.class);
                break;
            case MENU_TYPE_MY_ORDERS:
                intent = new Intent(activity, MyOrdersActivity.class);
                break;
            case MENU_TYPE_MY_REWARDS:
                intent = new Intent(activity, MyRewardsActivity.class);
                break;
            case MENU_TYPE_NOTIFICATIONS:
                intent = new Intent(activity, NotificationActivity.class);
                break;
            case MENU_TYPE_HELP_AND_SUPPORT:
                intent = new Intent(activity, HelpSupportActivity.class);
                break;
            case MENU_TYPE_SETTINGS:
                intent = new Intent(activity, SettingsActivity.class);
                break;
        }

        if (intent != null) {
            currentMenuType=menuType;
            intent.putExtra(MENU_KEY, MENU_VALUE);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_menu_in,
                R.anim.slide_menu_out);
            activity.finish();
        }
    }

    public void lockDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    public void unlockDrawerLayout() {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public String getCurrentMenuType() {
        return currentMenuType;
    }
}

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

    public final static String MENU_TYPE_HEAD_ACCOUNT = "account";

    public final static String MENU_TYPE_HEAD_LOGIN = "login";

    public final static String MENU_TYPE_HOME = "home";

    public final static String MENU_TYPE_CATEGORY = "category";

    public final static String MENU_TYPE_GO_LOYALTY = "goLoyalty";

    public final static String MENU_TYPE_SHOPPING_CART = "shoppingCart";

    public final static String MENU_TYPE_MY_WISHLIST = "myWishlist";

    public final static String MENU_TYPE_MY_ORDERS = "myOrders";

    public final static String MENU_TYPE_MY_REWARDS = "myRewards";

    public final static String MENU_TYPE_NOTIFICATIONS = "notifications";

    public final static String MENU_TYPE_HELP_AND_SUPPORT = "helpAndSupport";

    public final static String MENU_TYPE_SETTINGS = "settings";

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    private Activity activity;

    private DrawerLayout drawerLayout;

    private boolean isLogin;

    private String currentMenuType = MENU_TYPE_HOME;

    public MenuUtil(Activity activity, boolean loginState, DrawerLayout drawerLayout) {
        this.activity = activity;
        this.isLogin = loginState;
        this.drawerLayout = drawerLayout;
    }

    public void setCurrentMenuType(String currentMenuType) {
        this.currentMenuType = currentMenuType;
    }

    public void updateLoginState(boolean loginState) {
        this.isLogin = loginState;
    }

    public List<MenuModel> getDrawerListModel() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.clear();
        if (isLogin) {
            menuModels.add(new MenuHeaderVM(MENU_TYPE_HEAD_ACCOUNT));
        } else {
            menuModels.add(new MenuHeaderVM(MENU_TYPE_HEAD_LOGIN));
        }
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_home,
            activity.getResources().getString(R.string.home), MENU_TYPE_HOME));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_categories,
            activity.getResources().getString(R.string.categories), MENU_TYPE_CATEGORY));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_loyalty,
            activity.getResources().getString(R.string.go_loyalty), MENU_TYPE_GO_LOYALTY));
        menuModels.add(new MenuItemVM(R.drawable.selector_slide_cart,
            activity.getResources().getString(R.string.shopping_cart), MENU_TYPE_SHOPPING_CART));
        if (isLogin) {
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_wishlist,
                activity.getResources().getString(R.string.my_wishlist), MENU_TYPE_MY_WISHLIST));
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_orders,
                activity.getResources().getString(R.string.my_orders), MENU_TYPE_MY_ORDERS));
            menuModels.add(new MenuItemVM(R.drawable.selector_slide_rewards,
                activity.getResources().getString(R.string.my_rewards), MENU_TYPE_MY_REWARDS));
        }
        menuModels.add(new MenuModel(MenuModel.MENU_DIVIDER));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.help_support),
            MENU_TYPE_HELP_AND_SUPPORT));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.settings),
            MENU_TYPE_SETTINGS));

        return menuModels;
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
                if (UserHelper.isLogin()) {
                    intent = new Intent(activity, GoLoyaltyActivity.class);
                } else {
                    UserHelper.goToLogin(activity);
                }
                break;
            case MENU_TYPE_SHOPPING_CART:
                if (UserHelper.isLogin()) {
                    intent = new Intent(activity, ShoppingCartActivity.class);
                    intent.putExtra(ShoppingCartActivity.EXTRA_ENTRANCE,
                        ShoppingCartActivity.TYPE_ENTRANCE_DRAWER);
                } else {
                    UserHelper.goToLogin(activity);
                }
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
                if (UserHelper.isLogin()) {
                    intent = new Intent(activity, SettingsActivity.class);
                } else {
                    UserHelper.goToLogin(activity);
                }
                break;
        }

        if (intent != null) {
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

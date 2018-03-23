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
import com.goshop.app.presentation.login.TestMenuActivity;
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

    public final static String MENU_KEY = "menu";

    public final static String MENU_VALUE = "slideMenu";

    public final static int ACCOUNT = 0;
    public final static int MENU_HOME = 1;
    public final static int MENU_CATEGORIES = 2;
    public final static int MENU_GO_LOYALTY = 3;
    public final static int MENU_SHOPPING_CART = 4;
    public final static int MENU_MY_WISHLIST = 5;
    public final static int MENU_MY_ORDERS = 6;
    public final static int MENU_MY_REWARDS = 7;
    public final static int MENU_NOTIFICATIONS= 8;
    public final static int MENU_HELP = 9;
    public final static int MENU_SETTING = 10;
    public final static int MENU_OTHER = 11;
    public final static int LOGIN = 12;

    private DrawerLayout drawerLayout;

    private Activity activity;

    public MenuUtil(Activity activity) {
        this.activity = activity;
    }

    public List<MenuModel> getMenuModel() {
        List<MenuModel> menuModels = new ArrayList<>();
        menuModels.add(new MenuModel(MenuModel.MENU_HEADER));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_home,
            activity.getResources().getString(R.string.home)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_categories,
            activity.getResources().getString(R.string.categories)));
        menuModels.add(new MenuItemVM(R.drawable.ic_slidemenu_go_loyalty_nor,
            activity.getResources().getString(R.string.go_loyalty)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_shopping_cart,
            activity.getResources().getString(R.string.shopping_cart)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_my_wishlist,
            activity.getResources().getString(R.string.my_wishlist)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_my_orders,
            activity.getResources().getString(R.string.my_orders)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_rewards,
            activity.getResources().getString(R.string.my_rewards)));
        menuModels.add(new MenuItemVM(R.drawable.ic_icon_notifaications,
            activity.getResources().getString(R.string.notifications)));
        menuModels.add(new MenuModel(MenuModel.MENU_DIVIDER));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.help_support)));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.settings)));
        menuModels.add(new MenuItemVM(0, activity.getResources().getString(R.string.other_page)));
        return menuModels;
    }

    public void startNewScreen(int position){
        Intent intent = null;
            switch (position) {
                case LOGIN:
                    intent = new Intent(activity, LoginActivity.class);
                    break;
                case MENU_HOME:
                    intent = new Intent(activity, MainPageActivity.class);
                    break;
                case ACCOUNT:
                    intent = new Intent(activity, MyAccountLandingActivity.class);
                    break;
                case MENU_CATEGORIES:
                    intent = new Intent(activity, CategoryActivity.class);
                    break;
                case MENU_GO_LOYALTY:
                    intent = new Intent(activity, GoLoyaltyActivity.class);
                    break;
                case MENU_SHOPPING_CART:
                    intent = new Intent(activity, ShoppingCartActivity.class);
                    break;
                case MENU_MY_WISHLIST:
                    intent = new Intent(activity, MyWishlistActivity.class);
                    break;
                case MENU_MY_ORDERS:
                    intent = new Intent(activity, MyOrdersActivity.class);
                    break;
                case MENU_MY_REWARDS:
                    intent = new Intent(activity, MyRewardsActivity.class);
                    break;
                case MENU_NOTIFICATIONS:
                    intent = new Intent(activity, NotificationActivity.class);
                    break;
                case MENU_HELP:
                    intent = new Intent(activity, HelpSupportActivity.class);
                    break;
                case MENU_SETTING:
                    intent = new Intent(activity, SettingsActivity.class);
                    break;
                case MENU_OTHER:
                    intent = new Intent(activity, TestMenuActivity.class);
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

}

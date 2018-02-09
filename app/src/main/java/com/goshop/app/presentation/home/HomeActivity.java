package com.goshop.app.presentation.home;

import com.goshop.app.Const;
import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.HomeBaseAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.presentation.account.ChangePasswordActivity;
import com.goshop.app.presentation.account.EditProfileActivity;
import com.goshop.app.presentation.account.HelpSupportActivity;
import com.goshop.app.presentation.account.LoginActivity;
import com.goshop.app.presentation.account.MyAddressBookActivity;
import com.goshop.app.presentation.category.CategoryActivity;
import com.goshop.app.presentation.checkout.CheckoutSelectAddressActivity;
import com.goshop.app.presentation.checkout.PaymentStatusActivity;
import com.goshop.app.presentation.login.LoginComplementEmailActivity;
import com.goshop.app.presentation.login.LoginResetPasswordActivity;
import com.goshop.app.presentation.login.LoginSendConfirmationLinkActivity;
import com.goshop.app.presentation.myorder.MyOrderListActivity;
import com.goshop.app.presentation.search.SearchActivity;
import com.goshop.app.presentation.shopping.ShoppingCartActivity;
import com.goshop.app.utils.AnimUtils;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class HomeActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract
    .View {

    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.et_home_search)
    CustomEditText etHomeSearch;

    @BindView(R.id.iv_category_tree)
    ImageView ivCategoryTree;

    @BindView(R.id.iv_go_loyalty)
    ImageView ivGoLoyalty;

    @BindView(R.id.iv_home)
    ImageView ivHome;

    @BindView(R.id.iv_notification)
    ImageView ivNotification;

    @BindView(R.id.iv_orderlist)
    ImageView ivOrderlist;

    @BindView(R.id.iv_shopping_cart)
    ImageView ivShoppingCart;

    @BindView(R.id.iv_user_img)
    ImageView ivUserImg;

    @BindView(R.id.iv_wishlist)
    ImageView ivWishlist;

    @BindView(R.id.menu_layout)
    LinearLayout menuLayout;

    @BindView(R.id.rl_drawer_categorytree)
    RelativeLayout rlDrawerCategorytree;

    @BindView(R.id.rl_drawer_go_loyalty)
    RelativeLayout rlDrawerGoLoyalty;

    @BindView(R.id.rl_drawer_home)
    RelativeLayout rlDrawerHome;

    @BindView(R.id.rl_drawer_notification)
    RelativeLayout rlDrawerNotification;

    @BindView(R.id.rl_drawer_order)
    RelativeLayout rlDrawerOrder;

    @BindView(R.id.rl_drawer_shoppingcart)
    RelativeLayout rlDrawerShoppingcart;

    @BindView(R.id.rl_drawer_wishlist)
    RelativeLayout rlDrawerWishlist;

    @BindView(R.id.rl_image_left)
    RelativeLayout rlImageLeft;

    @BindView(R.id.rl_image_right)
    RelativeLayout rlImageRight;

    @BindView(R.id.rl_profile)
    RelativeLayout rlProfile;

    @BindView(R.id.root_layout)
    CoordinatorLayout rootLayout;

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    @BindView(R.id.tv_category_tree)
    TextView tvCategoryTree;

    @BindView(R.id.tv_go_loyalty)
    TextView tvGoLoyalty;

    @BindView(R.id.tv_help_support)
    TextView tvHelpSupport;

    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.tv_sidemenu_login_name)
    TextView tvLoginName;

    @BindView(R.id.tv_notification)
    TextView tvNotification;

    @BindView(R.id.tv_notification_num)
    TextView tvNotificationNum;

    @BindView(R.id.tv_order)
    TextView tvOrder;

    @BindView(R.id.tv_setting)
    TextView tvSetting;

    @BindView(R.id.tv_shopping_cart)
    TextView tvShoppingCart;

    @BindView(R.id.tv_shoppingCart_num)
    TextView tvShoppingCartNum;

    @BindView(R.id.tv_sidemenu_unlogin_name)
    TextView tvUnloginName;

    @BindView(R.id.tv_wishlist)
    TextView tvWishlist;

    @BindView(R.id.tv_wishlist_num)
    TextView tvWishlistNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        resetSelect();
        mPresenter.getHome(new HashMap<>());
    }

    @Override
    public int getContentView() {
        return R.layout.activity_base;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
        initSearch();
    }

    private void initSearch() {
        etHomeSearch.setOnFocusChangeListener((View v, boolean hasFocus) -> {
            if (hasFocus) {
                etHomeSearch.clearFocus();
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            }
        });
    }

    private void initToolBar() {
        getToolbar().setBackgroundColor(getResources().getColor(R.color.whiteTrans18));
    }

    private void resetSelect() {
        ivHome.setSelected(false);
        tvHome.setSelected(false);
        rlDrawerHome.setSelected(false);

        ivCategoryTree.setSelected(false);
        tvCategoryTree.setSelected(false);
        rlDrawerCategorytree.setSelected(false);

        ivGoLoyalty.setSelected(false);
        tvGoLoyalty.setSelected(false);
        rlDrawerGoLoyalty.setSelected(false);

        ivShoppingCart.setSelected(false);
        tvShoppingCart.setSelected(false);
        rlDrawerShoppingcart.setSelected(false);

        ivWishlist.setSelected(false);
        tvWishlist.setSelected(false);
        rlDrawerWishlist.setSelected(false);

        ivOrderlist.setSelected(false);
        tvOrder.setSelected(false);
        rlDrawerOrder.setSelected(false);

        ivNotification.setSelected(false);
        tvNotification.setSelected(false);
        rlDrawerNotification.setSelected(false);

        tvHelpSupport.setSelected(false);
        tvSetting.setSelected(false);
    }

    @OnClick({R.id.rl_image_left, R.id.rl_image_right, R.id.rl_profile, R.id.rl_drawer_home, R.id
        .rl_drawer_categorytree, R.id
        .rl_drawer_go_loyalty, R.id.rl_drawer_shoppingcart, R.id.rl_drawer_wishlist, R.id
        .rl_drawer_order, R.id.rl_drawer_notification, R.id.tv_help_support, R.id.tv_setting, R
        .id.tv_edit_profile, R.id.tv_change_password, R.id.tv_my_address_book, R.id
        .tv_send_confirmation_link, R.id.tv_reset_password, R.id.tv_reset_email, R.id
        .tv_payment_status, R.id.tv_select_address})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_image_left:
                getDrawerLayout().openDrawer(Gravity.LEFT);
                break;
            case R.id.rl_image_right:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            case R.id.rl_profile:
                startActivity(new Intent(this, LoginActivity.class));
                AnimUtils.setPageBottomToTopAnim(this);
                break;
            case R.id.rl_drawer_home:
                switchMenu(Const.MENU_HOME);
                break;
            case R.id.rl_drawer_categorytree:
                switchMenu(Const.MENU_CATEGORY);
                break;
            case R.id.rl_drawer_go_loyalty:
                switchMenu(Const.MENU_GO_LOYALTY);
                break;
            case R.id.rl_drawer_shoppingcart:
                switchMenu(Const.MENU_SHOPPING_CART);
                break;
            case R.id.rl_drawer_wishlist:
                switchMenu(Const.MENU_WISHLIST);
                break;
            case R.id.rl_drawer_order:
                switchMenu(Const.MENU_ORDER);
                startActivity(new Intent(this, MyOrderListActivity.class));
                break;
            case R.id.rl_drawer_notification:
                switchMenu(Const.MENU_NOTIFICATION);
                break;
            case R.id.tv_help_support:
                switchMenu(Const.MENU_HELP_SUPPORT);
                break;
            case R.id.tv_setting:
                switchMenu(Const.MENU_SETTING);
                break;
            case R.id.tv_edit_profile:
                startActivity(new Intent(this, EditProfileActivity.class));
                break;
            case R.id.tv_change_password:
                startActivity(new Intent(this, ChangePasswordActivity.class));
                break;
            case R.id.tv_my_address_book:
                startActivity(new Intent(this, MyAddressBookActivity.class));
                break;
            case R.id.tv_send_confirmation_link:
                startActivity(new Intent(this, LoginSendConfirmationLinkActivity.class));
                break;
            case R.id.tv_reset_password:
                startActivity(new Intent(this, LoginResetPasswordActivity.class));
                break;
            case R.id.tv_reset_email:
                startActivity(new Intent(this, LoginComplementEmailActivity.class));
                break;
            case R.id.tv_payment_status:
                startActivity(new Intent(this, PaymentStatusActivity.class));
                break;
            case R.id.tv_select_address:
                startActivity(new Intent(this, CheckoutSelectAddressActivity.class));
                break;
        }
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public void switchMenu(int type) {
        resetSelect();
        switch (type) {
            case Const.MENU_HOME:
                rlDrawerHome.setSelected(true);
                ivHome.setSelected(true);
                tvHome.setSelected(true);
                break;
            case Const.MENU_CATEGORY:
                ivCategoryTree.setSelected(true);
                tvCategoryTree.setSelected(true);
                rlDrawerCategorytree.setSelected(true);
                startActivity(new Intent(this, CategoryActivity.class));
                break;
            case Const.MENU_GO_LOYALTY:
                ivGoLoyalty.setSelected(true);
                tvGoLoyalty.setSelected(true);
                rlDrawerGoLoyalty.setSelected(true);
                break;
            case Const.MENU_SHOPPING_CART:
                ivShoppingCart.setSelected(true);
                tvShoppingCart.setSelected(true);
                rlDrawerShoppingcart.setSelected(true);
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            case Const.MENU_WISHLIST:
                ivWishlist.setSelected(true);
                tvWishlist.setSelected(true);
                rlDrawerWishlist.setSelected(true);
                break;
            case Const.MENU_ORDER:
                ivOrderlist.setSelected(true);
                tvOrder.setSelected(true);
                rlDrawerOrder.setSelected(true);
                break;
            case Const.MENU_NOTIFICATION:
                ivNotification.setSelected(true);
                tvNotification.setSelected(true);
                rlDrawerNotification.setSelected(true);
                break;
            case Const.MENU_HELP_SUPPORT:
                tvHelpSupport.setSelected(true);
                startActivity(new Intent(this, HelpSupportActivity.class));
                break;
            case Const.MENU_SETTING:
                tvSetting.setSelected(true);
                break;
        }
    }

    @Override
    public void showHome(HomeResponse homeResponse) {
        initRecycler(homeResponse);
    }

    private void initRecycler(HomeResponse homeResponse) {
        HomeBaseAdapter homeBaseAdapter = new HomeBaseAdapter(homeResponse);
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvHome.setAdapter(homeBaseAdapter);
    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }
}

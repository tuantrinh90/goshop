package com.goshop.app.presentation.home;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.HomeBaseAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.data.model.response.HomeResponse;
import com.goshop.app.utils.ScreenHelper;

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

public class HomeActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract.View {
    @BindView(R.id.et_home_search)
    CustomEditText etHomeSearch;

    @BindView(R.id.appbar_layout)
    AppBarLayout appbarLayout;

    @BindView(R.id.root_layout)
    CoordinatorLayout rootLayout;

    @BindView(R.id.rl_image_left)
    RelativeLayout rlImageLeft;

    @BindView(R.id.rl_image_right)
    RelativeLayout rlImageRight;

    @BindView(R.id.iv_user_img)
    ImageView ivUserImg;

    @BindView(R.id.tv_sidemenu_login_name)
    TextView tvLoginName;

    @BindView(R.id.tv_sidemenu_unlogin_name)
    TextView tvUnloginName;

    @BindView(R.id.rl_profile)
    RelativeLayout rlProfile;

    @BindView(R.id.iv_home)
    ImageView ivHome;

    @BindView(R.id.tv_home)
    TextView tvHome;

    @BindView(R.id.rl_drawer_home)
    RelativeLayout rlDrawerHome;

    @BindView(R.id.iv_category_tree)
    ImageView ivCategoryTree;

    @BindView(R.id.tv_category_tree)
    TextView tvCategoryTree;

    @BindView(R.id.rl_drawer_categorytree)
    RelativeLayout rlDrawerCategorytree;

    @BindView(R.id.iv_go_loyalty)
    ImageView ivGoLoyalty;

    @BindView(R.id.tv_go_loyalty)
    TextView tvGoLoyalty;

    @BindView(R.id.rl_drawer_go_loyalty)
    RelativeLayout rlDrawerGoLoyalty;

    @BindView(R.id.iv_shopping_cart)
    ImageView ivShoppingCart;

    @BindView(R.id.tv_shopping_cart)
    TextView tvShoppingCart;

    @BindView(R.id.tv_shoppingCart_num)
    TextView tvShoppingCartNum;

    @BindView(R.id.rl_drawer_shoppingcart)
    RelativeLayout rlDrawerShoppingcart;

    @BindView(R.id.iv_wishlist)
    ImageView ivWishlist;

    @BindView(R.id.tv_wishlist)
    TextView tvWishlist;

    @BindView(R.id.tv_wishlist_num)
    TextView tvWishlistNum;

    @BindView(R.id.rl_drawer_wishlist)
    RelativeLayout rlDrawerWishlist;

    @BindView(R.id.iv_orderlist)
    ImageView ivOrderlist;

    @BindView(R.id.tv_order)
    TextView tvOrder;

    @BindView(R.id.rl_drawer_order)
    RelativeLayout rlDrawerOrder;

    @BindView(R.id.iv_notification)
    ImageView ivNotification;

    @BindView(R.id.tv_notification)
    TextView tvNotification;

    @BindView(R.id.tv_notification_num)
    TextView tvNotificationNum;

    @BindView(R.id.rl_drawer_notification)
    RelativeLayout rlDrawerNotification;

    @BindView(R.id.tv_help_support)
    TextView tvHelpSupport;

    @BindView(R.id.tv_setting)
    TextView tvSetting;

    @BindView(R.id.menu_layout)
    LinearLayout menuLayout;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolBar();
        initSlideImgAndText();
        resetSelect();
        mPresenter.getHome(new HashMap<>());
    }

    private void initSlideImgAndText() {
        ivHome.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_home_nor));
        ivCategoryTree.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_categories_nor));
        ivGoLoyalty.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_go_loyalty_nor));
        ivShoppingCart.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_shopping_cart_nor));
        ivWishlist.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_wishlist_nor));
        ivOrderlist.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_myorders_nor));
        ivNotification.setImageDrawable(ScreenHelper.getThemeIconSelector(R.mipmap.ic_slidemenu_notification_nor));
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

    }

    private void initToolBar() {
        getToolbar().setBackgroundColor(getResources().getColor(R.color.whiteTrans18));
    }

    private void initRecycler(HomeResponse homeResponse) {
        HomeBaseAdapter homeBaseAdapter = new HomeBaseAdapter(homeResponse);
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvHome.setAdapter(homeBaseAdapter);
    }

    @OnClick({R.id.rl_image_left,R.id.rl_image_right,R.id.rl_profile, R.id.rl_drawer_home, R.id.rl_drawer_categorytree, R.id
        .rl_drawer_go_loyalty, R.id.rl_drawer_shoppingcart, R.id.rl_drawer_wishlist, R.id
        .rl_drawer_order, R.id.rl_drawer_notification, R.id.tv_help_support, R.id.tv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_image_left:
                getDrawerLayout().openDrawer(Gravity.LEFT);
                break;
            case R.id.rl_image_right:
                break;
            case R.id.rl_profile:
                break;
            case R.id.rl_drawer_home:
                resetSelect();
                rlDrawerHome.setSelected(true);
                ivHome.setSelected(true);
                tvHome.setSelected(true);
                break;
            case R.id.rl_drawer_categorytree:
                resetSelect();
                ivCategoryTree.setSelected(true);
                tvCategoryTree.setSelected(true);
                rlDrawerCategorytree.setSelected(true);
                break;
            case R.id.rl_drawer_go_loyalty:
                resetSelect();
                ivGoLoyalty.setSelected(true);
                tvGoLoyalty.setSelected(true);
                rlDrawerGoLoyalty.setSelected(true);
                break;
            case R.id.rl_drawer_shoppingcart:
                resetSelect();
                ivShoppingCart.setSelected(true);
                tvShoppingCart.setSelected(true);
                rlDrawerShoppingcart.setSelected(true);
                break;
            case R.id.rl_drawer_wishlist:
                resetSelect();
                ivWishlist.setSelected(true);
                tvWishlist.setSelected(true);
                rlDrawerWishlist.setSelected(true);
                break;
            case R.id.rl_drawer_order:
                resetSelect();
                ivOrderlist.setSelected(true);
                tvOrder.setSelected(true);
                rlDrawerOrder.setSelected(true);
                break;
            case R.id.rl_drawer_notification:
                resetSelect();
                ivNotification.setSelected(true);
                tvNotification.setSelected(true);
                rlDrawerNotification.setSelected(true);
                break;
            case R.id.tv_help_support:
                resetSelect();
                tvHelpSupport.setSelected(true);
                break;
            case R.id.tv_setting:
                resetSelect();
                tvSetting.setSelected(true);
                break;
        }
    }

    private void resetSelect(){
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

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    @Override
    public void showHome(HomeResponse homeResponse) {
        initRecycler(homeResponse);
    }

    @Override
    public void showNetwordErrorMessage() {

    }

    @Override
    public void showFaildMessage(String errorMessage) {

    }
}

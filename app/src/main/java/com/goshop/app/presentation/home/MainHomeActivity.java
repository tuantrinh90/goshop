package com.goshop.app.presentation.home;

import com.goshop.app.R;
import com.goshop.app.adapter.HomeBaseAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomEditText;
import com.goshop.app.utils.ServiceData;

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

import butterknife.BindView;
import butterknife.OnClick;

public class MainHomeActivity extends BaseActivity {
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

    @BindView(R.id.tv_user_name)
    TextView tvUserName;

    @BindView(R.id.ll_profile)
    LinearLayout llProfile;

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

    @BindView(R.id.iv_reward)
    ImageView ivReward;

    @BindView(R.id.tv_reward)
    TextView tvReward;

    @BindView(R.id.rl_drawer_reward)
    RelativeLayout rlDrawerReward;

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
        initRecycler();

    }

    @Override
    public int getContentView() {
        return R.layout.activity_drawer_layout;
    }

    @Override
    public String getScreenTitle() {
        return null;
    }

    @Override
    public void inject() {

    }

    private void initToolBar() {
        getToolbar().setBackgroundColor(getResources().getColor(R.color.whiteTrans18));
    }

    private void initRecycler() {
        HomeBaseAdapter homeBaseAdapter = new HomeBaseAdapter(ServiceData.getBaseData());
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvHome.setAdapter(homeBaseAdapter);
    }

    @OnClick({R.id.rl_image_left,R.id.rl_image_right,R.id.ll_profile, R.id.rl_drawer_home, R.id.rl_drawer_categorytree, R.id
        .rl_drawer_reward, R.id.rl_drawer_shoppingcart, R.id.rl_drawer_wishlist, R.id
        .rl_drawer_order, R.id.rl_drawer_notification, R.id.tv_help_support, R.id.tv_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_image_left:
                getDrawerLayout().openDrawer(Gravity.LEFT);
                break;
            case R.id.rl_image_right:
                break;
            case R.id.ll_profile:
                break;
            case R.id.rl_drawer_home:
                break;
            case R.id.rl_drawer_categorytree:
                break;
            case R.id.rl_drawer_reward:
                break;
            case R.id.rl_drawer_shoppingcart:
                break;
            case R.id.rl_drawer_wishlist:
                break;
            case R.id.rl_drawer_order:
                break;
            case R.id.rl_drawer_notification:
                break;
            case R.id.tv_help_support:
                break;
            case R.id.tv_setting:
                break;
        }
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }



}

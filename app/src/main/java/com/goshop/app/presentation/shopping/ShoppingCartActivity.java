package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.checkout.CheckoutActivity;
import com.goshop.app.presentation.home.MainPageActivity;
import com.goshop.app.presentation.model.ShoppingCartModel;
import com.goshop.app.presentation.model.widget.CarouselItemsVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.PopWindowUtil;
import com.goshop.app.widget.listener.OnBannerItemClickListener;
import com.goshop.app.widget.listener.OnItemMenuClickListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class ShoppingCartActivity extends BaseDrawerActivity<ShoppingCartContract.Presenter>
    implements
    ShoppingCartContract.View, ShoppingCartAdapter.OnCheckoutClickListener,
    OnBannerItemClickListener, OnItemMenuClickListener,
    PopWindowUtil.OnCartItemMenuClickListener {

    public static final String EXTRA_ENTRANCE = "extra_entrance";

    public static final String TYPE_ENTRANCE_DRAWER = "drawer";

    public static final String TYPE_ENTRANCE_HOME = "pdp";

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.rv_shoppint_cart)
    RecyclerView rvShoppintCart;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fl_no_data)
    FrameLayout flNoData;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    private ShoppingCartAdapter shoppingCartAdapter;

    private String entranceType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentMenuType(MenuUtil.MENU_TYPE_SHOPPING_CART);
        setContentView(getContentView());
        initIntent();
        initToolbar();
        initRecyclerView();
        //TODO(helen) wait for api
        mPresenter.shoppingCartRequest(null);
    }

    private void initIntent() {
        entranceType = getIntent().getStringExtra(EXTRA_ENTRANCE);
    }

    private void initToolbar() {
        hideRightMenu();
        if (TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
            imageViewLeftMenu.setImageResource(R.drawable.ic_menu);
        } else {
            imageViewLeftMenu.setImageResource(R.drawable.ic_icon_back);
        }
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvShoppintCart.setLayoutManager(layoutManager);
        shoppingCartAdapter = new ShoppingCartAdapter(new ArrayList<>(), this);
        rvShoppintCart.setAdapter(shoppingCartAdapter);
        shoppingCartAdapter.setOnBannerItemClickListener(this);
        shoppingCartAdapter.setOnItemMenuClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.shopping_cart);
    }

    @Override
    public void showCartDetail(List<ShoppingCartModel> cartModels) {
        shoppingCartAdapter.setDatas(cartModels);
    }

    @Override
    public void onCheckoutClick() {
        startActivity(new Intent(ShoppingCartActivity.this, CheckoutActivity.class));
    }

    @Override
    public void onBannerItemClick(CarouselItemsVM carouselItemsVM) {
        //todo wait for api
    }

    @Override
    public void onItemMenuClick(View parentView, Object object) {
        PopWindowUtil.showShoppingCartMenuPop(parentView, this);
    }

    @Override
    public void onCartWishlist() {
        //todo wait for api
    }

    @Override
    public void onCartDeleteClick() {
        //todo wait for api
    }

    @OnClick({R.id.tv_btn_cart_checkout, R.id.imageview_left_menu})
    public void onCartClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }

                break;
            case R.id.tv_btn_cart_checkout:
                startActivity(new Intent(this, CheckoutActivity.class));
                break;
            case R.id.tv_shop_now:
                updateLayoutStatus(flNoData,false);
                startActivity(new Intent(this, MainPageActivity.class));
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak,false);
                // TODO: jay: 2018/4/11  need real api
                mPresenter.shoppingCartRequest(null);
                break;
        }
    }

}

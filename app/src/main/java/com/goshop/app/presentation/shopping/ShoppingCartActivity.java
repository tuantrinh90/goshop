package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.ShoppingCartModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/24.
 */

public class ShoppingCartActivity extends BaseActivity<ShoppingCartContract.Presenter> implements
    ShoppingCartContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.rv_shoppint_cart)
    RecyclerView rvShoppintCart;

    private ShoppingCartAdapter shoppingCartAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.shoppingCartRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.shopping_cart);
    }

    @Override
    public void inject() {
        hideRightMenu();
        imageviewLeftMenu.setVisibility(View.GONE);
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
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
        shoppingCartAdapter = new ShoppingCartAdapter(new ArrayList<>());
        rvShoppintCart.setAdapter(shoppingCartAdapter);
    }

    @Override
    public void showCartDetail(List<ShoppingCartModel> cartModels) {
        shoppingCartAdapter.setDatas(cartModels);
    }
}

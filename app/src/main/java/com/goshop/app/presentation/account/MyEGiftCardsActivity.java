package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.MyEGiftModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyEGiftCardsActivity extends BaseActivity<MyEGiftCardContract.Presenter> implements
    MyEGiftCardContract.View {

    @BindView(R.id.recyclerview_my_egift)
    RecyclerView recyclerviewMyEgift;

    private MyEGiftCardsAdapter cardsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.eGiftCardsRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_egiftcards;
    }

    @Override
    public void inject() {
        hideRightMenu();
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
        recyclerviewMyEgift.setLayoutManager(layoutManager);
        cardsAdapter = new MyEGiftCardsAdapter(new ArrayList<>());
        recyclerviewMyEgift.setAdapter(cardsAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_egift_cards);
    }

    @Override
    public void showGiftCardsResult(List<MyEGiftModel> eGiftModels) {
        cardsAdapter.setUpDatas(eGiftModels);
    }
}

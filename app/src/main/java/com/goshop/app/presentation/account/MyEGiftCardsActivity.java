package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.MyEGiftModel;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyEGiftCardsActivity extends BaseActivity<MyEGiftCardContract.Presenter> implements
    MyEGiftCardContract.View, MyEGiftCardsAdapter.OnActiveCardClickListener {

    @BindView(R.id.recyclerview_my_egift)
    RecyclerView recyclerviewMyEgift;

    private MyEGiftCardsAdapter cardsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        mPresenter.getEGiftCardDetails();
    }

    private void initView() {
        hideRightMenu();
        initRecyclerView();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_egiftcards;
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
        recyclerviewMyEgift.setLayoutManager(layoutManager);
        cardsAdapter = new MyEGiftCardsAdapter(new ArrayList<>());
        recyclerviewMyEgift.setAdapter(cardsAdapter);
        cardsAdapter.setOnActiveCardClickListener(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_egift_cards);
    }

    @Override
    public void getEGiftCardSuccess(List<MyEGiftModel> eGiftModels) {
        cardsAdapter.setUpDatas(eGiftModels);
    }

    @Override
    public void activeSuccess() {
        // TODO: 2018/4/18 update list
        finish();
    }

    @Override
    public void showServiceErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewMyEgift, errorMessage);
    }

    @Override
    public void showNetworkErrorMessage(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(recyclerviewMyEgift, errorMessage);
    }

    @OnClick({R.id.imageview_left_menu})
    public void OnMyGiftClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
        }
    }

    @Override
    public void onActivieClick(String code) {
        mPresenter.eGiftCardsRequest(code);
    }

    @Override
    public void onEmptyClick() {
        //todo hard code wait for design
        Toast.makeText(this, "Please input Unique Code!", Toast.LENGTH_SHORT).show();
    }
}

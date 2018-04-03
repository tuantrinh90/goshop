package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.MyEGiftModel;

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
        mPresenter.getEGiftCardDetails();
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
    public void getEGiftCardFailed(String errorMessage) {
        //todo wait for design
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void activeSuccess() {
        finish();
    }

    @Override
    public void activeFailed(String errorMessage) {
        //todo wait for design
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
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
        Map<String, Object> params = new HashMap<>();
        params.put("websiteId", "");
        params.put("storeId", "");
        params.put("egiftCard", code);
        mPresenter.eGiftCardsRequest(params);
    }

    @Override
    public void onEmptyClick() {
        //todo hard code wait for design
        Toast.makeText(this, "Please input Unique Code!", Toast.LENGTH_SHORT).show();
    }
}

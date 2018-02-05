package com.goshop.app.presentation.checkout;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SelectAddressVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/2/2.
 */

public class CheckoutSelectAddressActivity extends BaseActivity<CheckoutSelectContract.Presenter>
    implements CheckoutSelectContract.View, CheckoutSelectAddressAdapter.OnEditClickListener {

    @BindView(R.id.ll_select_address_bottom)
    LinearLayout llSelectAddressBottom;

    @BindView(R.id.recyclerview_select_address)
    RecyclerView recyclerviewSelectAddress;

    @BindView(R.id.tv_btn_layout_white)
    CustomTextView tvBtnLayoutWhite;

    private CheckoutSelectAddressAdapter addressAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo(helen) wait for api
        mPresenter.selectAddressRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_checkout_select_address;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.select_address);
    }

    @Override
    public void inject() {
        hideRightMenu();
        tvBtnLayoutWhite.setText(getResources().getString(R.string.add_new_address));
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
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewSelectAddress.setLayoutManager(manager);
        addressAdapter = new CheckoutSelectAddressAdapter(new ArrayList<>(), this);
        recyclerviewSelectAddress.setAdapter(addressAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_layout_white})
    public void onSelectClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                break;
            case R.id.tv_btn_layout_white:
                break;
        }
    }

    @Override
    public void showResult(List<SelectAddressVM> selectAddressVMS) {
        addressAdapter.setUpdate(selectAddressVMS);
    }

    @Override
    public void onEditClick() {

    }
}

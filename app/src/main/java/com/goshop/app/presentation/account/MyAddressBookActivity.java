package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.AddressVM;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

/**
 * Created by helen on 2018/1/26.
 */

public class MyAddressBookActivity extends BaseActivity<MyAddressBookContract.Presenter>
    implements MyAddressBookContract.View, MyAddressBookAdapter.OnAddressBookClickListener {

    MyAddressBookAdapter addressBookAdapter;

    @BindView(R.id.recyclerview_address_book)
    RecyclerView recyclerviewAddressBook;

    @BindView(R.id.tv_btn_layout_white)
    CustomTextView tvBtnLayoutWhite;

    @Override
    public void myAddressResult(List<AddressVM> addressVMS) {
        addressBookAdapter.setUpdates(addressVMS);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO(helen) wait for api
        mPresenter.myAddressRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_address_book;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_address_book);
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewAddressBook.setLayoutManager(layoutManager);
        addressBookAdapter = new MyAddressBookAdapter(new ArrayList<>(), this);
        recyclerviewAddressBook.setAdapter(addressBookAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_layout_white})
    public void onAddressBookClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_layout_white:
                startActivity(new Intent(this, AddAddressActivity.class));
                break;
        }
    }

    @Override
    public void editAddress(AddressVM addressVM) {
        Intent intent = new Intent(this, EditAddressActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(EditAddressActivity.EDIT_ADDRESS, addressVM);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void removeAddress(AddressVM addressVM) {

    }
}

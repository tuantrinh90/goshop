package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.AddressVM;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class MyAddressBookActivity extends BaseActivity<MyAddressBookContract.Presenter>
    implements MyAddressBookContract.View, MyAddressBookAdapter.OnAddressBookClickListener {

    @BindView(R.id.recyclerview_address_book)
    RecyclerView recyclerviewAddressBook;

    private MyAddressBookAdapter addressBookAdapter;

    private List<AddressVM> displayAddressVMs;

    @Override
    public void myAddressResult(List<AddressVM> addressVMS) {
        displayAddressVMs.clear();
        displayAddressVMs.addAll(addressVMS);
        addressBookAdapter.notifyDataSetChanged();
        //TODO this part need decide
//        addressBookAdapter.setUpdates(displayAddressVMs);
    }

    @Override
    public void getAddressListSuccess(List<AddressVM> addressVMS) {
        addressBookAdapter.setUpdates(addressVMS);
    }

    @Override
    public void getAddressListFailed(String errorMessage) {
        //todo need decide
        Log.e("MyAddressBook", errorMessage);
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getAddressList();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_address_book;
    }

    @Override
    public void inject() {
        displayAddressVMs = new ArrayList<>();
        initPresenter();
        initRecyclerView();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_address_book);
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
        addressBookAdapter = new MyAddressBookAdapter(displayAddressVMs, this);
        recyclerviewAddressBook.setAdapter(addressBookAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu})
    public void onAddressBookClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.imageview_right_menu:
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
        //todo need decide
        /*if (displayAddressVMs.contains(addressVM)) {
            displayAddressVMs.remove(addressVM);
            if (addressVM.isDefault() && displayAddressVMs.size() > 0) {
                displayAddressVMs.get(0).setDefault(true);
            }
        }
        addressBookAdapter.setUpdates(displayAddressVMs);*/
    }
}

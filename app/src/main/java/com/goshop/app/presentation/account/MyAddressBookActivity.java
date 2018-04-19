package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.presentation.model.AddressVM;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

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

    @BindView(R.id.fl_no_data)
    FrameLayout flNoData;

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

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
        if (addressVMS.size() > 0) {
            addressBookAdapter.setUpdates(addressVMS);
        } else {
            updateLayoutStatus(flNoData, true);
        }
    }

    @Override
    public void showErrorMessage(String errorMessage) {
        updateLayoutStatus(flConnectionBreak, true);
        PopWindowUtil.showRequestMessagePop(flConnectionBreak,errorMessage);
    }

    @Override
    public void selectDefaultShippingSuccess(int position) {
        addressBookAdapter.setSelectShippingUpdate(position);
    }

    @Override
    public void selectDefaultBillingSuccess(int position) {
        addressBookAdapter.setSelectBillingUpdate(position);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getAddressList();
        displayAddressVMs = new ArrayList<>();
        initRecyclerView();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_my_address_book;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_address_book);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerviewAddressBook.setLayoutManager(layoutManager);
        addressBookAdapter = new MyAddressBookAdapter(displayAddressVMs, this);
        recyclerviewAddressBook.setAdapter(addressBookAdapter);
    }

    @OnClick({R.id.imageview_left_menu, R.id.imageview_right_menu, R.id.tv_add_now, R.id.tv_net_refresh})
    public void onAddressBookClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.imageview_right_menu:
                startActivity(new Intent(this, AddAddressActivity.class));
                break;
            case R.id.tv_add_now:
                updateLayoutStatus(flNoData, false);
                startActivity(new Intent(this, AddAddressActivity.class));
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.getAddressList();
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
    public void selectDefaultShippingAddress(AddressVM addressVM, int position) {
        mPresenter.selectDefaultShippingRequest(position);
    }

    @Override
    public void selectDefaultBillingAddress(AddressVM addressVM, int position) {
        mPresenter.selectDefaultBillingRequest(position);
    }
}

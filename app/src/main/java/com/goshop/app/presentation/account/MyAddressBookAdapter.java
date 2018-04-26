package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.AddressVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAddressBookAdapter extends RecyclerView.Adapter {

    private OnAddressBookClickListener addressBookClickListener;

    private List<AddressVM> addressVMS;

    public MyAddressBookAdapter(List<AddressVM> addressVMS,
        OnAddressBookClickListener addressBookClickListener) {
        this.addressVMS = addressVMS;
        this.addressBookClickListener = addressBookClickListener;
    }

    public void setUpdates(List<AddressVM> addressVMS) {
        this.addressVMS.clear();
        this.addressVMS.addAll(addressVMS);
        notifyDataSetChanged();
    }

    public void setSelectShippingUpdate(int position) {
        for(int i = 0; i < addressVMS.size(); i++) {
            addressVMS.get(i).setShippingDefault(i == position);
        }
        notifyDataSetChanged();
    }

    public void setSelectBillingUpdate(int position) {
        for(int i = 0; i < addressVMS.size(); i++) {
            addressVMS.get(i).setBillingDefault(i == position);
        }
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_address_book, parent, false);
        return new MyAddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MyAddressViewHolder) holder).bindingData(addressVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return addressVMS.size();
    }

    interface OnAddressBookClickListener {

        void editAddress(AddressVM addressVM);

        void selectDefaultShippingAddress(AddressVM addressVM, int position);

        void selectDefaultBillingAddress(AddressVM addressVM, int position);
    }

    class MyAddressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_book_billing_selector)
        ImageView ivBookBillingSelector;

        @BindView(R.id.iv_book_shipping_selector)
        ImageView ivBookShippingSelector;

        @BindView(R.id.ll_address_book_edit)
        LinearLayout llAddressBookEdit;

        @BindView(R.id.ll_book_shipping_selector)
        LinearLayout llBookShippingSelector;

        @BindView(R.id.ll_book_billing_selector)
        LinearLayout llBookBillingSelector;

        @BindView(R.id.tv_address_book_address)
        RobotoLightTextView tvAddressBookAddress;

        @BindView(R.id.tv_address_book_city)
        RobotoLightTextView tvAddressBookCity;

        @BindView(R.id.tv_address_book_code)
        RobotoLightTextView tvAddressBookCode;

        @BindView(R.id.tv_address_book_country)
        RobotoLightTextView tvAddressBookCountry;

        @BindView(R.id.tv_address_book_name)
        RobotoMediumTextView tvAddressBookName;

        @BindView(R.id.tv_address_book_state)
        RobotoLightTextView tvAddressBookState;

        @BindView(R.id.tv_address_book_tel)
        RobotoLightTextView tvAddressBookTel;

        public MyAddressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(AddressVM addressVM, int position) {
            tvAddressBookName.setText(addressVM.getName());
            tvAddressBookAddress.setText(addressVM.getAddress());
            tvAddressBookCity.setText(addressVM.getCity());
            tvAddressBookCode.setText(addressVM.getCode());
            tvAddressBookCountry.setText(addressVM.getCountry());
            tvAddressBookState.setText(addressVM.getState());
            tvAddressBookTel.setText(addressVM.getTel());
            ivBookShippingSelector.setSelected(addressVM.isShippingDefault());
            llBookShippingSelector.setOnClickListener(v -> {
                    if (!ivBookShippingSelector.isSelected()) {
                        addressBookClickListener.selectDefaultShippingAddress(addressVM, position);
                    }
                }
            );
            ivBookBillingSelector.setSelected(addressVM.isBillingDefault());
            llBookBillingSelector.setOnClickListener(
                v -> {
                    if (!ivBookBillingSelector.isSelected()) {
                        addressBookClickListener.selectDefaultBillingAddress(addressVM, position);
                    }
                });

            llAddressBookEdit
                .setOnClickListener(v -> addressBookClickListener.editAddress(addressVM));
        }
    }
}

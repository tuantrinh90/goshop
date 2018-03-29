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
        //TODO this part need decide
        this.addressVMS.clear();
        this.addressVMS.addAll(addressVMS);
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
        ((MyAddressViewHolder) holder).bindingData(addressVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return addressVMS.size();
    }

    interface OnAddressBookClickListener {

        void editAddress(AddressVM addressVM);

        void removeAddress(AddressVM addressVM);
    }

    class MyAddressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_address_book_selector)
        ImageView ivAddressBookSelector;

        @BindView(R.id.ll_address_book_edit)
        LinearLayout llAddressBookEdit;

        @BindView(R.id.ll_address_book_remove)
        LinearLayout llAddressBookRemove;

        @BindView(R.id.ll_address_book_selector)
        LinearLayout llAddressBookSelector;

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

        void bindingData(AddressVM addressVM) {
            tvAddressBookName.setText(addressVM.getName());
            tvAddressBookAddress.setText(addressVM.getAddress());
            tvAddressBookCity.setText(addressVM.getCity());
            tvAddressBookCode.setText(addressVM.getCode());
            tvAddressBookCountry.setText(addressVM.getCountry());
            tvAddressBookState.setText(addressVM.getState());
            tvAddressBookTel.setText(addressVM.getTel());
            ivAddressBookSelector.setSelected(addressVM.isDefault());
            llAddressBookSelector.setOnClickListener(
                v -> ivAddressBookSelector.setSelected(!ivAddressBookSelector.isSelected()));

            llAddressBookEdit
                .setOnClickListener(v -> addressBookClickListener.editAddress(addressVM));

            llAddressBookRemove
                .setOnClickListener(v -> addressBookClickListener.removeAddress(addressVM));
        }
    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.AddressVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

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
        //TODO(helen)this part need decide
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

        @BindView(R.id.ll_address_book_edit)
        LinearLayout llAddressBookEdit;

        @BindView(R.id.ll_address_book_remove)
        LinearLayout llAddressBookRemove;

        @BindView(R.id.rb_address_book_default)
        RadioButton rbAddressBookDefault;

        @BindView(R.id.tv_address_book_address)
        CustomTextView tvAddressBookAddress;

        @BindView(R.id.tv_address_book_city)
        CustomTextView tvAddressBookCity;

        @BindView(R.id.tv_address_book_code)
        CustomTextView tvAddressBookCode;

        @BindView(R.id.tv_address_book_country)
        CustomTextView tvAddressBookCountry;

        @BindView(R.id.tv_address_book_name)
        CustomBoldTextView tvAddressBookName;

        @BindView(R.id.tv_address_book_state)
        CustomTextView tvAddressBookState;

        @BindView(R.id.tv_address_book_tel)
        CustomTextView tvAddressBookTel;

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
            rbAddressBookDefault.setChecked(addressVM.isDefault());

            llAddressBookEdit
                .setOnClickListener(v -> addressBookClickListener.editAddress(addressVM));

            llAddressBookRemove
                .setOnClickListener(v -> addressBookClickListener.removeAddress(addressVM));
        }
    }
}

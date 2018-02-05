package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SelectAddressVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by helen on 2018/2/2.
 */

public class CheckoutSelectAddressAdapter extends RecyclerView.Adapter {

    private OnEditClickListener onEditClickListener;

    private List<SelectAddressVM> selectAddressVMS;

    public CheckoutSelectAddressAdapter(List<SelectAddressVM> selectAddressVMS,
        OnEditClickListener onEditClickListener) {
        this.selectAddressVMS = selectAddressVMS;
        this.onEditClickListener = onEditClickListener;
    }

    public void setUpdate(List<SelectAddressVM> selectAddressVMS) {
        this.selectAddressVMS.clear();
        this.selectAddressVMS = selectAddressVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_select_address, parent, false);
        return new SelectAddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SelectAddressViewHolder) holder).bindingData(selectAddressVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return selectAddressVMS.size();
    }

    interface OnEditClickListener {

        void onEditClick();
    }

    class SelectAddressViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ll_select_address_edit)
        LinearLayout llSelectAddressEdit;

        @BindView(R.id.rb_select_address_set)
        RadioButton rbSelectAddressSet;

        @BindView(R.id.tv_select_address_address)
        CustomTextView tvSelectAddressAddress;

        @BindView(R.id.tv_select_address_city)
        CustomTextView tvSelectAddressCity;

        @BindView(R.id.tv_select_address_code)
        CustomTextView tvSelectAddressCode;

        @BindView(R.id.tv_select_address_country)
        CustomTextView tvSelectAddressCountry;

        @BindView(R.id.tv_select_address_name)
        CustomBoldTextView tvSelectAddressName;

        @BindView(R.id.tv_select_address_state)
        CustomTextView tvSelectAddressState;

        @BindView(R.id.tv_select_address_tel)
        CustomTextView tvSelectAddressTel;

        public SelectAddressViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SelectAddressVM selectAddressVM) {
            rbSelectAddressSet.setChecked(selectAddressVM.isShipping());
            tvSelectAddressName.setText(selectAddressVM.getName());
            tvSelectAddressAddress.setText(selectAddressVM.getAddress());
            tvSelectAddressCity.setText(selectAddressVM.getCity());
            tvSelectAddressState.setText(selectAddressVM.getState());
            tvSelectAddressCode.setText(selectAddressVM.getCode());
            tvSelectAddressCountry.setText(selectAddressVM.getCountry());
            tvSelectAddressTel.setText(selectAddressVM.getTel());
            llSelectAddressEdit.setOnClickListener(v -> onEditClickListener.onEditClick());
        }
    }
}

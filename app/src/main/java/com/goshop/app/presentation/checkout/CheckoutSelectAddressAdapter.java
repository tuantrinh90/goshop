package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.SelectAddressVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

        @BindView(R.id.rb_select_address_set)
        RadioButton rbSelectAddressSet;

        @BindView(R.id.tv_select_address_address)
        RobotoLightTextView tvSelectAddressAddress;

        @BindView(R.id.tv_select_address_city)
        RobotoLightTextView tvSelectAddressCity;

        @BindView(R.id.tv_select_address_code)
        RobotoLightTextView tvSelectAddressCode;

        @BindView(R.id.tv_select_address_country)
        RobotoLightTextView tvSelectAddressCountry;

        @BindView(R.id.tv_select_address_name)
        RobotoMediumTextView tvSelectAddressName;

        @BindView(R.id.tv_select_address_state)
        RobotoLightTextView tvSelectAddressState;

        @BindView(R.id.tv_select_address_tel)
        RobotoLightTextView tvSelectAddressTel;

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
            rbSelectAddressSet.setText(String.format(itemView.getContext().getResources().getString(R.string.set_it_as_type),  selectAddressVM.getType()));
        }
    }
}

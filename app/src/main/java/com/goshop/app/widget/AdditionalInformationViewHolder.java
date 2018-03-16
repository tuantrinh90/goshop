package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.AdditionalInformationVM;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionalInformationViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_additional_info_lable)
    RobotoRegularTextView tvAdditionalInfoLable;

    @BindView(R.id.tv_additional_info_value)
    RobotoRegularTextView tvAdditionalInfoValue;

    public AdditionalInformationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    void bindingData(AdditionalInformationVM additionalInformationVM) {
        tvAdditionalInfoLable.setText(additionalInformationVM.getLable());
        tvAdditionalInfoValue.setText(additionalInformationVM.getUnit());
    }
}

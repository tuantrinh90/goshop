package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.presentation.model.PdpAdditionalItemVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdditionalItemAdapter extends RecyclerView.Adapter {

    private List<PdpAdditionalItemVM> itemVMS;

    public AdditionalItemAdapter(
        List<PdpAdditionalItemVM> itemVMS) {
        this.itemVMS = itemVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_additional_information, parent, false);
        return new AdditionalItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AdditionalItemViewHolder) holder).bindingData(itemVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return itemVMS.size();
    }

    class AdditionalItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_additional_info_lable)
        RobotoLightTextView tvAdditionalInfoLable;

        @BindView(R.id.tv_additional_info_value)
        RobotoLightTextView tvAdditionalInfoValue;

        public AdditionalItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(PdpAdditionalItemVM itemVM) {
            tvAdditionalInfoLable.setText(itemVM.getLable());
            tvAdditionalInfoValue.setText(itemVM.getUnit());
        }
    }
}

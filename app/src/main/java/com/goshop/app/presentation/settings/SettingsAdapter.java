package com.goshop.app.presentation.settings;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.SettingsModel;
import com.goshop.app.presentation.model.SettingsSingleDetailVM;
import com.goshop.app.presentation.model.SettingsSwitchVM;
import com.goshop.app.presentation.model.SettingsTitleVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsAdapter extends RecyclerView.Adapter {

    private List<SettingsModel> settingsModels;

    public SettingsAdapter(
        List<SettingsModel> settingsModels) {
        this.settingsModels = settingsModels;
    }

    public void setUpdateDatas(List<SettingsModel> settingsModels) {
        this.settingsModels.clear();
        this.settingsModels = settingsModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case SettingsModel.VIEW_TYPE_TITLE:
                View titleView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_title_single_text, parent, false);
                viewHolder = new TitleViewHolder(titleView);
                break;
            case SettingsModel.VIEW_TYPE_SWICTH_DETAIL:
                View switchView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_settings_switch, parent, false);
                viewHolder = new SwitchViewHolder(switchView);
                break;
            case SettingsModel.VIEW_TYPE_SINGLE_DETAIL:
                View detailView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_detail_single_text, parent, false);
                viewHolder = new DetailViewHolder(detailView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SettingsModel settingsModel = settingsModels.get(position);
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder).bindingData((SettingsTitleVM) settingsModel, position);
        } else if (holder instanceof SwitchViewHolder) {
            ((SwitchViewHolder) holder).bindingData((SettingsSwitchVM) settingsModel);
        } else if (holder instanceof DetailViewHolder) {
            ((DetailViewHolder) holder).bindingData((SettingsSingleDetailVM) settingsModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return settingsModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return settingsModels.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_title_space)
        ImageView ivTitleSpace;

        @BindView(R.id.tv_title_name)
        CustomBoldTextView tvTitleName;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SettingsTitleVM titleVM, int position) {
            ivTitleSpace.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
            tvTitleName.setText(titleVM.getTitle());
        }
    }

    class SwitchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.switch_setting)
        Switch swtchSetting;

        @BindView(R.id.tv_switch_content)
        CustomTextView tvSwitchContent;

        public SwitchViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SettingsSwitchVM switchVM) {
            tvSwitchContent.setText(switchVM.getDetail());
        }
    }

    class DetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_item_detail)
        CustomTextView tvItemDetail;

        public DetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SettingsSingleDetailVM singleDetailVM) {
            tvItemDetail.setText(singleDetailVM.getDetail());
            if (singleDetailVM.getItemClickListener() != null) {
                itemView.setOnClickListener(
                    v -> singleDetailVM.getItemClickListener().onDetailItemClick());
            }
        }
    }


}

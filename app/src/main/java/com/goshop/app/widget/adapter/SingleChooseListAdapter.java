package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ProfileMetaVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SingleChooseListAdapter extends RecyclerView.Adapter {

    private OnSingleChooseItemClickListener onSingleChooseItemClickListener;

    private List<ProfileMetaVM> profileMetaVMS;

    public SingleChooseListAdapter(
        List<ProfileMetaVM> profileMetaVMS) {
        this.profileMetaVMS = profileMetaVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_alert_single, parent, false);

        return new SingleChooseListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SingleChooseListViewHolder) holder).bindingData(profileMetaVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return profileMetaVMS.size();
    }

    public void setOnSingleChooseItemClickListener(
        OnSingleChooseItemClickListener onSingleChooseItemClickListener) {
        this.onSingleChooseItemClickListener = onSingleChooseItemClickListener;
    }

    private void updateDatas(int position) {
        for (int i = 0; i < profileMetaVMS.size(); i++) {
            profileMetaVMS.get(i).setSelect(i == position);
        }
        notifyDataSetChanged();
    }

    public interface OnSingleChooseItemClickListener {

        void onSingleChooseItemClick(int position);
    }

    class SingleChooseListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_single_select)
        ImageView ivSingleSelect;

        @BindView(R.id.tv_single_select)
        RobotoRegularTextView tvSingleSelect;

        public SingleChooseListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ProfileMetaVM profileMetaVM, int position) {
            ivSingleSelect.setSelected(profileMetaVM.isSelect());
            tvSingleSelect.setText(profileMetaVM.getValue());
            itemView.setOnClickListener(
                v -> {
                    updateDatas(position);
                    onSingleChooseItemClickListener.onSingleChooseItemClick(position);

                });
        }
    }
}

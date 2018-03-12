package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.widget.SingleChooseVM;

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

    private List<SingleChooseVM> singleChooseVMS;

    public SingleChooseListAdapter(
        List<SingleChooseVM> singleChooseVMS) {
        this.singleChooseVMS = singleChooseVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_alert_single, parent, false);

        return new SingleChooseListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SingleChooseListViewHolder) holder).bindingData(singleChooseVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return singleChooseVMS.size();
    }

    public void setOnSingleChooseItemClickListener(
        OnSingleChooseItemClickListener onSingleChooseItemClickListener) {
        this.onSingleChooseItemClickListener = onSingleChooseItemClickListener;
    }

    private void updateDatas(int position) {
        for (int i = 0; i < singleChooseVMS.size(); i++) {
            singleChooseVMS.get(i).setChoose(i == position);
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
        CustomTextView tvSingleSelect;

        public SingleChooseListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SingleChooseVM singleChooseVM, int position) {
            ivSingleSelect.setSelected(singleChooseVM.isChoose());
            tvSingleSelect.setText(singleChooseVM.getContent());
            itemView.setOnClickListener(
                v -> {
                    updateDatas(position);
                    onSingleChooseItemClickListener.onSingleChooseItemClick(position);

                });
        }
    }
}

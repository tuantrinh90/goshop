package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.SizeVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SizeSelectAdapter extends RecyclerView.Adapter {

    private OnSizeItemClickListener onSizeItemClickListener;

    private List<SizeVM> sizeVMS;

    public SizeSelectAdapter(
        List<SizeVM> sizeVMS) {
        this.sizeVMS = sizeVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_alert_single, parent, false);

        return new SizeSelectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SizeSelectViewHolder) holder).bindingData(sizeVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return sizeVMS.size();
    }

    public void setOnSizeItemClickListener(
        OnSizeItemClickListener onSizeItemClickListener) {
        this.onSizeItemClickListener = onSizeItemClickListener;
    }

    private void updateDatas(int position) {
        for (int i = 0; i < sizeVMS.size(); i++) {
            sizeVMS.get(i).setSelect(i == position);
        }
        notifyDataSetChanged();
    }

    public void updateDatas(String sizeName) {
        for (int i = 0; i < sizeVMS.size(); i++) {
            sizeVMS.get(i).setSelect( sizeVMS.get(i).getSizeName().equals(sizeName));
        }
        notifyDataSetChanged();
    }

    public interface OnSizeItemClickListener {

        void onSizeItemClick(int position);
    }

    class SizeSelectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_single_select)
        ImageView ivSingleSelect;

        @BindView(R.id.tv_single_select)
        RobotoRegularTextView tvSingleSelect;

        public SizeSelectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SizeVM sizeVM, int position) {
            ivSingleSelect.setSelected(sizeVM.isSelect());
            tvSingleSelect.setText(sizeVM.getSizeName());
            itemView.setOnClickListener(
                v -> {
                    updateDatas(position);
                    onSizeItemClickListener.onSizeItemClick(position);
                });
        }
    }
}

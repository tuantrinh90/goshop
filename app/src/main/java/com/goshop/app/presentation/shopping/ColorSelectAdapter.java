package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ColorVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColorSelectAdapter extends RecyclerView.Adapter {

    private OnColorItemClickListener onColorItemClickListener;

    private List<ColorVM> colorVMS;

    public ColorSelectAdapter(
        List<ColorVM> colorVMS) {
        this.colorVMS = colorVMS;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_alert_single, parent, false);
        return new ColorSelectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ColorSelectViewHolder) holder).bindingData(colorVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return colorVMS.size();
    }

    public void setOnColorItemClickListener(
        OnColorItemClickListener onColorItemClickListener) {
        this.onColorItemClickListener = onColorItemClickListener;
    }

    private void updateDatas(int position) {
        for (int i = 0; i < colorVMS.size(); i++) {
            colorVMS.get(i).setSelect(i == position);
        }
        notifyDataSetChanged();
    }

    public void updateDatas(String colorName) {
        for (int i = 0; i < colorVMS.size(); i++) {
            colorVMS.get(i).setSelect( colorVMS.get(i).getColorName().equals(colorName));
        }
        notifyDataSetChanged();
    }

    public interface OnColorItemClickListener {

        void onColorItemClick(int position);
    }

    class ColorSelectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_single_select)
        ImageView ivSingleSelect;

        @BindView(R.id.tv_single_select)
        RobotoRegularTextView tvSingleSelect;

        public ColorSelectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(ColorVM colorVM, int position) {
            ivSingleSelect.setSelected(colorVM.isSelect());
            tvSingleSelect.setText(colorVM.getColorName());
            itemView.setOnClickListener(
                v -> {
                    updateDatas(position);
                    onColorItemClickListener.onColorItemClick(position);
                });
        }
    }
}

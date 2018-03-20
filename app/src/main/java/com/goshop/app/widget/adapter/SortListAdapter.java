package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.Typefaces;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.SortVM;
import com.goshop.app.widget.listener.OnSortListItemClickListener;

import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SortListAdapter extends RecyclerView.Adapter {

    private OnSortListItemClickListener itemClickListener;

    private List<SortVM> sortVMS;

    public SortListAdapter(List<SortVM> sortVMS) {
        this.sortVMS = sortVMS;
    }

    public void updateSort(int position) {
        for (int i = 0; i < sortVMS.size(); i++) {
            sortVMS.get(i).setSelect(position == i);
        }
        notifyDataSetChanged();
    }

    public void setOnSortListItemClickListener(OnSortListItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View sortView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_sort_select, parent, false);
        return new SortViewHolder(sortView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((SortViewHolder) holder).bindingData(sortVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return sortVMS.size();
    }

    class SortViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_sort_select)
        RobotoLightTextView tvSortSelect;

        public SortViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(SortVM sortVM, int position) {
            tvSortSelect.setSelected(sortVM.isSelect());
            tvSortSelect.setText(sortVM.getTitle());
            Typeface face = Typefaces.get(itemView.getContext(), sortVM
                .isSelect() ? Typefaces.PATH_FONT_ROBOTO_REGULAR : Typefaces
                .PATH_FONT_ROBOTO_LIGHT);
            tvSortSelect.setTypeface(face);
            tvSortSelect.setOnClickListener(v -> {
                updateSort(position);
                itemClickListener.onSortItemClick(position);
            });
        }
    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.presentation.model.FAQVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FAQAdapter extends RecyclerView.Adapter {

    private List<FAQVM> faqvms;

    public FAQAdapter(List<FAQVM> faqvms) {
        this.faqvms = faqvms;
    }

    public void updateDatas(List<FAQVM> faqvms) {
        this.faqvms.clear();
        this.faqvms = faqvms;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_help_support_content, parent, false);
        return new ContentViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ContentViewHolder) holder).bindingDatas(faqvms.get(position));
    }

    @Override
    public int getItemCount() {
        return faqvms.size();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_help_support_content)
        CustomTextView tvHelpSupportContent;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(FAQVM faqvm) {
            tvHelpSupportContent.setText(faqvm.getLabel());
        }
    }
}

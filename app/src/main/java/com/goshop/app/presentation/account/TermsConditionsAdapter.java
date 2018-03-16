package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.TermsConditionsVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TermsConditionsAdapter extends RecyclerView.Adapter {

    private OnTermsItemClickListener onTermsItemClickListener;

    private List<TermsConditionsVM> termsConditionsVMS;

    public TermsConditionsAdapter(List<TermsConditionsVM> termsConditionsVMS,
        OnTermsItemClickListener onTermsItemClickListener) {
        this.termsConditionsVMS = termsConditionsVMS;
        this.onTermsItemClickListener = onTermsItemClickListener;
    }

    public void updateDatas(List<TermsConditionsVM> termsConditionsVMS) {
        this.termsConditionsVMS.clear();
        this.termsConditionsVMS = termsConditionsVMS;
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
        ((ContentViewHolder) holder).bindingDatas(termsConditionsVMS.get(position));
    }

    @Override
    public int getItemCount() {
        return termsConditionsVMS.size();
    }

    interface OnTermsItemClickListener {

        void onTermsClick();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_help_support_content)
        RobotoRegularTextView tvHelpSupportContent;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(TermsConditionsVM termsConditionsVM) {
            tvHelpSupportContent.setText(termsConditionsVM.getLabel());
            itemView.setOnClickListener(v -> onTermsItemClickListener.onTermsClick());
        }
    }
}

package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.HelpSupportContentVM;
import com.goshop.app.presentation.model.HelpSupportModel;
import com.goshop.app.presentation.model.HelpSupportTitleVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelpSupportAdapter extends RecyclerView.Adapter {

    private List<HelpSupportModel> helpSupportModels;

    public HelpSupportAdapter(
        List<HelpSupportModel> helpSupportModels) {
        this.helpSupportModels = helpSupportModels;
    }

    public void updateDatas(List<HelpSupportModel> helpSupportModels) {
        this.helpSupportModels.clear();
        this.helpSupportModels = helpSupportModels;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case HelpSupportModel.HELP_TITLE:
                View titleView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_help_support_title, parent, false);
                viewHolder = new TitleViewHolder(titleView);
                break;
            case HelpSupportModel.HELP_CONTENT:
                View contentView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_help_support_content, parent, false);
                viewHolder = new ContentViewHolder(contentView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HelpSupportModel helpSupportModel = helpSupportModels.get(position);
        if (holder instanceof TitleViewHolder) {
            ((TitleViewHolder) holder)
                .bindingDatas(position, (HelpSupportTitleVM) helpSupportModel);
        } else if (holder instanceof ContentViewHolder) {
            ((ContentViewHolder) holder).bindingDatas((HelpSupportContentVM) helpSupportModel);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return helpSupportModels.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return helpSupportModels.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_help_support_title)
        RobotoBoldTextView tvHelpSupportTitle;

        @BindView(R.id.v_help_support_divider)
        View vHelpSupportDivider;

        public TitleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(int position, HelpSupportTitleVM helpSupportTitleVM) {
            int visibility = position == 0 ? View.GONE : View.VISIBLE;
            vHelpSupportDivider.setVisibility(visibility);
            tvHelpSupportTitle.setText(helpSupportTitleVM.getTitle());
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_help_support_content)
        RobotoRegularTextView tvHelpSupportContent;

        public ContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingDatas(HelpSupportContentVM contentVM) {
            tvHelpSupportContent.setText(contentVM.getLabel());
            if (contentVM.getHelpContentClickListener() != null) {
                itemView
                    .setOnClickListener(
                        v -> contentVM.getHelpContentClickListener().onContentClick());
            }

        }
    }
}

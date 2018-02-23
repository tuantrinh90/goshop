package com.goshop.app.widget;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.presentation.model.widget.WidgetTitleExpandVM;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetTitleViewHolder extends RecyclerView.ViewHolder {

    ExpandTitleClickListener expandTitleClickListener;

    @BindView(R.id.iv_item_title_expand)
    ImageView ivItemTitleExpand;

    @BindView(R.id.rl_expand_title)
    RelativeLayout rlExpandTitle;

    @BindView(R.id.tv_item_title_expand)
    CustomBoldTextView tvItemTitleExpand;

    public WidgetTitleViewHolder(View itemView, ExpandTitleClickListener expandTitleClickListener) {
        super(itemView);
        this.expandTitleClickListener = expandTitleClickListener;
        ButterKnife.bind(this, itemView);
    }

    void bindingData(WidgetTitleExpandVM expandVM, int position) {
        tvItemTitleExpand.setText(expandVM.getTitle());
        if (expandVM.isClickable()) {
            //todo(helen)wait for api
            ivItemTitleExpand.setVisibility(View.VISIBLE);
            ivItemTitleExpand.setSelected(expandVM.isExpand());
            rlExpandTitle.setSelected(expandVM.isExpand());

            rlExpandTitle.setOnClickListener(v -> {
                expandVM.setExpand(!expandVM.isExpand());
                rlExpandTitle.setSelected(expandVM.isExpand());
                ivItemTitleExpand.setSelected(expandVM.isExpand());
                if (expandVM.isExpand()) {
                    expandTitleClickListener.expand(position);
                } else {
                    expandTitleClickListener.closed(position);
                }
            });
        } else {
            ivItemTitleExpand.setVisibility(View.GONE);
            rlExpandTitle.setSelected(true);
            rlExpandTitle.setOnClickListener(null);
        }
    }

    public interface ExpandTitleClickListener {

        void expand(int position);

        void closed(int position);
    }
}

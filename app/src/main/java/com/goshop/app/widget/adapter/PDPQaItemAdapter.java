package com.goshop.app.widget.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoBoldTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.widget.QAVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDPQaItemAdapter extends RecyclerView.Adapter {

    private List<QAVM> qavms;

    public PDPQaItemAdapter(List<QAVM> qavms) {
        this.qavms = qavms;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_qa, parent, false);
        return new QaItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((QaItemViewHolder) holder).bindingData(qavms.get(position));
    }

    @Override
    public int getItemCount() {
        return qavms.size();
    }

    class QaItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_pdp_qa_title)
        RobotoBoldTextView tvPdpQaTitle;

        @BindView(R.id.tv_qa_item_answer_count)
        RobotoRegularTextView tvQaItemAnswerCount;

        @BindView(R.id.tv_qa_item_update)
        RobotoRegularTextView tvQaItemUpdate;

        public QaItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(QAVM qavm) {
            tvPdpQaTitle.setText(qavm.getTitle());
            tvQaItemAnswerCount.setText(qavm.getAnswersAmount());
            tvQaItemUpdate.setText(qavm.getUpdateDate());
        }
    }
}

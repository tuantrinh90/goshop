package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QADetailAdapter extends RecyclerView.Adapter {

    private List<QuestionAnswerDataVM> dataVMS;

    public QADetailAdapter(
        List<QuestionAnswerDataVM> dataVMS) {
        this.dataVMS = dataVMS;
    }

    public void setUpdateDatas(List<QuestionAnswerDataVM> dataVMS) {
        this.dataVMS.clear();
        this.dataVMS = dataVMS;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_question_answer_detail, parent, false);
        return new QADetailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((QADetailViewHolder) holder).bindingData(dataVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return dataVMS.size();
    }

    class QADetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_qa_detail_title)
        RobotoLightTextView tvQaDetailTitle;

        @BindView(R.id.tv_qa_detail_user)
        RobotoLightTextView tvQaDetailUser;

        public QADetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(QuestionAnswerDataVM dataVM, int position) {
            tvQaDetailTitle.setText(dataVM.getTitle());
            tvQaDetailUser.setText(dataVM.getUser());
        }
    }
}

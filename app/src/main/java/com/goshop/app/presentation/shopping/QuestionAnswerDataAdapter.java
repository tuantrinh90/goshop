package com.goshop.app.presentation.shopping;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoLightTextView;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionAnswerDataAdapter extends RecyclerView.Adapter {

    private List<QuestionAnswerDataVM> dataVMS;

    private OnQuestionAnswerItemClickListener itemClickListener;

    public QuestionAnswerDataAdapter(
        List<QuestionAnswerDataVM> dataVMS) {
        this.dataVMS = dataVMS;
    }

    public void setUpdataDates(List<QuestionAnswerDataVM> dates) {
        this.dataVMS.clear();
        this.dataVMS = dates;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_question_answer, parent, false);
        return new QuestionAnswerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((QuestionAnswerViewHolder) holder).bindingData(dataVMS.get(position), position);
    }

    @Override
    public int getItemCount() {
        return dataVMS.size();
    }

    public void setOnQuestionAnswerItemClickListener(
        OnQuestionAnswerItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    interface OnQuestionAnswerItemClickListener {

        void onQAItemClick();
    }

    class QuestionAnswerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_question_answer_content)
        RobotoLightTextView tvQuestionAnswerContent;

        @BindView(R.id.tv_question_answer_counts)
        RobotoLightTextView tvQuestionAnswerCounts;

        @BindView(R.id.tv_question_answer_title)
        RobotoMediumTextView tvQuestionAnswerTitle;

        @BindView(R.id.tv_question_answer_update)
        RobotoLightTextView tvQuestionAnswerUpdate;

        public QuestionAnswerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(QuestionAnswerDataVM questionAnswerDataVM, int position) {
            tvQuestionAnswerTitle.setText(questionAnswerDataVM.getTitle());
            tvQuestionAnswerContent.setText(questionAnswerDataVM.getContent());
            tvQuestionAnswerCounts.setText(questionAnswerDataVM.getCount());
            tvQuestionAnswerUpdate.setText(questionAnswerDataVM.getDate());
            itemView.setOnClickListener(v -> itemClickListener.onQAItemClick());
        }
    }
}

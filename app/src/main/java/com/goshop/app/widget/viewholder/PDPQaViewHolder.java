package com.goshop.app.widget.viewholder;

import com.goshop.app.R;
import com.goshop.app.common.view.CustomBoldTextView;
import com.goshop.app.presentation.model.widget.WidgetPDPQaVM;
import com.goshop.app.widget.adapter.PDPQaItemAdapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDPQaViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.recyclerview_qa)
    RecyclerView recyclerViewQA;

    @BindView(R.id.tv_answers_num)
    CustomBoldTextView tvAnswersNum;

    @BindView(R.id.tv_btn_add_more)
    CustomBoldTextView tvBtnAddMore;

    @BindView(R.id.tv_question_num)
    CustomBoldTextView tvQuestionNum;

    public PDPQaViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindingData(WidgetPDPQaVM widgetPDPQaVM) {
        tvAnswersNum.setText(widgetPDPQaVM.getAnswersCounts());
        tvQuestionNum.setText(widgetPDPQaVM.getQuestionCounts());
        LinearLayoutManager manager = new LinearLayoutManager(itemView.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewQA.setLayoutManager(manager);
        PDPQaItemAdapter detailAdapter = new PDPQaItemAdapter(widgetPDPQaVM.getQavms());
        recyclerViewQA.setAdapter(detailAdapter);
        tvBtnAddMore.setOnClickListener(v -> {
            //TODO  need decide
        });
    }
}

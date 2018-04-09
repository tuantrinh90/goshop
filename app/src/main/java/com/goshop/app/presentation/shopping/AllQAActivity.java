package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.model.QuestionAnswerVM;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class AllQAActivity extends BaseActivity<AllQAContract.Presenter> implements AllQAContract
    .View, QuestionAnswerDataAdapter.OnQuestionAnswerItemClickListener {

    @BindView(R.id.et_all_qa_enter)
    RobotoRegularEditText etAllQaEnter;

    @BindView(R.id.ll_qa_top_toolbar)
    LinearLayout llQaTopToolbar;

    @BindView(R.id.recyclerview_all_qa)
    RecyclerView recyclerviewAllQa;

    @BindView(R.id.rl_all_qa_bottom)
    RelativeLayout rlAllQaBottom;

    @BindView(R.id.tv_all_qa_answers)
    RobotoMediumTextView tvAllQaAnswers;

    @BindView(R.id.tv_all_qa_question)
    RobotoMediumTextView tvAllQaQuestion;

    @BindView(R.id.tv_all_qa_submit)
    RobotoMediumTextView tvAllQaSubmit;

    private QuestionAnswerDataAdapter dataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.allQARequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_all_qa;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
        initRecyclerView();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerviewAllQa.setLayoutManager(layoutManager);
        dataAdapter = new QuestionAnswerDataAdapter(new ArrayList<>());
        recyclerviewAllQa.setAdapter(dataAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.all_qa);
    }

    @Override
    public void showAllQAResult(QuestionAnswerVM questionAnswerVM) {
        tvAllQaQuestion.setText(questionAnswerVM.getQuestionTotal());
        tvAllQaAnswers.setText(questionAnswerVM.getAnswerTotal());
        dataAdapter.setUpdataDates(questionAnswerVM.getDataVMS());
        dataAdapter.setOnQuestionAnswerItemClickListener(this::onQAItemClick);
    }

    @Override
    public void onQAItemClick() {
        startActivity(new Intent(this, QuestionAnswerDetailActivity.class));
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_all_qa_submit})
    public void onAllQAClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_all_qa_submit:
                break;
        }
    }
}

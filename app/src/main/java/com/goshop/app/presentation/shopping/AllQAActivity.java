package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.presentation.model.QuestionAnswerVM;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

    @BindView(R.id.fl_connection_break)
    FrameLayout flConnectionBreak;

    @BindView(R.id.rl_all_qa_data)
    RelativeLayout rlAllQaData;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private QuestionAnswerDataAdapter dataAdapter;

    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.listProductQA(page, false);
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
        initSwipRefreshLayout();
    }

    private void initSwipRefreshLayout() {
        swipeRefreshLayout.setColorSchemeResources(R.color.color_main_pink);
        swipeRefreshLayout.setOnRefreshListener(()->{
            page = 1;
            mPresenter.listProductQA(page, true);});
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
    public void showRequestSuccess(QuestionAnswerVM questionAnswerVM) {
        rlAllQaData.setVisibility(View.VISIBLE);
        tvAllQaQuestion.setText(questionAnswerVM.getQuestionTotal());
        tvAllQaAnswers.setText(questionAnswerVM.getAnswerTotal());
        dataAdapter.setUpdataDates(questionAnswerVM.getDataVMS());
        dataAdapter.setOnQuestionAnswerItemClickListener(this::onQAItemClick);
    }

    @Override
    public void showRequestFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(tvAllQaSubmit, errorMessage);
        updateLayoutStatus(flConnectionBreak,true);
    }

    @Override
    public void showNetError(String errorMessage) {
        updateLayoutStatus(flConnectionBreak,true);
    }

    @Override
    public void hideDataLayout() {
        rlAllQaData.setVisibility(View.GONE);
    }

    @Override
    public void showSubmitSuccess(String successMessage) {
        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show();
        etAllQaEnter.setText("");
    }

    @Override
    public void stopRefresh() {
        if(swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onQAItemClick() {
        startActivity(new Intent(this, QuestionAnswerDetailActivity.class));
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_all_qa_submit, R.id.tv_net_refresh})
    public void onAllQAClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_all_qa_submit:
                KeyBoardUtils.hideKeyboard(this);
                String question = etAllQaEnter.getText().toString();
                if(TextUtils.isEmpty(question)) {
                    Toast.makeText(this, getResources().getText(R.string.empty_error), Toast.LENGTH_LONG).show();
                    return;
                }
                mPresenter.submitQuestions(question);
                break;
            case R.id.tv_net_refresh:
                updateLayoutStatus(flConnectionBreak, false);
                mPresenter.listProductQA(page, false);
                break;
        }
    }
}

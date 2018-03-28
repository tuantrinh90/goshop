package com.goshop.app.presentation.shopping;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularEditText;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.QuestionAnswerDataVM;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class QuestionAnswerDetailActivity extends BaseActivity<QADetailContract.Presenter>
    implements QADetailContract.View {

    @BindView(R.id.et_qa_detail_enter)
    RobotoRegularEditText etQaDetailEnter;

    @BindView(R.id.ll_qa_detail_top_toolbar)
    LinearLayout llQaDetailTopToolbar;

    @BindView(R.id.recyclerview_qa_detail)
    RecyclerView recyclerviewQaDetail;

    @BindView(R.id.rl_qa_detail_bottom)
    RelativeLayout rlQaDetailBottom;

    @BindView(R.id.tv_qa_detail_submit)
    RobotoMediumTextView tvQaDetailSubmit;

    private QADetailAdapter detailAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo wait for api
        mPresenter.qaDetailRequest(null);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_question_answer_detail;
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
        recyclerviewQaDetail.setLayoutManager(layoutManager);
        detailAdapter = new QADetailAdapter(new ArrayList<>());
        recyclerviewQaDetail.setAdapter(detailAdapter);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.details);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_qa_detail_submit})
    public void onDetailClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_qa_detail_submit:
                break;
        }
    }

    @Override
    public void showQADetail(List<QuestionAnswerDataVM> dataVMS) {
        detailAdapter.setUpdateDatas(dataVMS);
    }
}

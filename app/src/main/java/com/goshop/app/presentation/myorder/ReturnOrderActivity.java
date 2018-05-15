package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.common.CustomAnimEditText;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.ProfileMetaVM;
import com.goshop.app.utils.EditTextUtil;
import com.goshop.app.utils.KeyBoardUtils;
import com.goshop.app.utils.PopWindowUtil;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ReturnOrderActivity extends BaseActivity<ReturnOrderContract.Presenter> implements
    ReturnOrderContract.View, PopWindowUtil.OnPopWindowDismissListener {

    @BindView(R.id.et_return_order_email)
    CustomAnimEditText etReturnOrderEmail;

    @BindView(R.id.tv_return_order_handing)
    RobotoRegularTextView tvReturnOrderHanding;

    @BindView(R.id.et_return_order_mobile)
    CustomAnimEditText etReturnOrderMobile;

    @BindView(R.id.et_return_order_name)
    CustomAnimEditText etReturnOrderName;

    @BindView(R.id.tv_btn_return_order)
    RobotoMediumTextView tvBtnReturnOrder;

    @BindView(R.id.et_return_detail_reason)
    CustomAnimEditText etReturnDetailReason;

    @BindView(R.id.tv_return_reason)
    RobotoRegularTextView tvReturnReason;

    private String reasonCode = "";

    private String reasonDetail = "";

    private List<ProfileMetaVM> reasonCodes;

    private String currentPopType = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getOrderMetadata();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_return_order;
    }

    @Override
    public void inject() {
        reasonCodes = new ArrayList<>();
        hideRightMenu();
        initPresenter();
    }

    private void initPresenter() {
        initPresenterComponent().inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.order_return);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_return_order, R.id.tv_return_reason })
    public void onReturnOrderClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_return_order:
                KeyBoardUtils.hideKeyboard(this);
                String name = etReturnOrderName.getText();
                String email = etReturnOrderEmail.getText();
                String mobile = etReturnOrderMobile.getText();
                String handing = tvReturnOrderHanding.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    etReturnOrderName.setErrorMessage(getResources().getString(R.string.empty_error));
                    return;
                }

                if (TextUtils.isEmpty(email) || !etReturnOrderEmail.isEmail()) {
                    etReturnOrderEmail
                        .setErrorMessage(getResources().getString(R.string.format_email_warning));
                    return;
                }

                if (!TextUtils.isEmpty(mobile) && !etReturnOrderMobile.isMobileNo()) {
                    etReturnOrderMobile
                        .setErrorMessage(getResources().getString(R.string.format_mobile_warning));
                    return;
                }

                mPresenter
                    .returnOrderRequest(name, email, mobile, handing, reasonCode, reasonDetail);
                break;
            case R.id.tv_return_reason:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.REASON_CODE;
                PopWindowUtil.showSingleChoosePop(tvReturnReason,
                    getResources().getString(R.string.choose_reason_code), reasonCodes, this);
                break;
        }
    }

    @Override
    public void returnRequestSuccess() {
        finish();
    }

    @Override
    public void returnRequestFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(tvBtnReturnOrder, errorMessage);
    }

    @Override
    public void returnRequestNetError(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(tvBtnReturnOrder, errorMessage);
    }

    @Override
    public void setReasonCode(List<ProfileMetaVM> reasonCodes) {
        this.reasonCodes.clear();
        this.reasonCodes = reasonCodes;
    }

    @Override
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPopType)) {
            switch (currentPopType) {
                case PopWindowUtil.REASON_CODE:
                    reasonCodes = PopWindowUtil.updateSinglePopDatas(position, reasonCodes);
                    reasonCode = reasonCodes.get(position).getValue();
                    tvReturnReason.setText(reasonCode);
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo this is an empty method
    }
}

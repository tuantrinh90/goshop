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

public class CancelOrderActivity extends BaseActivity<CancelOrderContract.Presenter>
    implements CancelOrderContract.View, PopWindowUtil.OnPopWindowDismissListener {

    @BindView(R.id.et_cancel_order_email)
    CustomAnimEditText etCancelOrderEmail;

    @BindView(R.id.tv_cancel_order_handing)
    RobotoRegularTextView tvCancelOrderHanding;

    @BindView(R.id.et_cancel_order_mobile)
    CustomAnimEditText etCancelOrderMobile;

    @BindView(R.id.et_cancel_order_name)
    CustomAnimEditText etCancelOrderName;

    @BindView(R.id.tv_cancel_reason)
    RobotoRegularTextView tvCancelReason;

    @BindView(R.id.et_cancel_detail_reason)
    CustomAnimEditText etCancelDetailReason;

    @BindView(R.id.tv_btn_cancel_order_submit)
    RobotoMediumTextView tvBtnCancelOrderSubmit;

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
        return R.layout.activity_cancel_order;
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
        return getResources().getString(R.string.order_cancellation_form);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_cancel_order_submit, R.id.tv_cancel_reason})
    public void onCancelOrderClick(View view){
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
                break;
            case R.id.tv_btn_cancel_order_submit:
                KeyBoardUtils.hideKeyboard(this);
                String name = etCancelOrderName.getText();
                String email = etCancelOrderEmail.getText();
                String mobile = etCancelOrderMobile.getText();
                String handing = tvCancelOrderHanding.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    etCancelOrderName.setErrorMessage(getResources().getString(R.string.empty_error));
                    return;
                }

                if (TextUtils.isEmpty(email) || !etCancelOrderEmail.isEmail()) {
                    etCancelOrderEmail
                        .setErrorMessage(getResources().getString(R.string.format_email_warning));
                    return;
                }

                if (!TextUtils.isEmpty(mobile) && !etCancelOrderMobile.isMobileNo()) {
                    etCancelOrderMobile
                        .setErrorMessage(getResources().getString(R.string.format_mobile_warning));
                    return;
                }

                mPresenter
                    .cancelOrderRequest(name, email, mobile, handing, reasonCode, reasonDetail);
                break;
            case R.id.tv_cancel_reason:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.REASON_CODE;
                PopWindowUtil.showSingleChoosePop(tvCancelReason,
                    getResources().getString(R.string.choose_reason_code), reasonCodes, this);
                break;
        }
    }

    @Override
    public void cancelRequestSuccess() {
        finish();
    }

    @Override
    public void cancelRequestFailed(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(tvBtnCancelOrderSubmit, errorMessage);
    }

    @Override
    public void cancelRequestNetError(String errorMessage) {
        PopWindowUtil.showRequestMessagePop(tvBtnCancelOrderSubmit, errorMessage);
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
                    tvCancelReason.setText(reasonCode);
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo this is empty method
    }
}

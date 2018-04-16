package com.goshop.app.presentation.myorder;

import com.goshop.app.GoShopApplication;
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

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class CancelOrderActivity extends BaseActivity<CancelOrderContract.Presenter>
    implements CancelOrderContract.View, PopWindowUtil.OnPopWindowDismissListener {

    @BindView(R.id.et_cancel_order_email)
    CustomAnimEditText etCancelOrderEmail;

    @BindView(R.id.et_cancel_order_handing)
    CustomAnimEditText etCancelOrderHanding;

    @BindView(R.id.et_cancel_order_mobile)
    CustomAnimEditText etCancelOrderMobile;

    @BindView(R.id.et_cancel_order_name)
    CustomAnimEditText etCancelOrderName;

    @BindView(R.id.tv_cancel_reason)
    RobotoRegularTextView tvCancelReason;

    @BindView(R.id.tv_cancel_detail_reason)
    RobotoRegularTextView tvCancelDetailReason;

    @BindView(R.id.tv_btn_cancel_order_submit)
    RobotoMediumTextView tvBtnCancelOrderSubmit;

    private String reasonCode = "";

    private String reasonDetail = "";

    private List<ProfileMetaVM> reasonCodes;

    private List<ProfileMetaVM> reasonDetails;

    private String currentPopType = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reasonCodes = mPresenter.getReasonCodeChooses();
        reasonDetails = mPresenter.getDetailReasonChooses();
    }

    @Override
    public int getContentView() {
        return R.layout.activity_cancel_order;
    }

    @Override
    public void inject() {
        hideRightMenu();
        initPresenter();
    }

    private void initPresenter() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.order_cancellation_form);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_btn_cancel_order_submit, R.id.tv_cancel_reason, R.id.tv_cancel_detail_reason})
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
                String handing = etCancelOrderHanding.getText();
                if(TextUtils.isEmpty(name)) {
                    etCancelOrderName.setErrorMessage(getResources().getString(R.string.empty_error));
                    return;
                }

                if(TextUtils.isEmpty(email) || !etCancelOrderEmail.isEmail()) {
                    etCancelOrderEmail.setErrorMessage(getResources().getString(R.string.format_email_warning));
                    return;
                }

                if(!TextUtils.isEmpty(mobile) && !etCancelOrderMobile.isMobileNo()) {
                    etCancelOrderMobile.setErrorMessage(getResources().getString(R.string.format_mobile_warning));
                    return;
                }

                mPresenter.cancelOrderRequest(name, email, mobile, handing, reasonCode, reasonDetail);
                break;
            case R.id.tv_cancel_reason:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.REASON_CODE;
                PopWindowUtil.showSingleChoosePop(tvCancelReason,
                    getResources().getString(R.string.choose_reason_code), reasonCodes, this);
                break;
            case R.id.tv_cancel_detail_reason:
                EditTextUtil.eidtLoseFocus(view);
                currentPopType = PopWindowUtil.REASON_DETAIL;
                PopWindowUtil.showSingleChoosePop(tvCancelDetailReason,
                    getResources().getString(R.string.choose_reason_detail), reasonDetails, this);
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
    public void onPopItemClick(int position) {
        if (!TextUtils.isEmpty(currentPopType)) {
            switch (currentPopType) {
                case PopWindowUtil.REASON_CODE:
                    reasonCodes = PopWindowUtil.updateSinglePopDatas(position, reasonCodes);
                    reasonCode = reasonCodes.get(position).getValue();
                    tvCancelReason.setText(reasonCode);
                    break;
                case PopWindowUtil.REASON_DETAIL:
                    reasonDetails = PopWindowUtil.updateSinglePopDatas(position, reasonDetails);
                    reasonDetail = reasonDetails.get(position).getValue();
                    tvCancelDetailReason.setText(reasonDetail);
                    break;
            }
        }
    }

    @Override
    public void onDismiss() {
        //todo this is empty method
    }
}

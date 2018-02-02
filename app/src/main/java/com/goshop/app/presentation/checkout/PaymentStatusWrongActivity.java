package com.goshop.app.presentation.checkout;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;

/**
 * Created by helen on 2018/2/2.
 */

public class PaymentStatusWrongActivity extends BaseActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_pament_wrong_status;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.payment_status);
    }

    @Override
    public void inject() {

    }
}

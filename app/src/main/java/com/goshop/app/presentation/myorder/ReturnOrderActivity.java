package com.goshop.app.presentation.myorder;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;

public class ReturnOrderActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getContentView() {
        return R.layout.activity_return_order;
    }

    @Override
    public void inject() {
        hideRightMenu();
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.order_return);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onReturnOrderClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                finish();
            break;
        }
    }
}

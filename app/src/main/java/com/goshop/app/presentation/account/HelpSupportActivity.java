package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseActivity;

/**
 * Created by helen on 2018/1/29.
 */

public class HelpSupportActivity extends BaseActivity{

    @Override
    public int getContentView() {
        return R.layout.activity_help_support;
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.help_support);
    }

    @Override
    public void inject() {

    }
}

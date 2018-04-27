package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.common.view.RobotoMediumTextView;
import com.goshop.app.presentation.goloyalty.MyRewardsActivity;
import com.goshop.app.presentation.myorder.MyOrdersActivity;
import com.goshop.app.presentation.shopping.AllReviewsActivity;
import com.goshop.app.utils.MenuUtil;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnClick;

public class MyAccountLandingActivity extends BaseDrawerActivity {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_my_account_username)
    RobotoMediumTextView tvMyAccountUsername;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public int getContentView() {
        return R.layout.activity_account_landing;
    }

    @Override
    public void inject() {
        setCurrentMenuType(MenuUtil.MENU_TYPE_HEAD_ACCOUNT);
        setContentView(getContentView());
    }

    @Override
    public String getScreenTitle() {
        return getResources().getString(R.string.my_account);
    }

    @OnClick({R.id.imageview_left_menu, R.id.tv_my_account_edit, R.id.rl_account_wishlist, R.id
        .rl_account_orders, R.id
        .rl_account_reviews, R.id.rl_account_address, R.id.rl_account_rewards, R.id
        .rl_account_points, R.id.rl_account_egift})
    public void onAccountLandingClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
            case R.id.tv_my_account_edit:
                intent = new Intent(this, EditProfileActivity.class);
                break;
            case R.id.rl_account_wishlist:
                intent = new Intent(this, MyWishlistActivity.class);
                break;
            case R.id.rl_account_orders:
                intent = new Intent(this, MyOrdersActivity.class);
                break;
            case R.id.rl_account_reviews:
                intent = new Intent(this, AllReviewsActivity.class);
                break;
            case R.id.rl_account_address:
                intent = new Intent(this, MyAddressBookActivity.class);
                break;
            case R.id.rl_account_rewards:
                intent = new Intent(this, MyRewardsActivity.class);
                break;
            case R.id.rl_account_points:
                intent = new Intent(this, MyPointsActivity.class);
                break;
            case R.id.rl_account_egift:
                intent = new Intent(this, MyEGiftCardsActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}

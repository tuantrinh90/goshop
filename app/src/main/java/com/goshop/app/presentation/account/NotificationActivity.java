package com.goshop.app.presentation.account;

import com.goshop.app.R;
import com.goshop.app.adapter.NotificationAdapter;
import com.goshop.app.base.BaseDrawerActivity;
import com.goshop.app.presentation.model.NotificationVM;
import com.goshop.app.utils.MenuUtil;
import com.goshop.app.utils.ScreenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class NotificationActivity extends BaseDrawerActivity<NotificationContract.Presenter>
    implements NotificationContract.View, NotificationAdapter.OnNotificationItemClickListener {

    @BindView(R.id.imageview_left_menu)
    ImageView imageViewLeftMenu;

    @BindView(R.id.recyclerview_notification)
    RecyclerView recyclerviewNotification;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void notificationResult(List<NotificationVM> notificationVMS) {
        recyclerviewNotification.setLayoutManager(new LinearLayoutManager(this));
        NotificationAdapter notificationAdapter = new NotificationAdapter(notificationVMS);
        recyclerviewNotification.setAdapter(notificationAdapter);
        notificationAdapter.setOnNotificationItemClickListener(this::onNotificationItemClick);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo wait for api
        mPresenter.notificationRequest(new HashMap<>());
    }

    @Override
    public int getContentView() {
        return R.layout.activity_notification;
    }

    @Override
    public void inject() {
        initPresenterComponent().inject(this);
        setCurrentMenuType(MenuUtil.MENU_TYPE_NOTIFICATIONS);
        setContentView(getContentView());
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.home_drawlayout_notifications);
    }

    @OnClick({R.id.imageview_left_menu})
    public void onCategoryClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_left_menu:
                if (MenuUtil.TYPE_ENTRANCE_DRAWER.equals(entranceType)) {
                    openDrawerLayout();
                } else {
                    finish();
                }
                break;
        }
    }

    @Override
    public void onNotificationItemClick(int position) {
        startActivity(new Intent(this, WebContentActivity.class));
    }
}

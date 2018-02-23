package com.goshop.app.presentation.account;

import com.goshop.app.GoShopApplication;
import com.goshop.app.R;
import com.goshop.app.adapter.NotificationAdapter;
import com.goshop.app.base.BaseActivity;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.goshop.app.utils.ScreenHelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;
import injection.components.DaggerPresenterComponent;
import injection.modules.PresenterModule;

public class NotificationActivity extends BaseActivity<NotificationContract.Presenter>
    implements NotificationContract.View {

    @BindView(R.id.imageview_left_menu)
    ImageView imageviewLeftMenu;

    @BindView(R.id.recyclerview_notification)
    RecyclerView recyclerviewNotification;

    @Override
    public void notificationResult(NotificationsResponse notificationsResponse) {
        recyclerviewNotification.setLayoutManager(new LinearLayoutManager(this));
        NotificationAdapter notificationAdapter = new NotificationAdapter(
            notificationsResponse.getNotificationBean());
        notificationAdapter.setiRecyclerItemClick((view, position) -> {
            //TODO skip to webView container
        });
        recyclerviewNotification.setAdapter(notificationAdapter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.notificationRequest(new HashMap<>());
    }

    @Override
    public int getContentView() {
        return R.layout.activity_notification;
    }

    @Override
    public void inject() {
        DaggerPresenterComponent.builder()
            .applicationComponent(GoShopApplication.getApplicationComponent())
            .presenterModule(new PresenterModule(this))
            .build()
            .inject(this);
    }

    @Override
    public String getScreenTitle() {
        return ScreenHelper.getString(R.string.home_drawlayout_notifications);
    }

    @OnClick(R.id.imageview_left_menu)
    public void onViewClicked() {
        finish();
    }
}

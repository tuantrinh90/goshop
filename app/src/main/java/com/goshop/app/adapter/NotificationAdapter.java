package com.goshop.app.adapter;

import com.goshop.app.R;
import com.goshop.app.common.listener.IRecyclerItemClick;
import com.goshop.app.common.view.CustomTextView;
import com.goshop.app.data.model.response.NotificationsResponse;
import com.jakewharton.rxbinding2.view.RxView;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter {

    private List<NotificationsResponse.NotificationBean> notifications = new ArrayList<>();

    public NotificationAdapter(
        List<NotificationsResponse.NotificationBean> notifications) {
        this.notifications = notifications;
    }

    IRecyclerItemClick iRecyclerItemClick;

    public void setiRecyclerItemClick(IRecyclerItemClick iRecyclerItemClick) {
        this.iRecyclerItemClick = iRecyclerItemClick;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_notification_content, parent, false);
        return new NotificationHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        NotificationHolder holder = (NotificationHolder) viewHolder;
        NotificationsResponse.NotificationBean notificationBean = notifications.get(position);
        holder.viewNotificationIcon
            .setVisibility(notificationBean.isNew() ? View.VISIBLE : View.INVISIBLE);
        holder.tvNotificationName.setText(notificationBean.getNotifyName());
        holder.tvNotificationDate.setText(notificationBean.getHour() + notificationBean.getDate());
        RxView.clicks(holder.itemView).subscribe(v -> {
            if (iRecyclerItemClick != null) {
                iRecyclerItemClick.onItemClick(holder.itemView, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    static class NotificationHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_notification_icon)
        View viewNotificationIcon;

        @BindView(R.id.tv_notification_name)
        CustomTextView tvNotificationName;

        @BindView(R.id.tv_notification_date)
        CustomTextView tvNotificationDate;

        public NotificationHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}

package com.goshop.app.adapter;

import com.goshop.app.R;
import com.goshop.app.common.view.RobotoRegularTextView;
import com.goshop.app.presentation.model.NotificationVM;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationAdapter extends RecyclerView.Adapter {

    private List<NotificationVM> notificationVMS;

    private OnNotificationItemClickListener onNotificationItemClickListener;

    public NotificationAdapter(List<NotificationVM> notificationVMS) {
        this.notificationVMS = notificationVMS;
    }

    public void setUpdateDatas(List<NotificationVM> notificationVMS) {
        this.notificationVMS.clear();
        this.notificationVMS = notificationVMS;
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
        NotificationVM notificationVM = notificationVMS.get(position);
        ((NotificationHolder) viewHolder).bindingData(notificationVM, position);
    }

    @Override
    public int getItemCount() {
        return notificationVMS.size();
    }

    public void setOnNotificationItemClickListener(
        OnNotificationItemClickListener onNotificationItemClickListener) {
        this.onNotificationItemClickListener = onNotificationItemClickListener;
    }

    public interface OnNotificationItemClickListener {

        void onNotificationItemClick(int position);
    }

    class NotificationHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_notification_date)
        RobotoRegularTextView tvNotificationDate;

        @BindView(R.id.tv_notification_name)
        RobotoRegularTextView tvNotificationName;

        @BindView(R.id.view_notification_icon)
        View viewNotificationIcon;

        public NotificationHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindingData(NotificationVM notificationVM, int position) {
            viewNotificationIcon
                .setVisibility(notificationVM.isVisible() ? View.VISIBLE : View.GONE);
            tvNotificationDate.setText(notificationVM.getDate());
            tvNotificationName.setText(notificationVM.getTitle());
            itemView.setOnClickListener(v -> onNotificationItemClickListener.onNotificationItemClick(position));
        }
    }
}

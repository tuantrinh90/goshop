package com.goshop.app.data.model.response;

import java.util.List;

/**
 * Created by img on 2018/2/5.
 */

public class NotificationsResponse {

    private List<NotificationBean> notificationBean;

    public List<NotificationBean> getNotificationBean() {
        return notificationBean;
    }

    public void setNotificationBean(
        List<NotificationBean> notificationBean) {
        this.notificationBean = notificationBean;
    }

    public static class NotificationBean {

        private String notifyName;

        private String hour;

        private String date;

        private boolean isNew;

        public String getNotifyName() {
            return notifyName;
        }

        public void setNotifyName(String notifyName) {
            this.notifyName = notifyName;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public boolean isNew() {
            return isNew;
        }

        public void setNew(boolean aNew) {
            isNew = aNew;
        }
    }

}

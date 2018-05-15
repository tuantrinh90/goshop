package com.goshop.app.presentation.pushwoosh;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // TODO(developer): Handle FCM messages here.
        //todo this will use later and then delete please dont remove now
        remoteMessage.getFrom();
        if (remoteMessage.getData().size() > 0) {
            //todo this will use later and then delete please dont remove now
            remoteMessage.getData();
        }
        if (remoteMessage.getNotification() != null) {
            //todo this will use later and then delete please dont remove now
            remoteMessage.getNotification().getBody();
        }
    }


}

package com.example.lucky;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title, String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "My Notification")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.h)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999, builder.build());
    }
}

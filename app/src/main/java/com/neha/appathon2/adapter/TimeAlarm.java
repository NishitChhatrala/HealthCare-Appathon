package com.neha.appathon2.adapter;

//package com.example.good.appathon;

/**
 * Created by good on 9/4/16.
 */
        import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.neha.appathon2.R;

public class TimeAlarm extends BroadcastReceiver {

    Notification myNotication;
    NotificationManager manager;

    @Override
    public void onReceive(Context arg0, Intent arg1) {

        manager = (NotificationManager) arg0.getSystemService(arg0.NOTIFICATION_SERVICE);
        Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();
        System.out.println("Has arrived inside Receiver");
        // Call Service
        // Intent service = new Intent(arg0, ChartNotifierService.class);

        //  arg0.startService(service);

        Intent intent = new Intent("com.example.good.appathon.DiseaseActivity");

        PendingIntent pendingIntent = PendingIntent.getActivity(arg0, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(arg0);

        builder.setAutoCancel(false);
        builder.setTicker("Medicentre notification");
        builder.setContentTitle("MediCentre Notification");
        builder.setContentText("Time for vaccine");



        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        builder.setSubText("This is subtext...");   //API level 16
        builder.setNumber(100);
        builder.build();

        myNotication = builder.getNotification();
        manager.notify(11, myNotication);



    }
/*
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm=null;
        nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(context, intent.getExtras().getInt("ID"),
                intent, 0);
        Notification notif = new Notification(android.R.drawable.ic_dialog_alert,
                "Appathon",System.currentTimeMillis());
        notif.defaults |= Notification.DEFAULT_SOUND;
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
      //  notif.setLatestEventInfo(context, "Appathon",intent.getExtras().getString("NOTIFICATION"), contentIntent);
        notif.when=intent.getExtras().getLong("LONG");
        nm.notify(intent.getExtras().getInt("ID"), notif);
        //  context.startActivity(new Intent(context, ReservationListing.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
*/

}


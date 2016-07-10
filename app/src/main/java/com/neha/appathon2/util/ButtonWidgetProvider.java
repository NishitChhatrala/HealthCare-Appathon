package com.neha.appathon2.util;

//package com.neha.appathon2;

/**
 * Created by neha on 9/4/16.
 */

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.neha.appathon2.R;

public class ButtonWidgetProvider extends AppWidgetProvider {

    private static final String ACTION_CALL = "ACTION_CALL";


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Log.d(LOG_TAG, "onUpdate(): ");
        for (int appWidgetId : appWidgetIds) {

            Intent callIntent = new Intent(Intent.ACTION_CALL);
            String number = "8460770916";
            callIntent.setData(Uri.parse("tel:" + number));
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, callIntent, 0);

            // Get the layout for the App Widget and attach an on-click listener to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            views.setOnClickPendingIntent(R.id.widget_panic, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current App Widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
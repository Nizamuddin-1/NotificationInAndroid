package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private static final String CHANNEL_ID ="My channel";
    private static final int NOTIFICATION_ID =100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable d = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_baseline_bike_scooter_24,null);
        BitmapDrawable s = (BitmapDrawable) d;
        Bitmap b =  s.getBitmap();
        NotificationManager n = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification a;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                     a = new Notification.Builder(this)
                    .setLargeIcon(b)
                    .setSmallIcon(R.drawable.ic_baseline_bike_scooter_24)
                    .setContentText("Message")
                    .setSubText("New Message from Nizam")
                    .setChannelId(CHANNEL_ID)
                    .build();
                     n.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"New Channel",NotificationManager.IMPORTANCE_HIGH));
        }
        else
        {
            a = new Notification.Builder(this)
                    .setLargeIcon(b)
                    .setSmallIcon(R.drawable.ic_baseline_bike_scooter_24)
                    .setContentText("Message")
                    .setSubText("New Message from Nizam")
                    .build();
        }
         n.notify(NOTIFICATION_ID,a);

    }
}
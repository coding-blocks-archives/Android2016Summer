package com.codingblocks.lecturenineasyncnetservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class MyService extends Service {

    public static final String TAG = "MyService";


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);

        long startTime = SystemClock.uptimeMillis();
        while (SystemClock.uptimeMillis() < startTime + 10000) {
            Log.d(TAG, "loop: ");
        }

        Log.d(TAG, "onStartCommand: ");

        return result;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }


}

package com.codingblocks.broadcastreceivers;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class BatteryMonitorService extends Service {

    public static final String TAG = "BMS";

    public BatteryMonitorService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(BatteryMonitorService.this, "Service Created", Toast.LENGTH_SHORT).show();
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(BatteryMonitorService.this, "Plug State Changed", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }
}

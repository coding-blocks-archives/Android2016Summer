package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.BatteryManager;
import android.util.Log;
import android.view.View;

public class PlugStateReceiver extends BroadcastReceiver {

    public static final String TAG = "PSR";

    public PlugStateReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());

        Intent i = new Intent(context, BatteryMonitorService.class);
        context.startService(i);

    }


}

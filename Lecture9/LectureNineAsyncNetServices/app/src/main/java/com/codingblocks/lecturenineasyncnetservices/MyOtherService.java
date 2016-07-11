package com.codingblocks.lecturenineasyncnetservices;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by championswimmer on 03/07/16.
 */
public class MyOtherService extends IntentService {

    public static final String TAG = "MyOtherSerivce";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyOtherService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long startTime = SystemClock.uptimeMillis();
        while (SystemClock.uptimeMillis() < startTime + 10000) {
            Log.d(TAG, "loop: ");
        }

    }
}

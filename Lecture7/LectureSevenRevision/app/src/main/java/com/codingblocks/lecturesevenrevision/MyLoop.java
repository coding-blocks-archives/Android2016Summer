package com.codingblocks.lecturesevenrevision;

import android.os.SystemClock;
import android.util.Log;

/**
 * Created by championswimmer on 28/06/16.
 */
public class MyLoop {
    public static final String TAG = "MyLoop";



    private LoopDoneListener ldl;

    public void setLoopDoneListener (LoopDoneListener doneListener) {
        ldl = doneListener;
    }

    public void doLoop () {
        ldl.onLoopStart();
        long startTime = SystemClock.uptimeMillis();

        while ((SystemClock.uptimeMillis() - startTime) < 10000) {

        }
        Log.d(TAG, "doLoop: is done");
        ldl.onLoopDone();
    }

    public interface LoopDoneListener {
        void onLoopStart();
        void onLoopDone();
    }
}

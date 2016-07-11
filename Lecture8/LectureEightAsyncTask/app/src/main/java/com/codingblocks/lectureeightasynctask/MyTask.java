package com.codingblocks.lectureeightasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

/**
 * Created by championswimmer on 28/06/16.
 */
public class MyTask extends AsyncTask<String, Void, Long> {
    public static final String TAG = "MyTask";

    private Context ctx;

    private int a;

    public MyTask(Context c) {
        ctx = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        a = 10;
    }

    @Override
    protected Long doInBackground(String... params) {

        if (a == 10 ) {
            //true
        }

        long startTime = SystemClock.uptimeMillis();
        long timesRun = 0;
        while ((SystemClock.uptimeMillis() - startTime) < 10000) {
            timesRun++;

        }

        return timesRun;
    }

    @Override
    protected void onPostExecute(Long mLong) {
        super.onPostExecute(mLong);

        Log.d(TAG, "onPostExecute: ran " + mLong + " times");
    }
}

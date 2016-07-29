package com.codingblocks.pushmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by championswimmer on 28/07/16.
 */
public class IdService extends FirebaseInstanceIdService {
    public static final String TAG = "IdService";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        Log.d(TAG, "onTokenRefresh: ");
    }

    public IdService() {
        super();
        Log.d(TAG, "IdService: ");
    }
}

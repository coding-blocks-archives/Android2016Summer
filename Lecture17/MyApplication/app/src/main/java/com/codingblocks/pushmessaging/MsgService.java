package com.codingblocks.pushmessaging;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by championswimmer on 28/07/16.
 */
public class MsgService extends FirebaseMessagingService {

    public static final String TAG = "MsgService";

    public MsgService() {
        super();
        Log.d(TAG, "MsgService: ");
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String token= FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onMessageReceived: token = " + token);

        Log.d(TAG, "onMessageReceived: ");
        Log.d(TAG, "onMessageReceived: Id = " + remoteMessage.getMessageId());

        Map<String, String> msgData = remoteMessage.getData();
        for (String s : msgData.keySet()) {
            Log.d(TAG, "onMessageReceived: " + s + " : " + msgData.get(s));
        }
    }
}

package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";
    BroadcastReceiver otherReceiver;
    IntentFilter intentFilter;

    TextView tvChargeState, tvChargeSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvChargeSource = (TextView) findViewById(R.id.tv_charge_source);
        tvChargeState = (TextView) findViewById(R.id.tv_charge_state);

        otherReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int chargeState = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                int source = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                Log.d(TAG, "onReceive: " + chargeState);
                Log.d(TAG, "onReceive: " + source);
                setChargeStateTv(chargeState);
                setChargeSource(source);
            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);


    }

    public void setChargeStateTv (int state) {
        String chState;
        switch (state) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
                chState = "CHARGING";
                tvChargeState.setTextColor(Color.GREEN);
                tvChargeSource.setVisibility(View.VISIBLE);
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING:
                chState = "DISCHARGING";
                tvChargeSource.setVisibility(View.INVISIBLE);
                tvChargeState.setTextColor(Color.RED);
                break;
            case -1:
            default:
                chState = "unknown";
                break;
        }
        tvChargeState.setText(chState);
    }

    public void setChargeSource (int source) {
        String chSource;
        switch (source) {
            case BatteryManager.BATTERY_PLUGGED_USB:
                chSource = "USB";
                break;
            case BatteryManager.BATTERY_PLUGGED_AC:
                chSource = "AC";
                break;
            default:
                chSource = "UNKNOWN";
                break;
        }
        tvChargeSource.setText("SOURCE = " + chSource);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(otherReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(otherReceiver);
        super.onPause();
    }
}

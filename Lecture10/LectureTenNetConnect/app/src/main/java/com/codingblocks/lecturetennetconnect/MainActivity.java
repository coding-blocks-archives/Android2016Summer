package com.codingblocks.lecturetennetconnect;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDownload;
    TextView tvEvName, tvEvType, tvEvTopic, tvEvLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownload = (Button) findViewById(R.id.btn_download);

        tvEvName = (TextView) findViewById(R.id.event_name);
        tvEvTopic = (TextView) findViewById(R.id.event_topic);
        tvEvType = (TextView) findViewById(R.id.event_type);
        tvEvLoc = (TextView) findViewById(R.id.event_loc);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnectionAndRequest();
            }
        });


    }

    public void checkConnectionAndRequest () {
        ConnectivityManager cMgr =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cMgr.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            NetFetchTask myTask = new NetFetchTask(new NetFetchTask.PostExecuteListener() {
                @Override
                public void postExecuteDone(Event event) {
                    tvEvName.setText(event.getName());
                    tvEvType.setText(event.getType());
                    tvEvTopic.setText(event.getTopic());
                    tvEvLoc.setText(event.getLocation());
                }
            });
            myTask.execute("https://open-event.herokuapp.com/api/v2/events/4");
        } else {
            Toast.makeText(MainActivity.this, "Will not work without internet", Toast.LENGTH_SHORT).show();
        }
    }



}

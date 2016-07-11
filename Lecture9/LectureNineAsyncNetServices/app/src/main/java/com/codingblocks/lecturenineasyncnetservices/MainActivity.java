package com.codingblocks.lecturenineasyncnetservices;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startServBtn, stopServBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startServBtn = (Button) findViewById(R.id.btn_start_service);
        stopServBtn = (Button) findViewById(R.id.btn_stop_service);

        startServBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.startActionBaz(MainActivity.this,
                        "par1", "par2");

            }
        });

        stopServBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.startActionFoo(MainActivity.this,
                        "par1", "par2");
            }
        });


    }
}

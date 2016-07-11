package com.codingblocks.lecturesevenrevision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyLoop looper = new MyLoop();

        MyLoop.LoopDoneListener loopDoneListener = new MyLoop.LoopDoneListener() {
            @Override
            public void onLoopStart() {
                Toast.makeText(MainActivity.this, "loop is started", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLoopDone() {
                Toast.makeText(MainActivity.this, "loop is done", Toast.LENGTH_SHORT).show();
            }
        };

        looper.setLoopDoneListener(loopDoneListener);

        looper.doLoop();



        Button b = (Button) findViewById(R.id.my_button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                looper.doLoop();

            }
        });




    }
}

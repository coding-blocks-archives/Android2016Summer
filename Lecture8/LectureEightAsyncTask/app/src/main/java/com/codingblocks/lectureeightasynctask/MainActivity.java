package com.codingblocks.lectureeightasynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.my_button);

        final MyTask task = new MyTask(this);



        new AsyncTask<String, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(String... params) {
                return null;
            }
        }.execute();


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (task.getStatus() != AsyncTask.Status.RUNNING
                        && task.getStatus() != AsyncTask.Status.FINISHED) {
                    task.execute("A", "b");
                } else {
                    Toast.makeText(MainActivity.this, "Task already running", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

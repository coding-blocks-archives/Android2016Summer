package com.codingblocks.lecturefourintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_RETURN_STRING = "returnString";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent receivedIntent = getIntent();
        String myName = receivedIntent.getStringExtra(MainActivity.KEY_NAME);

        TextView tvSecondActivity =
                (TextView) findViewById(R.id.tv_second_activity);
        tvSecondActivity.setText("Hello " + myName);

    }

    @Override
    public void onBackPressed() {
        Intent resultIntent  = new Intent();
        resultIntent.putExtra(KEY_RETURN_STRING,
                ((EditText) findViewById(R.id.et_return_string)).getText().toString());

        setResult(RESULT_OK, resultIntent);
        super.onBackPressed();
    }

    @Override
    protected void onStop() {

        Intent resultIntent  = new Intent();
        resultIntent.putExtra(KEY_RETURN_STRING,
                ((EditText) findViewById(R.id.et_return_string)).getText().toString());

        setResult(RESULT_OK, resultIntent);

        super.onStop();


    }
}

package com.codingblocks.lecturefourintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME = "myName";
    public static final int REQUEST_SECOND_ACTIVITY = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToSecondActivity(View v) {

        EditText etInput = (EditText) findViewById(R.id.et_input);

        // EXPLICIT INTENT
        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(KEY_NAME, etInput.getText().toString());
        startActivityForResult(i, REQUEST_SECOND_ACTIVITY);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode) == REQUEST_SECOND_ACTIVITY && (resultCode == RESULT_OK)) {

            TextView tvMainAct = (TextView) findViewById(R.id.tv_main_act);
            tvMainAct.setText(data.getStringExtra(SecondActivity.KEY_RETURN_STRING));

        }
    }


}

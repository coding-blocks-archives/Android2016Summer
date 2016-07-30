package com.codingblocks.androidtests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    TextView tvFare;
    EditText etKm, etTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalc = (Button) findViewById(R.id.btn_calc);
        tvFare = (TextView) findViewById(R.id.tv_fare);
        etKm = (EditText) findViewById(R.id.et_km);
        etTime = (EditText) findViewById(R.id.et_time);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float km = Float.valueOf(etKm.getText().toString());
                int time = Integer.valueOf(etTime.getText().toString());

                tvFare.setText("Fare : " + getFare(km, time));

            }
        });
    }


    public static float getFare(float km, int time) {
        if (km < 0) {
            return 0;
        }

        return 0 + (km < 2 ? 25 : ((km-2) * 9) + 25) + (time < 15 ? 0 : (time - 15));
    }
}

package com.codingblocks.mediaplayback;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            InputStream is = getResources().getAssets().open("data.json");
            BufferedReader br  = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder sb = new StringBuilder();
            do {
                line = br.readLine();
                sb.append(line);
            } while (line != null);
            String jsonString = sb.toString();
            JSONObject jObj = new JSONObject(jsonString);
            Log.d(TAG, "onCreate: " + jObj.getString("somekey"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaPlayer audioPlayer = MediaPlayer.create(this, R.raw.sample);
        audioPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();

            }
        });
        audioPlayer.prepareAsync();
    }
}

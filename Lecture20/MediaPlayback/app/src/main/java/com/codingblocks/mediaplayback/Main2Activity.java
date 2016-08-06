package com.codingblocks.mediaplayback;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        VideoView vv = (VideoView) findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);

        mc.setAnchorView(vv);
        vv.setMediaController(mc);

        vv.setVideoURI(Uri.parse("android.resource://" +
        getPackageName() + "/raw/video"));

        vv.start();

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
}

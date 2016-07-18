package com.codingblocks.permissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainAct";

    String[] reqPerms = new String[] {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    static int REQUEST_CODE_STORAGE_PERM = 445;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnWriteFile = (Button) findViewById(R.id.btn_write_file);
        btnWriteFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasWritePerm()) {
                    writeMyFile();
                } else {
                    askWritePerm();
                }
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_STORAGE_PERM) {

            if (grantResults.length > 0) {
                if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    writeMyFile();
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void askWritePerm () {
        ActivityCompat.requestPermissions(this, reqPerms, REQUEST_CODE_STORAGE_PERM);
    }

    public boolean hasWritePerm () {
        return (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);
    }

    public void writeMyFile () {
        try {
            File myFile = new File(Environment.getExternalStorageDirectory(), "myfile");
            FileOutputStream fOut = new FileOutputStream(myFile);

            fOut.write("Hello".getBytes());
            fOut.close();
        } catch (IOException e) {

        }
    }
}

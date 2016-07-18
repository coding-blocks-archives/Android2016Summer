package com.codingblocks.filesaving;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String fileDirPath = null;
        String cacheDirPath = null;
        try {
            fileDirPath = getFilesDir().getPath();
            cacheDirPath = getCacheDir().getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d(TAG, "onCreate: files dir = " + fileDirPath);
        Log.d(TAG, "onCreate: cache dir = " + cacheDirPath);

//        String filename = "myfile";
//        String string = "Hello world!";
//        FileOutputStream outputStream;
//
//        File myFile = new File(getFilesDir().getPath(), filename);
//
//        if (myFile.canRead()) {
//            Log.d(TAG, "onCreate: 1. can read file = " + filename);
//        }
//
//        try {
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(string.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (myFile.canRead()) {
//            Log.d(TAG, "onCreate: 2. can read file = " + filename);
//        }

        Log.d(TAG, "onCreate: extStor Path = " + Environment.getExternalStorageDirectory().getPath());
        Log.d(TAG, "onCreate: extStor absPath = " + Environment.getExternalStorageDirectory().getAbsolutePath());
        try {
            Log.d(TAG, "onCreate: extStor canPath = " + Environment.getExternalStorageDirectory().getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        Log.d(TAG, "onCreate: DIR_MUSIC = " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getPath());

        Log.d(TAG, "onCreate: canRead = " + isExternalStorageReadable());
        Log.d(TAG, "onCreate: canWrite = " + isExternalStorageWritable());

        File newFile = new File(Environment.getExternalStorageDirectory(), "new_file.txt");
        if ( !newFile.isFile() ) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fStream = new FileOutputStream(newFile, true);
            fStream.write("Hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}

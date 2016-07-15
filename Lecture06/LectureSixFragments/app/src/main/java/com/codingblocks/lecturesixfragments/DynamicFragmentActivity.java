package com.codingblocks.lecturesixfragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DynamicFragmentActivity extends AppCompatActivity {
    public static final String TAG = "DynAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        MyFragment myFrag = new MyFragment();

        MyFragment.MyListener myListener = new MyFragment.MyListener() {
            @Override
            public void myCallback() {
                Toast.makeText(DynamicFragmentActivity.this, "fragment is shown", Toast.LENGTH_SHORT).show();
            }
        };

        myFrag.setMyListener(myListener);

        final FragmentManager fragMgr = getSupportFragmentManager();

        FragmentTransaction fragTxn = fragMgr.beginTransaction();
        fragTxn.add(R.id.fragment_container, myFrag, null);
        fragTxn.commit();



    }

}

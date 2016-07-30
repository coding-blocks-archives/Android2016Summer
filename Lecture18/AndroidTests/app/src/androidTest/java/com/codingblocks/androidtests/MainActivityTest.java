package com.codingblocks.androidtests;

import android.support.test.annotation.UiThreadTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by championswimmer on 30/07/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    MainActivity mainAct;

    @Rule
    public final ActivityTestRule<MainActivity> act =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUpActivity () throws Exception {
        mainAct = act.getActivity();
    }

    @After
    public void finishActivity() throws Exception {
        mainAct.finish();
    }

    @UiThreadTest @Test
    public void simpleFareTest () throws Exception {
        ((EditText)mainAct.findViewById(R.id.et_time)).setText("16");
        ((EditText)mainAct.findViewById(R.id.et_km)).setText("3");
        ((Button)mainAct.findViewById(R.id.btn_calc)).callOnClick();


        assertEquals("Fare : 35.0", ((TextView)mainAct.findViewById(R.id.tv_fare)).getText());

    }
}

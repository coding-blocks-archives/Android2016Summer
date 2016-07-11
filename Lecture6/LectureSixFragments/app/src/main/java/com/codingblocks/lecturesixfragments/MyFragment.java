package com.codingblocks.lecturesixfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private MyListener ml;

    public void setMyListener(MyListener listener) {
        ml = listener;
    }


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (ml != null) {
            ml.myCallback();
        }
        return inflater.inflate(R.layout.fragment_my, container, false);
    }

    public interface MyListener {
        void myCallback();
    }

}

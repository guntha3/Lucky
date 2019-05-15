package com.example.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lucky.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    private View myMainView;

    private ListView listView;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myMainView = inflater.inflate(R.layout.fragment_video, container, false);

        listView = myMainView.findViewById(R.id.listView);

        return myMainView;
    }

}

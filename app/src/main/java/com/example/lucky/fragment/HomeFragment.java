package com.example.lucky.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lucky.R;
import com.example.lucky.tambah.TambahFolder;
import com.example.lucky.tambah.TambahVidio;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View myMainView;

    //CardView tambahfolder;
    ImageButton tambahvidio;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myMainView = inflater.inflate(R.layout.fragment_home, container, false);

        //tambahfolder = myMainView.findViewById(R.id.tambah_folder);
        tambahvidio = myMainView.findViewById(R.id.tambah_video);



        tambahvidio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), TambahVidio.class);
                startActivity(i);

            }
        });


        return myMainView;
    }

}
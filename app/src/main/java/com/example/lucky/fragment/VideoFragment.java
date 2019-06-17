package com.example.lucky.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.lucky.R;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    View myMainView;

    ListView listView;
    Button LoadVid;
    VideoView videoView;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myMainView = inflater.inflate(R.layout.fragment_video, container, false);

        LoadVid = myMainView.findViewById(R.id.LoadVid);
        videoView = myMainView.findViewById(R.id.videoView);

        LoadVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, 0);
            }
        });

        return myMainView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            Uri video = data.getData();


            try {
                videoView.setVideoURI(video);
                videoView.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

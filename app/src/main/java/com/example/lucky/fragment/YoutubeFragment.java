package com.example.lucky.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lucky.R;
import com.example.lucky.youtube.VideoAdapter;
import com.example.lucky.youtube.YoutubeVideos;

import java.util.Vector;

public class YoutubeFragment extends Fragment {
    private View myMainView;

    RecyclerView recyclerView;
    Vector<YoutubeVideos> youtubeVideos = new Vector<YoutubeVideos>();

    public YoutubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myMainView = inflater.inflate(R.layout.fragment_youtube, container, false);

        recyclerView = (RecyclerView) myMainView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eWEF1Zrmdow\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KyJ71G2UxTQ\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/y8Rr39jKFKU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8Hg1tqIwIfI\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uhQ7mh_o_cM\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);


        return myMainView;
    }
}

package com.example.lucky.play;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.lucky.R;

public class VidioPlay extends AppCompatActivity {

    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidio_play);
        mVideoView = findViewById(R.id.videoView);

        Uri videoUri = Uri.parse(getIntent().getExtras().getString("videoUri"));
        mVideoView.setVideoURI(videoUri);
        mVideoView.start();
    }
}

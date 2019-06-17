package com.example.lucky;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.lucky.fragment.HomeFragment;
import com.example.lucky.fragment.VideoFragment;
import com.example.lucky.fragment.YoutubeFragment;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    FrameLayout homeFrame;
    BottomNavigationView navigation;
    HomeFragment homeFragment;
    VideoFragment videoFragment;
    YoutubeFragment youtubeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        homeFrame = findViewById(R.id.homeFrame);

        homeFragment = new HomeFragment();
        videoFragment = new VideoFragment();
        youtubeFragment = new YoutubeFragment();

        Paper.init(this);

        navigation.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.homeFrame, new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected_fragment = null;
                    switch (item.getItemId()){
                        case R.id.navigation_home:
                            selected_fragment = new HomeFragment();
                            break;
                        case R.id.navigation_video:
                            selected_fragment = new VideoFragment();
                            break;
                        case R.id.navigation_youtube:
                            selected_fragment = new YoutubeFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.homeFrame, selected_fragment).commit();

                    return true;
                }
            };
}

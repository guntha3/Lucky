package com.example.lucky;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.lucky.fragment.HomeFragment;
import com.example.lucky.fragment.VideoFragment;
import com.example.lucky.fragment.YoutubeFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout homeFrame;
    private BottomNavigationView navigation;
    private HomeFragment homeFragment;
    private VideoFragment videoFragment;
    private YoutubeFragment youtubeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        navigation = findViewById(R.id.navigation);
        homeFrame = findViewById(R.id.homeFrame);



        homeFragment = new HomeFragment();
        videoFragment = new VideoFragment();
        youtubeFragment = new YoutubeFragment();

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

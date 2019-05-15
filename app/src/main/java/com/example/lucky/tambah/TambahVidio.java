package com.example.lucky.tambah;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lucky.R;
import com.example.lucky.play.VidioPlay;

public class TambahVidio extends AppCompatActivity {


    private static int VIDEO_REQUEST =101;
    private Uri videoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_vidio);
    }

    public void capturevideo(View view){
        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (videoIntent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(videoIntent,VIDEO_REQUEST);
        }
    }

    public void playvideo(View view){

        Intent playIntent = new Intent(this, VidioPlay.class);
        playIntent.putExtra("videoUri",videoUri.toString());
        startActivity(playIntent);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode==VIDEO_REQUEST && requestCode==RESULT_OK){
            videoUri = data.getData();
        }
    }

}

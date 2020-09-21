package com.example.android.camera2video;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

public class ShowGalaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_galary);

        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        String value = data.getString("UriSave","nodata" );

        VideoView videoView=findViewById(R.id.myvideoview);
        Log.e("TAG","指定されたUriは"+ value);
        Uri convertedUri = Uri.parse(value);
        try {
            videoView.setVideoURI(convertedUri);
        }catch(Exception e){;
            Log.e("TAG","URIから動画の取り出しに失敗");
        }
    }
}
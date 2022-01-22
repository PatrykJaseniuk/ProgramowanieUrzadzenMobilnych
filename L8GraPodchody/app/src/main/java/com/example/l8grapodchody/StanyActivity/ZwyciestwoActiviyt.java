package com.example.l8grapodchody.StanyActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.l8grapodchody.Kernel;
import com.example.l8grapodchody.R;

public class ZwyciestwoActiviyt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zwyciestwo_activiyt);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.zwyciestwo);
        mediaPlayer.start();
    }
    MediaPlayer mediaPlayer;

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }
}
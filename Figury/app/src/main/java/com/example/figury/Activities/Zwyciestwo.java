package com.example.figury.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.figury.R;

public class Zwyciestwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zwyciestwo);
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.zwyciestwo);
        mediaPlayer.start();
    }

    public void onClick(View v)
    {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }

    MediaPlayer mediaPlayer;
}
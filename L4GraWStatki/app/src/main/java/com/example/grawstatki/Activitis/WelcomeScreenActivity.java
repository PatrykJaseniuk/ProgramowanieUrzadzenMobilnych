package com.example.grawstatki.Activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class WelcomeScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
    }

    public void onClickStart(View view) {
        startActivity(new Intent(this, ZaslonaActivity.class));
//    GameCore.stan.nextPlayer(this);
//    startActivity();
    }

    public void onClickZapisz(View view) {
    startActivity(new Intent(this,ZapiszActivity.class));
    }

    public void onClickWczytaj(View view) {
        startActivity(new Intent(this,WczytajActivity.class));
    }

    @Override
    public void onBackPressed()
    {

    }

}
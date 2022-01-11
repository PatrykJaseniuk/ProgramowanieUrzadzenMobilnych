package com.example.grawstatki.Widok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);
    }

public void onClickStart(View view)
{
    GameCore.stan.nextPlayer(this);
//    startActivity();
}

}
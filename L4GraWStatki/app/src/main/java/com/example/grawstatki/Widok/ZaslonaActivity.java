package com.example.grawstatki.Widok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class ZaslonaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.grawstatki.R.layout.activity_next_player);
        setText();
    }

    private void setText() {
        TextView tv = findViewById(R.id.textView3);
        tv.setText("Kolej Gracza: "+ GameCore.aktualnyGracz.id);
    }

   public void onClickOk(View view)
    {
//        GameCore.placingShips(this);
        GameCore.nextPlayer(this);
    }





}
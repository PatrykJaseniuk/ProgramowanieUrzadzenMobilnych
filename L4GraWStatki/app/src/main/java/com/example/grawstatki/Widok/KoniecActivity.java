package com.example.grawstatki.Widok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class KoniecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koniec);
        TextView tv= findViewById(R.id.textView4Zwyciestwo);
        tv.setText("Zwyciężył Gracz "+ GameCore.aktualnyGracz.id);
    }
}
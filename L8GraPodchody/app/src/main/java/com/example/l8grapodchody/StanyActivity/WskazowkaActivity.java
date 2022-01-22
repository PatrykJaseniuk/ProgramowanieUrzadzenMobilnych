package com.example.l8grapodchody.StanyActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.l8grapodchody.Kernel;
import com.example.l8grapodchody.R;

public class WskazowkaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wskazowka);
        ustawTrescWskazowki();
    }

    private void ustawTrescWskazowki() {
        TextView tv = findViewById(R.id.textViewWskazowkaLokalizacji);
        tv.setText(Kernel.wskazowka);
    }
    public void onClick(View view)
    {
        new Thread()
        {
            @Override
            public void run() {
                Kernel.rozpocznijWzkazowkaLubPytanie(WskazowkaActivity.this);
            }
        }.start();
    }
}
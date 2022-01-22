package com.example.l8grapodchody.StanyActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.l8grapodchody.Kernel;
import com.example.l8grapodchody.R;

public class RezultatOdpowiedziActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezultat_odpowiedzi);
        ustaRezultatOdpowiedz();
    }

    private void ustaRezultatOdpowiedz() {
        TextView tv = findViewById(R.id.textViewRezultatOdpowiedzi);
        if( Kernel.rezultatOdpowiedz.czyPrawidlowaOdpowiedz)
        {
            tv.setText("Odpowiedz \nPrawidlowa");
        }
        else
        {
            tv.setText("Odpowiedz nieprawidlowa \nczekasz: \n"+Kernel.rezultatOdpowiedz.czasOczekiwania+" sekund");
        }
    }

    public void onClick(View view)
    {
        new Thread()
        {
            @Override
            public void run() {
                Kernel.rozpocznijWzkazowkaLubPytanie(RezultatOdpowiedziActivity.this);
            }
        }.start();
    }
}
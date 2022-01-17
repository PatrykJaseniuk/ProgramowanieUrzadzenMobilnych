package com.example.l5kantor.Activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.l5kantor.Kernel;
import com.example.l5kantor.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Kernel.inicjalizujBazeDanych(this);

        ustawListeneryDlaPol();
        powiazUiZDanymi();

        odswierz();
    }

    private void powiazUiZDanymi() {
        MainViewModel.getLiveDataIloscPieniedzy().observe(this, new Observer<Float>() {
            @Override
            public void onChanged(Float aFloat) {
                TextView tVIloscPieniedzy2 = findViewById(R.id.textViewIloscPieniedzyOtrzymanych);
                try {
                    tVIloscPieniedzy2.setText(Float.toString(aFloat));
                } catch (Exception e) {

                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        odswierz();
    }

    private void odswierz() {

        Button buttonWaluta1 = findViewById(R.id.buttonWaluta1);
        if (Kernel.walutaDoWymiany.nazwaWaluty != null) {
            buttonWaluta1.setText(Kernel.walutaDoWymiany.nazwaWaluty);
        } else {
            buttonWaluta1.setText("Wybierz Walute");
        }

        Button buttonWaluta2 = findViewById(R.id.buttonWaluta2);
        if (Kernel.walutaDoOtrzymania.nazwaWaluty != null) {
            buttonWaluta2.setText(Kernel.walutaDoOtrzymania.nazwaWaluty);
        } else {
            buttonWaluta2.setText("Wybierz Walute");
        }
    }

    private void ustawListeneryDlaPol() {
        EditText eTWaluta1 = findViewById(R.id.editTextWaluta1);

        eTWaluta1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float iloscPieniedzyDoWymiany = 0;
                try {
                    iloscPieniedzyDoWymiany = Float.parseFloat(eTWaluta1.getText().toString());
                } catch (Exception e) {
                }
                MainViewModel.setIloscPieniedzyDoWymiany(iloscPieniedzyDoWymiany);//
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    public void onButtonClickWybierzWaluteDoSprzedania(View wiew) {
        Kernel.wybierzWaluteDoSprzedania(this);
    }

    public void onButtonClickWybierzWaluteWybierzWaluteDoKupna(View wiew) {
         Kernel.wybierzWaluteDoKupna(this);
    }

    public void onButtonClickTabelaKursow(View view) {
        Kernel.wyswietlTabeleKursow(this);
    }

    public void onButtonClickAdmin(View view) {
        Kernel.wyswietlAdmin(this);
    }


}
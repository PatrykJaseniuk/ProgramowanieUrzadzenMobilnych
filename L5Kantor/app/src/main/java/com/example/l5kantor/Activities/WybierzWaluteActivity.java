package com.example.l5kantor.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.l5kantor.BazaDanych.Waluta;
import com.example.l5kantor.Kernel;
import com.example.l5kantor.R;

import java.util.List;

public class WybierzWaluteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybierz_walute);

        ustawListeneraDlaListViewWaluty(this);

        powiarzDaneZListWiew();

        wyswietlWaluty();
    }

    @Override
    protected void onResume() {
        super.onResume();
        wyswietlWaluty();
    }

    private void powiarzDaneZListWiew() {
        MainViewModel.getLiveDataListaWalut().observe(this,new Observer<List<Waluta>>() {
            @Override
            public void onChanged(List<Waluta> listaWalut) {
                if(listaWalut!=null)
                {
                    ListView lv = findViewById(R.id.listViewListaWalut);
                    ArrayAdapter<Waluta> adapter = new ArrayAdapter(WybierzWaluteActivity.this, android.R.layout.simple_list_item_1, listaWalut);
                    lv.setAdapter(adapter);
                }
            }
        });

    }


    private void ustawListeneraDlaListViewWaluty(Context context) {
        ListView lv = findViewById(R.id.listViewListaWalut);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Waluta waluta = (Waluta) (lv.getItemAtPosition(position));
                Kernel.setWaluta(waluta);
//                Kernel.aktywanaWaluta[0] = waluta.nazwaWaluty;
//                startActivity(new Intent(this, WelcomeScreenActivity.class));
            }
        });
    }

    void wyswietlWaluty() {
        MainViewModel.setListaWalut();
    }
}
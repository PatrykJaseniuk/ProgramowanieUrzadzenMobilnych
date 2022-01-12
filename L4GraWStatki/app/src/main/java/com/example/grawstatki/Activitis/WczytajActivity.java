package com.example.grawstatki.Activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class WczytajActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wczytaj);

        wyswietlZapisy(GameCore.getListaZapisow(this));
        ustawListeneraDlaZapisow(this);
//        wyswietlZapisy(new String[]{"zapis1"});
    }

    private void ustawListeneraDlaZapisow(Context context) {
        ListView lv = findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nazwaZapisu = (String) (lv.getItemAtPosition(position));
                GameCore.wczytaj(context,nazwaZapisu);
//                startActivity(new Intent(this, WelcomeScreenActivity.class));
            }
        });
    }

    void wyswietlZapisy(String[] listaZapisow) {
        if(listaZapisow!=null)
        {
            ListView lv = findViewById(R.id.listView);
            ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaZapisow);
            lv.setAdapter(adapter);
        }

    }
}
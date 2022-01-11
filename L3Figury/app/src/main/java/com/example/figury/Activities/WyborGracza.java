package com.example.figury.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.figury.R;
import com.example.figury.StanyGraczy;

public class WyborGracza extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor_gracza);
        StanyGraczy.wczytajZPreferencji(this);

        wyswietlListeGraczy(StanyGraczy.getListaGraczy());

        ustawListeneraDlaListyGraczy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        wyswietlListeGraczy(StanyGraczy.getListaGraczy());
    }

    @Override
    protected void onStop() {
        super.onStop();
        StanyGraczy.zapiszDoPreferencji(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }

    private void ustawListeneraDlaListyGraczy() {
        ListView widokListaGraczy = findViewById(R.id.listView);
        widokListaGraczy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StanyGraczy.aktywujGracza(position); //potencjal dla bledu
                rozpocznijGre();
            }
        });
    }

    private void rozpocznijGre() {
        startActivity(new Intent(this, com.example.figury.Activities.MainActivity.class));
    }

    public void onClickDodajGracza(View view) {
        String nazwaGracza = getPodanaNazwaGracza();
        StanyGraczy.dodajGracza(nazwaGracza);
        wyswietlListeGraczy(StanyGraczy.getListaGraczy());
    }

    private String getPodanaNazwaGracza() {
        EditText et = findViewById(R.id.editTextTextPersonName);
        return et.getText().toString();
    }

    void wyswietlListeGraczy(String[] listaGraczy) {
        ListView widokListaGraczy = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaGraczy);
        widokListaGraczy.setAdapter(adapter);
    }


}
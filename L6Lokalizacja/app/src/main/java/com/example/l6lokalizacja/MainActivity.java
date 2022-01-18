package com.example.l6lokalizacja;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.l6lokalizacja.DataBase.Punkt;
import com.example.l6lokalizacja.DataBase.Wspolrzedne;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel.inicjalizuj(this);
        powiazViewModelZListViewPunkty();
        powiazViewModelZTextViewOpisPunktu();
        powiazViewModelZTextViewMojeWspolrzedne();
        ustawListeneraDlaListViewPunkty();
        ustawListeneraDlaEditTextPromien();
    }

    private void powiazViewModelZTextViewMojeWspolrzedne() {
        TextView tv = findViewById(R.id.textViewMojeWspolrzedne);
        MainViewModel.getliveMojeWspolrzedne().observe(this, new Observer<Wspolrzedne>() {
            @Override
            public void onChanged(Wspolrzedne w) {
                String s = "dlugosc : "+w.x
                        +"\nszerokosc : "+w.y;
                tv.setText(s);
            }
        });
    }

    private void powiazViewModelZTextViewOpisPunktu() {
        TextView tv = findViewById(R.id.textViewSzczegolyPunktu);
        MainViewModel.getliveDataOpis().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
             tv.setText(s);
            }
        });
    }

    private void ustawListeneraDlaEditTextPromien() {
        EditText et = findViewById(R.id.editTextNumberDecimal);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try {
                    float odleglosc = Float.valueOf(et.getText().toString());
                    MainViewModel.requestListaPunktow(odleglosc);
                }catch(Exception e)
                {

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void ustawListeneraDlaListViewPunkty() {
        ListView lv = findViewById(R.id.listViewPunkty);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Punkt punkt = (Punkt) (lv.getItemAtPosition(position));
                MainViewModel.requestSzczegolyPunktu(punkt);
            }
        });
    }

    private void powiazViewModelZListViewPunkty() {
        ListView lv = findViewById(R.id.listViewPunkty);
        MainViewModel.getliveDataListView().observe(this, new Observer<List<Punkt>>() {
            @Override
            public void onChanged(List<Punkt> listaPunktow) {
                ArrayAdapter<Punkt> adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listaPunktow);
                lv.setAdapter(adapter);
            }
        });
    }


}
package com.example.l8grapodchody.StanyActivity.Pytanie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.l8grapodchody.Kernel;
import com.example.l8grapodchody.R;

public class PytanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pytanie);
        powiazViewModelZListViewPunkty();
        ustawListineryDlaListView();
        ustawTrescPytania();
    }

    private void ustawTrescPytania() {
        TextView tv =findViewById(R.id.textViewTrescPytania);
        tv.setText(Kernel.pytanie.trescPytania);
    }

    private void ustawListineryDlaListView() {
        ListView lv = findViewById(R.id.listViewOpcjeOdpowiedzi);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                new Thread(){
                    @Override
                    public void run() {
                        Kernel.odpowiedz(PytanieActivity.this,position);
                    }
                }.start();

            }
        });
    }

    private void powiazViewModelZListViewPunkty() {
        ListView lv = findViewById(R.id.listViewOpcjeOdpowiedzi);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Kernel.pytanie.listaOpcjiOdpowiedzi);
        lv.setAdapter(adapter);
    }
}
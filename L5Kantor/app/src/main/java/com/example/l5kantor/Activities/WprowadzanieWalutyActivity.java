package com.example.l5kantor.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.l5kantor.BazaDanych.Waluta;
import com.example.l5kantor.Kernel;
import com.example.l5kantor.R;

public class WprowadzanieWalutyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wprowadzanie_waluty);
    }

    public void onClick(View view) {
        EditText etNazwa = findViewById(R.id.editTextTextNazwaWaluty);
        EditText etCean = findViewById(R.id.editTextCena);
        try {
            Kernel.dodajWalute(etNazwa.getText().toString(), Float.valueOf(etCean.getText().toString()));

        } catch (Exception e) {
        }


    }
}
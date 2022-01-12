package com.example.grawstatki.Activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.grawstatki.GameKernel.GameCore;
import com.example.grawstatki.R;

public class ZapiszActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zapisz);
    }

    public void OnZapiszClick(View view)
    {
        EditText et = findViewById(R.id.editTextNazwaZapisu);
        String nazwaZapisu = et.getText().toString();
        GameCore.zapisz(this, nazwaZapisu);
//        GameCore.zapisz(this,"zapis1");
    }

}
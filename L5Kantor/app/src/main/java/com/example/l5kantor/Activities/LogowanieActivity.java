package com.example.l5kantor.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.l5kantor.Kernel;
import com.example.l5kantor.R;

public class LogowanieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie_activiyt);
    }

    public void onClickZaloguj(View view)
    {
        EditText et = findViewById(R.id.editTextTextPassword);
        Kernel.zaloguj(this,et.getText().toString());
    }

}
package com.example.l6web;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powiazViewModelZEditTextPogodaWMiescie();
    }

    private void powiazViewModelZEditTextPogodaWMiescie() {
        TextView tvOpisPogody =findViewById(R.id.textViewPogoda);
        MainViewModel.getLiveDataPogoda().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvOpisPogody.setText(s);
            }
        });
    }

    public void onButtonClick(View view)
    {
        EditText etMiasto = findViewById(R.id.editTextTextPersonName);
        String nazwaMiasta = etMiasto.getText().toString();
        MainViewModel.getPogodaDlaMiasta(nazwaMiasta);
    }
}
package com.example.l8grapodchody.StanyActivity.Rozpoczecie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.l8grapodchody.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectTextViewInformacjaZwrotnaZLiveData();
    }

    private void conectTextViewInformacjaZwrotnaZLiveData() {
        TextView tvOdpowiedzZwrotna = findViewById(R.id.TextViewInformacjaZwrotna);
        MainViewModel.getLiveDataInformacjaZwrotna().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvOdpowiedzZwrotna.setText(s);
            }
        });
    }

    public void onClick(View view)
    {
        EditText et =findViewById(R.id.editTextNumber);
        int idGracza = -1;
        try {
           idGracza = Integer.valueOf(et.getText().toString());
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        MainViewModel.podajIdGracza(this ,idGracza);
    }
}
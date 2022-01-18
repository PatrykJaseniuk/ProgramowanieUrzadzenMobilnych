package com.example.l6web;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel {

    private static MutableLiveData<String> liveDataPogodaDlaMiasta;

    public static void getPogodaDlaMiasta(String nazwaMiasta) {
        new Thread(){
            @Override
            public void run() {
              String pogoda = Kernel.getPogodaDlaMiasta(nazwaMiasta);
              liveDataPogodaDlaMiasta.postValue(pogoda);
            }
        }.start();
    }

    public static LiveData<String> getLiveDataPogoda() {
        if(liveDataPogodaDlaMiasta==null)
        {
            liveDataPogodaDlaMiasta = new MutableLiveData<String>();
        }
        return liveDataPogodaDlaMiasta;
    }
}

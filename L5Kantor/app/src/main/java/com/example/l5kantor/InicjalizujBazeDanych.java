package com.example.l5kantor;

import android.content.Context;



public class InicjalizujBazeDanych extends Thread {
    private Context context;

    public InicjalizujBazeDanych(Context context) {
        this.context = context;
    }

    public void run() {
        Kernel.repozitory = new Repozitory(context);
        Kernel.repozitory.putWaluta("BTC", 200000);
        Kernel.repozitory.putWaluta("ETH", 2000);
    }
}
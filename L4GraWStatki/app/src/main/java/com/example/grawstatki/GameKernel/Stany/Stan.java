package com.example.grawstatki.GameKernel.Stany;

import android.content.Context;

import java.io.Serializable;

public interface Stan extends Serializable {
    void nextPlayer(Context context);
    void fieldClicked(int x, int y);
    void reset();
}

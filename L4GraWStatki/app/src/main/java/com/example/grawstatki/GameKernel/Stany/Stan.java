package com.example.grawstatki.GameKernel.Stany;

import android.content.Context;

public interface Stan
{
    void nextPlayer(Context context);
    void fieldClicked(int x, int y);
}

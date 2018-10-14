package com.example.anrigu.matchinggame;

import android.support.annotation.StringRes;

public class Card {
    boolean cardUp;
    int cardVal;
    int buttonId;

    public Card(int cardVal, boolean cardUp,int buttonId) {
        this.cardVal = cardVal;
        this.cardUp = cardUp;
        this.buttonId = buttonId;
    }

    public void flip(boolean up) {
        this.cardUp = up;
    }



}
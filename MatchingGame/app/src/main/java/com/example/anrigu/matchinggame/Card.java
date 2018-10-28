package com.example.anrigu.matchinggame;

public class Card {
    boolean cardUp;
    int cardVal;
    int buttonId;
    int imageId;

    public Card(int cardVal, boolean cardUp,int buttonId,int imageId) {
        this.cardVal = cardVal;
        this.cardUp = cardUp;
        this.buttonId = buttonId;
        this.imageId = imageId;
    }

    public void flip(boolean up) {
        this.cardUp = up;
    }

    public static void main(String[] args){
        Card jerry = new Card(5,true,1,4);
        System.out.println(jerry.cardVal);
    }
}

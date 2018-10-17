package com.example.anrigu.matchinggame;

public class Card {
    boolean cardUp;
    int cardVal;
    int buttonId;

    public Card(int cardVal, boolean cardUp,int buttonId) {
        this.cardVal = cardVal;
        this.cardUp = cardUp;
        this.buttonId = buttonId;
    }
    public Card(int cardVal,int buttonId){
        this(cardVal,false,buttonId);
    }

    public void flip(boolean up) {
        this.cardUp = up;
    }
    public static void main(String[] args){
        Card jerry = new Card(5,true,1);
        System.out.println(jerry.cardVal);
    }
}

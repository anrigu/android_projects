package com.example.anrigu.matchinggame;

public class Card {
    private boolean cardUp;
    private int cardVal;
    private int buttonId;

    public Card(int cardVal, boolean cardUp,int buttonId) {
        this.cardVal = cardVal;
        this.cardUp = cardUp;
        this.buttonId = buttonId;
    }

    public void flip(boolean up) {
        this.cardUp = up;
    }

    public boolean isCardUp() {
        return cardUp;
    }

    public int getCardVal() {
        return cardVal;
    }

    public int getButtonId() {
        return buttonId;
    }

    public static void main(String[] args){
        Card jerry = new Card(5,true,1);
        System.out.println(jerry.cardVal);
    }
}

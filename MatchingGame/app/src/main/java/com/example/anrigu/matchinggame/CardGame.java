package com.example.anrigu.matchinggame;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public List<Card> cards;

    public CardGame(List<Integer> buttons) {
        cards = new ArrayList<>();
        for (int i = 0; i< buttons.size(); i++) {
            cards.add(new Card(random(1,12),false,buttons.get(i)));
        }
    }
    public int random(int low, int high){
        return (int) (Math.random() * (((high-low)+1))+low);
    }
    public Card onClick(Card card){
        if(!card.cardUp){
            card.flip(true);
        }
        return card;
    }
    public int getMatchingCardIndex(View view){
        for(int i = 0; i < cards.size(); i++){
            if(view.getId()==(cards.get(i).buttonId)){
                return i;
            }
        }
        return -1;
    }
    public int numberOfFaceUpCards(){
        int count = 0;
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(i).cardUp){
                count ++;
            }
        }
        return count;
    }

}

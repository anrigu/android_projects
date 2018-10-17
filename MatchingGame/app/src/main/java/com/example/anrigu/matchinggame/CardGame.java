package com.example.anrigu.matchinggame;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    private List<Card> cards;

    public Card getCardAt(int index) {
        return cards.get(index);
    }

    public int getNumOfCards() {
        return cards.size();
    }

    public void removeCard(Card c) {
        cards.remove(c);
    }

    public CardGame(List<Integer> buttons) {
        cards = new ArrayList<>();
        RandomNumberListGenerator generator = new RandomNumberListGenerator();
        List<Integer> cardNumbers = generator.scrambleNumberList(buttons.size());
        for (int i = 0; i< buttons.size(); i++) {
            cards.add(new Card(cardNumbers.get(i),false, buttons.get(i)));
        }
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

    public List<Card> getFaceUpCards (){
        List<Card> faceUpCards= new ArrayList<>();
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(i).cardUp){
                faceUpCards.add(cards.get(i));
            }
        }
        return faceUpCards;
    }
}

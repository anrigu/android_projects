package com.example.anrigu.matchinggame;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    public List<Card> cards;

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

    public int numberOfFaceUpCards(){
        int count = 0;
        for(int i = 0; i < cards.size(); i++){
            if (cards.get(i).cardUp){
                count ++;
            }
        }
        return count;
    }
    public List<Integer> areTwoCardsEqual(Card card){
        ArrayList<Integer> indexOfCardsEqual = new ArrayList<>();
        for(int i = 0; i < cards.size();i++){
            if ((card.cardVal == cards.get(i).cardVal) && (card.buttonId != cards.get(i).buttonId) && (cards.get(i).cardUp)){
                indexOfCardsEqual.add(i);
            }
        }
        return indexOfCardsEqual;
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

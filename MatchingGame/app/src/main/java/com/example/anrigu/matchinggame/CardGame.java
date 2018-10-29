package com.example.anrigu.matchinggame;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CardGame {
    private List<Card> cards;

    public Card getCardAt(View view) {
        for (int i = 0; i < cards.size(); i++) {
            if (view.getId() == (cards.get(i).getButtonId())) {
                return cards.get(i);
            }
        }
        return null;
    }

    public Card getCardAt(int index) {
        return cards.get(index);
    }

    public int getNumOfCards() {
        return cards.size();
    }

    public void removeCard(Card c) {
        cards.remove(c);
    }

    public CardGame(List<View> buttons, List<Integer> images) {
        cards = new ArrayList<>();
        for (int i = 0; i < buttons.size(); i++) {
            cards.add(new Card(images.get(i), false, buttons.get(i).getId()));
        }
    }

    public Card onClick(Card card) {
        if (!card.isCardUp()) {
            card.flip(true);
        }
        return card;
    }

    public List<Card> getFaceUpCards() {
        List<Card> faceUpCards = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).isCardUp()) {
                faceUpCards.add(cards.get(i));
            }
        }
        return faceUpCards;
    }
}

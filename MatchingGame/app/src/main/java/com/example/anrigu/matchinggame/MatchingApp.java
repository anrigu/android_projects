package com.example.anrigu.matchinggame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MatchingApp extends AppCompatActivity {
    private boolean timerStart = false;
    private CardGame cardGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_app);
        cardGame = new CardGame(buttonIds());
        for(int i =0 ; i < cardGame.getNumOfCards(); i++) {
            setCardDisplayState(cardGame.getCardAt(i));
        }
    }

    public ArrayList<Integer> buttonIds() {
        ViewGroup grid = (ViewGroup) findViewById(R.id.container);
        int count = grid.getChildCount();
        ArrayList<Integer> buttonIdList = new ArrayList<Integer>();
        for(int i = 0; i<count;i++){
            buttonIdList.add(grid.getChildAt(i).getId());
        }
        return buttonIdList;
    }

    private void setCardDisplayState(Card card){
        String text = card.cardUp ? Integer.toString(card.cardVal) : "";
        int color = card.cardUp ? Color.CYAN : Color.LTGRAY;

        Button button = findViewById(card.buttonId);
        button.setText(text);
        button.setBackgroundColor(color);
    }

    public void clickButton(View view) {
        int cardIndex = cardGame.getMatchingCardIndex(view);
        Card card = cardGame.getCardAt(cardIndex);
        List<Card> currentFaceUpCards = cardGame.getFaceUpCards();
        if (currentFaceUpCards.size() < 2) {
            if (!card.cardUp) {
                card.flip(true);
                setCardDisplayState(card);
            }
        }
        final List<Card> faceUpCards = cardGame.getFaceUpCards();
        if (faceUpCards.size() == 2 && !timerStart) {
            CountDownTimer timer = new CountDownTimer(500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    if (faceUpCards.get(0).cardVal == faceUpCards.get(1).cardVal) {
                        removeCardVisibility(faceUpCards.get(0));
                        removeCardVisibility(faceUpCards.get(1));
                    } else {
                        for (int i = 0; i < 2; i++) {
                            Card c = faceUpCards.get(i);
                            c.flip(false);
                            setCardDisplayState(c);
                        }
                    }
                    timerStart = false;
                }
            };
            timer.start();
            timerStart = true;
        }
    }

    public void moveToSecond(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void removeCardVisibility(Card card)  {
        cardGame.removeCard(card);
        View view = findViewById(card.buttonId);
        view.setVisibility(View.INVISIBLE);

    }
}
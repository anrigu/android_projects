package com.example.anrigu.matchinggame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MatchingApp extends AppCompatActivity {
    boolean timerStart = false;
    CardGame cardGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_app);
        cardGame = new CardGame(buttonIds());
    }

    public ArrayList<Integer> buttonIds() {
        ArrayList<Integer> buttonIdList = new ArrayList<Integer>();
        buttonIdList.add(R.id.a);
        buttonIdList.add(R.id.b);
        buttonIdList.add(R.id.c);
        buttonIdList.add(R.id.d);
        buttonIdList.add(R.id.e);
        buttonIdList.add(R.id.f);
        return buttonIdList;
    }

    public void clickButton(View view) {
        int cardIndex = cardGame.getMatchingCardIndex(view);
        Card card = cardGame.cards.get(cardIndex);
        List<Card> currentFaceUpCards = cardGame.getFaceUpCards();
        if (currentFaceUpCards.size() < 2) {
            if (!card.cardUp) {
                card.flip(true);
                ((Button) view).setText(Integer.toString(card.cardVal));
            }
        }
        final List<Card> faceUpCards = cardGame.getFaceUpCards();
        if (faceUpCards.size() == 2) {
            CountDownTimer timer = new CountDownTimer(500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    if (faceUpCards.get(0).cardVal == faceUpCards.get(1).cardVal) {
                        removeCard(faceUpCards.get(0));
                        removeCard(faceUpCards.get(1));
                    } else {
                        for (int i = 0; i < 2; i++) {
                            Card c = faceUpCards.get(i);
                            ((Button) findViewById(c.buttonId)).setText("Button");
                            c.flip(false);
                        }

                    }
                }
            };
        timer.start();
        }
    }
        public void moveToSecond(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void removeCard(Card card){
        cardGame.cards.remove(card);
        View view = findViewById(card.buttonId);
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
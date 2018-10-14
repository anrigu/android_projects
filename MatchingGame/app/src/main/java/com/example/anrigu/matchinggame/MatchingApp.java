package com.example.anrigu.matchinggame;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MatchingApp extends AppCompatActivity {
    boolean timerStart = false;
    CardGame cardGame;

    CountDownTimer timer = new CountDownTimer(5000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            Log.i("timeout", "Done");
            ((Button) findViewById(R.id.a)).setText("Button");
            ((Button) findViewById(R.id.b)).setText("Button");
            timerStart = false;
        }
    };

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
        if (cardGame.numberOfFaceUpCards() < 2) {
            int cardIndex = cardGame.getMatchingCardIndex(view);
            Card card = cardGame.cards.get(cardIndex);

            if (!card.cardUp) {
                card.flip(true);
                ((Button) view).setText(Integer.toString(card.cardVal));
            }
        }
    }

    public void moveToSecond(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}
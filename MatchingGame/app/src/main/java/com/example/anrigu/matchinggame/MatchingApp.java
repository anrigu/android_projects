package com.example.anrigu.matchinggame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
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
        RandomNumberListGenerator fullImageIdList = new RandomNumberListGenerator();
        List<View> buttons = getButtons();
        cardGame = new CardGame(buttons, fullImageIdList.generateListImage(getImageIds()));
        Point size = buttonSizeCalc(buttons.size() / 2);
        for (int i = 0; i < cardGame.getNumOfCards(); i++) {
            Card card = cardGame.getCardAt(i);
            setCardDisplayState(card);
            setButtonSize(buttons.get(i), size);
        }
    }

    public List<Integer> getImageIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(R.drawable.jack_card);
        ids.add(R.drawable.queen_card);
        ids.add(R.drawable.king_card);
        ids.add(R.drawable.ace_card);
        return ids;
    }

    public List<View> getButtons() {
        ViewGroup grid = findViewById(R.id.container);
        int count = grid.getChildCount();
        List<View> buttons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            buttons.add(grid.getChildAt(i));
        }
        return buttons;
    }

    private Point buttonSizeCalc(int numCardsPerRow) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int marginWidth = (int) (3 * displayMetrics.density);
        int cardWidth = (screenWidth - (numCardsPerRow + 1) * marginWidth) / numCardsPerRow;
        int cardHeight = cardWidth * 4 / 3;
        return new Point(cardWidth, cardHeight);
    }

    public void setButtonSize(View button, Point size) {
        ViewGroup.LayoutParams params = button.getLayoutParams();
        params.width = size.x;
        params.height = size.y;
        button.setLayoutParams(params);
    }

    private void setCardDisplayState(Card card) {
        Button button = findViewById(card.getButtonId());
        if (card.isCardUp()) {
            button.setBackground(getDrawable(card.getCardVal()));
        } else {
            button.setBackgroundColor(Color.LTGRAY);
        }
    }

    public void clickButton(View view) {
        Card card = cardGame.getCardAt(view);
        if(card == null) {
            Log.e("jj","Shouldn't happen");
            return;
        }
        List<Card> currentFaceUpCards = cardGame.getFaceUpCards();
        if (currentFaceUpCards.size() < 2) {
            if (!card.isCardUp()) {
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
                    if (faceUpCards.get(0).getCardVal() == faceUpCards.get(1).getCardVal()) {
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

    public void removeCardVisibility(Card card) {
        cardGame.removeCard(card);
        View view = findViewById(card.getButtonId());
        view.setVisibility(View.INVISIBLE);
    }
}
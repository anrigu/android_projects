package com.example.anrigu.matchinggame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

public class MatchingApp extends AppCompatActivity {
    List<String> cardList = new ArrayList<>();
    int numberOfCards = 2;
    boolean timerStart = false;


    CountDownTimer timer = new CountDownTimer(5000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            Log.i("timeout","Done");
            ((Button)findViewById(R.id.a)).setText("Button");
            ((Button)findViewById(R.id.b)).setText("Button");
            listGenerate();
            timerStart = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listGenerate();
        setContentView(R.layout.activity_matching_app);
    }
    public ArrayList<Integer> buttonId(){
        ArrayList<Integer> buttonIdList = new ArrayList<Integer>();
        buttonIdList.add(R.id.a);
        buttonIdList.add(R.id.b);
        buttonIdList.add(R.id.c);
        buttonIdList.add(R.id.d);
        return buttonIdList;
    }
    public void listGenerate(){
        cardList.clear();
        for(int i = 0; i < numberOfCards; i++) {
            cardList.add(Integer.toString(random(1,10)));
        }
    }
    public int random(int low, int high){
        return (int) (Math.random() * (((high-low)+1))+low);
    }
    public void clickButton(View view) {
        showCard((Button) view);
        Button buttonOne = findViewById(R.id.a);
        Button buttonTwo = findViewById(R.id.b);
        checkButtons(buttonOne, buttonTwo);
    }

    public void showCard(Button button) {
        if (button.getId() == R.id.a) {
            button.setText(cardList.get(0));
        } else {
            button.setText(cardList.get(1));
        }
    }

    public void checkButtons(Button button1, Button button2) {
        if (button1.getText().equals("Button") || button2.getText().equals("Button")) {
        } else {
            if (button1.getText().equals(button2.getText())) { //FIX THIS
            } else {
                if (!timerStart) {
                    timerStart = true;
                    timer.start();
                }


            }
        }
    }
    public void moveToSecond(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}

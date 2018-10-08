package com.example.anrigu.matchinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MatchingApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_app);
    }

    public void clickButton(View view) {
        flipButton((Button) view);
        Button buttonOne = findViewById(R.id.button);
        Button buttonTwo = findViewById(R.id.button2);
        checkButtons(buttonOne, buttonTwo);
    }

    public void flipButton(Button button) {
        if (button.getId() == R.id.button) {
            button.setText(getString(R.string.button1));
        } else {
            button.setText(getString(R.string.button2));
        }
    }

    public void checkButtons(Button button1, Button button2) {
        if (button1.getText().equals("Button") || button2.getText().equals("Button")) {
            return;
        } else {
            if (button1.getText().equals(button2.getText())) {
                Button button3 = findViewById(R.id.button3);
                button3.setText("Right");
            } else {
                flipButton(button1);
                flipButton(button2);
                Button button3 = findViewById(R.id.button3);
                button3.setText("Wrong");

            }
        }
    }
    public void clear(View view){
        ((Button)findViewById(R.id.button)).setText("Button");
        ((Button)findViewById(R.id.button2)).setText("Button");
    }
}

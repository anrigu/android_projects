package com.example.anrigu.buttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PushButtonTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_button_test);
    }
    public void changeText(View view) {
        TextView greeting_text = findViewById(R.id.hello);
        Log.i("MyInfo","Button tapped");
        if (greeting_text.getText() == getString(R.string.hello)) {
            greeting_text.setText(getString(R.string.bye));
        } else {
            greeting_text.setText(getString(R.string.hello));
        }
    }
}

package com.example.anrigu.buttontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PushButtonTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_button_test);
    }
    public void change_text(View view) {
        TextView hello = (TextView) findViewById(R.id.hello);
            hello.setText("Bye World");
        }
}

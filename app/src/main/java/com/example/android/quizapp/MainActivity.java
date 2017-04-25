package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Start(View view) {
        Intent intent = new Intent(MainActivity.this, Quiz.class);
        startActivity(intent);
    }

    public void Helped(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}

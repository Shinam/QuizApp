package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quizapp.R.id.result;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        int res = intent.getIntExtra("res", 0);
        TextView text = (TextView) findViewById(result);
        text.setText(res + "/20");
        String answer = null;
        if (res > 15) {
            answer = getString(R.string.Sentence0);
        } else if (res > 10) {
            answer = getString(R.string.Sentence1);
        } else if (res > 5) {
            answer = getString(R.string.Sentence2);
        } else {
            answer = getString(R.string.Sentence3);
        }
        Toast.makeText(this, res + "/20 : " + answer, Toast.LENGTH_LONG).show();
    }

    public void Close(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.barmej.guesstheanswer1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        TextView textView = findViewById(R.id.textView_answer) ;
        String answer = getIntent().getStringExtra("question_answers") ;
        if (answer != null) {
            textView.setText(answer);
        }}

     public void onNextQuestion(View view) {

        finish();

        }

    }

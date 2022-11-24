package com.barmej.guesstheanswer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private  String[] QUESTIONS ;

    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false,
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            true
    };

    private String[] ANSWERS_DETAILS ;



    String questions,answers_details;
    boolean answers ;

    TextView textView  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView_question) ;

        QUESTIONS = getResources().getStringArray(R.array.questions);
        ANSWERS_DETAILS=getResources().getStringArray(R.array.answers_details) ;



        changeQuestion();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater() ;
        menuInflater.inflate(R.menu.menu,menu);
        return true;


    }

    public void changeQuestion() {

         Random random = new Random() ;
         int index = random.nextInt(QUESTIONS.length) ;
         questions = QUESTIONS[index];
         answers_details = ANSWERS_DETAILS[index] ;
         answers = ANSWERS[index];
         textView.setText(questions);
     }

     public void onChange(View view) {
        changeQuestion();
     }


     public void onTrueQuestion(View view) {

         if (answers == true) {
            Toast.makeText(this, "اجابة صحيحة", Toast.LENGTH_SHORT).show();
            changeQuestion();
        }else {
            Toast.makeText(this, "للاسف اجابة خاطئة", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(MainActivity.this , AnswerActivity.class) ;
            intent.putExtra("question_answers" , answers_details) ;
            startActivity(intent);
            changeQuestion();

        }


     }
    public void onFalseQuestion(View view) {

        if (answers == false) {
            Toast.makeText(this, "اجابة صحيحة", Toast.LENGTH_SHORT).show();
            changeQuestion();
        }else {
            Toast.makeText(this, "للاسف اجابة خاطئة", Toast.LENGTH_SHORT).show();
            Intent intent  = new Intent(MainActivity.this , AnswerActivity.class) ;
            intent.putExtra("question_answers" , answers_details) ;
            startActivity(intent);
            changeQuestion();
        }


    }

    public void shareQuestion(View view) {

        Intent intent = new Intent(MainActivity.this,shareActivity.class) ;
        intent.putExtra("question_share",questions) ;
        startActivity(intent);

    }








}
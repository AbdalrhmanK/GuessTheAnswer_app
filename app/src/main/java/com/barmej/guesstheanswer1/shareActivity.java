package com.barmej.guesstheanswer1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class shareActivity extends AppCompatActivity {

    String question ;
    public EditText editText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        question = getIntent().getStringExtra("question_share") ;
        editText = findViewById(R.id.editText_share);


        // اضافية
        SharedPreferences sharedPreferences = getSharedPreferences("app" , MODE_PRIVATE) ;
        String questionSave = sharedPreferences.getString("share title","");
        editText.setText(questionSave);
    }

    public void onClickShare(View view) {

        String questionTitle = editText.getText().toString() ;
        Intent intent = new Intent() ;
        intent.setAction(intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,questionTitle+"\n"+question);
        intent.setType("text/plain");
        startActivity(intent);



        // اضافية
        SharedPreferences sharedPreferences = getSharedPreferences("app" , MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("share title",questionTitle) ;
        editor.apply();


    }

    public void onClickBack(View view ) {
        finish();
    }

}
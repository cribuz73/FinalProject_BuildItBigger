package com.example.android.androidlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Delivery extends AppCompatActivity {

    private static final String JOKE_INTENT = "joke_intent";
    private static final String JOKE_STATE = "joke_state";

    private String aJoke;
    private int aJokeId;
    private ArrayList<String> jokesArray;
    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_display);
        textView = findViewById(R.id.jokeView);

        jokesArray = new ArrayList<>();

        if(getIntent().getExtras() != null){
            jokesArray = getIntent().getStringArrayListExtra(JOKE_INTENT);
        }

        if(jokesArray == null){
            Toast.makeText(this, "Error !!!", Toast.LENGTH_SHORT).show();
        }else {
            aJokeId = new Random().nextInt(jokesArray.size());
            showJoke();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(JOKE_STATE, aJokeId);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){
            aJokeId = savedInstanceState.getInt(JOKE_STATE);
            showJoke();
        }
    }

    public void showJoke() {
        aJoke = jokesArray.get(aJokeId);
        textView.setText(aJoke);
    }


}

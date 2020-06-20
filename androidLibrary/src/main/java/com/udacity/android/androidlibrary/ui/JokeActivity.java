package com.udacity.android.androidlibrary.ui;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.android.androidlibrary.R;
import com.udacity.android.androidlibrary.model.Joke;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    private static final String JOKE_TYPE_SINGLE = "single";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Joke joke = getIntent().getParcelableExtra(JOKE_KEY);
        displayJoke(joke);
    }

    public void goBackForJokes(View view) {
        finish();
    }

    private void displayJoke(Joke joke) {
        TextView jokeLine = findViewById(R.id.joke_line);
        TextView delivery = findViewById(R.id.delivery_line);
        if (JOKE_TYPE_SINGLE.equals(joke.jokeType)) {
            jokeLine.setText(joke.joke);
            delivery.setVisibility(View.INVISIBLE);

        } else {
            jokeLine.setText(joke.setup);
            delivery.setText(joke.delivery);
        }
    }
}

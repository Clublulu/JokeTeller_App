package com.udacity.android.androidlibrary.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.udacity.android.androidlibrary.R;
import com.udacity.android.androidlibrary.model.Joke;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    private static final String JOKE_TYPE_SINGLE = "single";

    private static final String LOG_TAG = JokeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "entered onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Joke joke = getIntent().getParcelableExtra(JOKE_KEY);
        displayJoke(joke);
    }

    public void goBackForJokes(View view) {
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "entered onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "entered onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "entered onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "entered onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "entered onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "entered onRestart");
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

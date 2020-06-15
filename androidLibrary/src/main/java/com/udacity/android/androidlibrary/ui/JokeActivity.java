package com.udacity.android.androidlibrary.ui;


import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.udacity.android.androidlibrary.R;
import com.udacity.android.androidlibrary.databinding.ActivityJokeBinding;
import com.udacity.android.androidlibrary.model.Joke;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityJokeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joke);
        Joke joke = getIntent().getParcelableExtra(JOKE_KEY);
        binding.setJoke(joke);


    }
}

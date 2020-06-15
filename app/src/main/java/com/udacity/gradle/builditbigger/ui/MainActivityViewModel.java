package com.udacity.gradle.builditbigger.ui;

import androidx.lifecycle.ViewModel;

import com.udacity.gradle.builditbigger.data.JokesRepository;
import com.udacity.gradle.builditbigger.model.Joke;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivityViewModel extends ViewModel {

    private static final int NUM_LOWER_BOUND = 0;


    private List<Joke> mJokes;

    public MainActivityViewModel(JokesRepository jokesRepository) {
        mJokes = jokesRepository.getJokes();
    }

    public Joke getRandomJoke() {
        int randomIndex = ThreadLocalRandom.current().nextInt(NUM_LOWER_BOUND, mJokes.size());
        return mJokes.get(randomIndex);
    }

}

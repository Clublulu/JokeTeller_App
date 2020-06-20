package com.udacity.gradle.builditbigger.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.udacity.gradle.builditbigger.data.JokesRepository;
import com.udacity.gradle.builditbigger.model.Joke;

public class MainActivityViewModel extends ViewModel {

    private static JokesRepository mRepository;

    public MainActivityViewModel(JokesRepository jokesRepository) {
        mRepository = jokesRepository;
    }

    public LiveData<Joke> getRandomJoke() {
        return mRepository.getJoke();
    }

}

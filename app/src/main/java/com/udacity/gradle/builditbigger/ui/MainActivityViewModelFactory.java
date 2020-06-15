package com.udacity.gradle.builditbigger.ui;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.udacity.gradle.builditbigger.data.JokesRepository;

public class MainActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final JokesRepository mJokesRepository;

    public MainActivityViewModelFactory(JokesRepository repository) {
        mJokesRepository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new MainActivityViewModel(mJokesRepository);
    }

}

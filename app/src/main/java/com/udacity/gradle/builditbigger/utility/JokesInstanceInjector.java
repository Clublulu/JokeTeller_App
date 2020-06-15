package com.udacity.gradle.builditbigger.utility;

import android.content.Context;

import com.udacity.gradle.builditbigger.data.AppExecutors;
import com.udacity.gradle.builditbigger.data.JokesDataSource;
import com.udacity.gradle.builditbigger.data.JokesRepository;
import com.udacity.gradle.builditbigger.ui.MainActivityViewModelFactory;

public final class JokesInstanceInjector {


    public static MainActivityViewModelFactory provideMainActivityViewModelFactory(Context context) {
        return new MainActivityViewModelFactory(provideRepository());
    }

    private static JokesRepository provideRepository() {
        return JokesRepository.getInstance(
                    JokesDataSource.getInstance(),
                    AppExecutors.getInstance());
    }

}

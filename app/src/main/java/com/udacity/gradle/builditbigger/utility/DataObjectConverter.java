package com.udacity.gradle.builditbigger.utility;

import com.udacity.gradle.builditbigger.model.Joke;

public final class DataObjectConverter {


    public static Joke convertJokeModel(com.udacity.gradle.builditbigger.backend.myApi.model.Joke backendJoke) {
        return new Joke(
                backendJoke.getJokeType(),
                backendJoke.getJoke(),
                backendJoke.getSetup(),
                backendJoke.getDelivery(),
                backendJoke.getJokeId());
    }

    public static com.udacity.android.androidlibrary.model.Joke convertJokeModel(Joke appJoke) {
        return new com.udacity.android.androidlibrary.model.Joke(
                appJoke.jokeType,
                appJoke.joke,
                appJoke.setup,
                appJoke.delivery,
                appJoke.jokeId);
    }

}

package com.udacity.gradle.builditbigger.utility;

import com.udacity.gradle.builditbigger.model.Joke;

import java.util.ArrayList;
import java.util.List;

public final class DataObjectConverter {


    public static List<Joke> convertJokeModel(List<com.udacity.gradle.builditbigger.backend.myApi.model.Joke> backendJokes) {
        List<Joke> appJokes = new ArrayList<>();

        for (com.udacity.gradle.builditbigger.backend.myApi.model.Joke backendJoke : backendJokes) {
            appJokes.add(new Joke(backendJoke.getSetupLine(), backendJoke.getPunchLine()));
        }

        return appJokes;
    }

    public static com.udacity.android.androidlibrary.model.Joke convertJokeModel(Joke appJoke) {
        return new com.udacity.android.androidlibrary.model.Joke(appJoke.setupLine, appJoke.punchLine);
    }

}

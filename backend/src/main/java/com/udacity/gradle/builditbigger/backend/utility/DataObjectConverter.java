package com.udacity.gradle.builditbigger.backend.utility;

import com.udacity.gradle.builditbigger.backend.model.Joke;

import java.util.ArrayList;
import java.util.List;

public final class DataObjectConverter {


    public static List<Joke> convertJokeModel(List<com.udacity.android.javajokes.model.Joke> javaJokeJokes) {
        List<Joke> backendJokes = new ArrayList<>();

        for (com.udacity.android.javajokes.model.Joke javaJoke : javaJokeJokes) {
            backendJokes.add(new Joke(javaJoke.setupLine, javaJoke.punchLine));
        }

        return backendJokes;
    }
}

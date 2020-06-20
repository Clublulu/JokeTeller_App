package com.udacity.gradle.builditbigger.backend.utility;

import com.udacity.gradle.builditbigger.backend.model.Joke;

import java.util.ArrayList;
import java.util.List;

public final class DataObjectConverter {


    public static Joke convertJokeModel(com.udacity.android.javajokes.model.Joke javaJoke) {
        return new Joke(javaJoke.jokeType, javaJoke.joke, javaJoke.setup, javaJoke.delivery, javaJoke.jokeId);
    }
}

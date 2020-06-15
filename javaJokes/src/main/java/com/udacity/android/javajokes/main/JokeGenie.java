package com.udacity.android.javajokes.main;

import com.udacity.android.javajokes.data.JokeGenerator;
import com.udacity.android.javajokes.model.Joke;

import java.util.List;

public final class JokeGenie {

    private static JokeGenie sInstance;
    private static List<Joke> jokes;


    private JokeGenie() {
        jokes = JokeGenerator.getInstance().generateJokes();
    }

    public static JokeGenie getInstance() {
        if (sInstance == null) {
            sInstance = new JokeGenie();
        }

        return sInstance;
    }

    public List<Joke> getJokes() {
        return jokes;
    }
}

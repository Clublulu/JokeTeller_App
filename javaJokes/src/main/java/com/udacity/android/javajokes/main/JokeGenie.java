package com.udacity.android.javajokes.main;

import com.udacity.android.javajokes.data.JokeGenerator;
import com.udacity.android.javajokes.model.Joke;

public final class JokeGenie {

    private static JokeGenie sInstance;


    private JokeGenie() {}

    public static JokeGenie getInstance() {
        if (sInstance == null) {
            sInstance = new JokeGenie();
        }

        return sInstance;
    }

    public Joke getJoke() {
        return JokeGenerator.getInstance().getJoke();
    }



}

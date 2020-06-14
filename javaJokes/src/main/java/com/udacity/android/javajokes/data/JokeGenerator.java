package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class that generates jokes.
 *
 */
public final class JokeGenerator {

    private static JokeGenerator sInstance;

    private JokeGenerator() {};


    public static synchronized JokeGenerator getInstance() {
        if (sInstance == null) {
            sInstance = new JokeGenerator();
        }

        return sInstance;
    }

    public List<Joke> generateJokes() {
        List<Joke> jokes = new ArrayList<>();

        jokes.add(createJoke(JokeConstants.JOKE_1, JokeConstants.JOKE_1_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_2, JokeConstants.JOKE_2_PUNCH));

        return jokes;
    }

    private Joke createJoke(String setupLine, String punchLine) {
        return new Joke(setupLine, punchLine);
    }

}

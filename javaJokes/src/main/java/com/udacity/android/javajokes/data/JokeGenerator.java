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
        jokes.add(createJoke(JokeConstants.JOKE_3, JokeConstants.JOKE_3_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_4, JokeConstants.JOKE_4_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_5, JokeConstants.JOKE_5_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_6, JokeConstants.JOKE_6_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_7, JokeConstants.JOKE_7_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_8, JokeConstants.JOKE_8_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_9, JokeConstants.JOKE_9_PUNCH));
        jokes.add(createJoke(JokeConstants.JOKE_10, JokeConstants.JOKE_10_PUNCH));

        return jokes;
    }

    private Joke createJoke(String setupLine, String punchLine) {
        return new Joke(setupLine, punchLine);
    }

}

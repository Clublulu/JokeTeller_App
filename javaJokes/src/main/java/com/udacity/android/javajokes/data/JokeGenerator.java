package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import io.reactivex.Observable;

/**
 * Mediator class between the Entry point to JavaJokes module and its Data Source class.
 * Calls the Data Source to retrieve a Joke and pass it to the client.
 *
 */
public final class JokeGenerator {

    private static JokeGenerator sInstance;
    private static JokesDataSource mDataSource;
    private Joke mJoke;

    private JokeGenerator() {
        mDataSource = JokesDataSource.getInstance();
    };


    public static synchronized JokeGenerator getInstance() {
        if (sInstance == null) {
            sInstance = new JokeGenerator();
        }

        return sInstance;
    }

   public Joke getJoke() {
        Observable<Joke> jokeObservable = mDataSource.getJoke();
        jokeObservable.subscribe(joke -> mJoke = joke);
        return mJoke;
   }
}

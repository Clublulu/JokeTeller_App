package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import io.reactivex.Observable;

/**
 * Jokes Data Source that calls the retrofit client to help retrieve a random joke.
 *
 */
public final class JokesDataSource {

    private static JokesDataSource sInstance;
    private static RetrofitClient mRetrofitClient;

    private JokesDataSource() {
        mRetrofitClient = RetrofitClient.getInstance();
    }

    public static JokesDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new JokesDataSource();
        }

        return sInstance;
    }


    public Observable<Joke> getJoke() {
        return mRetrofitClient.getJokesAPI().fetchJoke();
    }
}

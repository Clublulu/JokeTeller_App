package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import io.reactivex.Observable;

public final class JokesDataSource {

    public static final String JOKES_API_BASE_URL = "https://sv443.net/jokeapi/v2/joke/any/";


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
        return mRetrofitClient.getJokesAPI().fetchJoke("single");
    }
}

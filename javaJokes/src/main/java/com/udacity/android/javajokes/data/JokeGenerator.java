package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Helper class that generates jokes.
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
        jokeObservable.subscribe(new Observer<Joke>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Joke value) {
                mJoke = value;
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                String a = " reached on complete";
            }
        });
        return mJoke;
   }



}

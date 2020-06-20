package com.udacity.gradle.builditbigger.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.udacity.gradle.builditbigger.model.Joke;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Repository class that retrieves data from the data source.
 *
 */
public final class JokesRepository {

    private static JokesRepository sInstance;
    private static JokesDataSource mDataSource;
    private static AppExecutors mExecutor;


    private JokesRepository(JokesDataSource jokesDataSource, AppExecutors appExecutors) {
        mDataSource = jokesDataSource;
        mExecutor = appExecutors;

    }


    public static JokesRepository getInstance(JokesDataSource jokesDataSource, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new JokesRepository(jokesDataSource, appExecutors);
        }

        return sInstance;
    }

    public LiveData<Joke> getJoke() {
//        Callable<Joke> callable = () -> mDataSource.fetchJoke();
//        Future<Joke> future = ((ExecutorService)
//                mExecutor.getDiskExecutor()).submit(callable);
//        Joke joke = null;
//        try {
//            joke =  future.get();
//        } catch (ExecutionException | InterruptedException e) {
//            e.printStackTrace();
//        }
        mExecutor.getNetworkExecutor().execute(() -> mDataSource.fetchJoke());


        return mDataSource.getJoke();
    }



}

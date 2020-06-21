package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;


public class JokesDataSourceTest {


    @Test
    public void testGetJokeFromAPI() {
        Observable<Joke> testJokeObservable = JokesDataSource.getInstance().getJoke();
        TestObserver<Joke> testObserver = new TestObserver<>();
        testJokeObservable.subscribe(testObserver);

        testObserver.assertComplete();
        testObserver.assertNoErrors();
    }

}


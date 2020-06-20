package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JokesAPI {

    @GET(".")
    Observable<Joke> fetchJoke(@Query("type") String jokeType);

}

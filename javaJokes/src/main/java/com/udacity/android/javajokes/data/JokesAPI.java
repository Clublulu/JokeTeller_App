package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface JokesAPI {

    @GET("any")
    Observable<Joke> fetchJoke();

}

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.android.javajokes.main.JokeGenie;
import com.udacity.gradle.builditbigger.backend.model.Joke;
import com.udacity.gradle.builditbigger.backend.utility.DataObjectConverter;

import java.util.List;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getJokes")
    public List<Joke> getJokes() {
        List<com.udacity.android.javajokes.model.Joke> javaJokesJoke = JokeGenie.getInstance().getJokes();
        return DataObjectConverter.convertJokeModel(javaJokesJoke);
    }

}

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.android.javajokes.main.JokeGenie;
import com.udacity.gradle.builditbigger.backend.model.Joke;
import com.udacity.gradle.builditbigger.backend.utility.DataObjectConverter;


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


    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke backendJoke = DataObjectConverter
                .convertJokeModel(JokeGenie.getInstance().getJoke());
        return backendJoke;
    }
}

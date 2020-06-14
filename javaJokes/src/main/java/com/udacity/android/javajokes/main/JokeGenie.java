package com.udacity.android.javajokes.main;

import com.udacity.android.javajokes.data.JokeGenerator;
import com.udacity.android.javajokes.model.Joke;

import java.util.List;

public class JokeGenie {


    public List<Joke> getJokes() {
        return JokeGenerator.getInstance().generateJokes();
    }



}

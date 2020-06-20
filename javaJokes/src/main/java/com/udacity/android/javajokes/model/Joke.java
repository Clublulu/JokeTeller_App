package com.udacity.android.javajokes.model;

public class Joke {

    public String jokeType;
    public String joke;
    public String setup;
    public String delivery;
    public int jokeId;

    public Joke(String jokeType, String joke, int jokeId) {
        this.jokeType = jokeType;
        this.joke = joke;
        this.jokeId = jokeId;
    }

    public Joke(String jokeType, String setup, String delivery, int jokeId) {
        this.jokeType = jokeType;
        this.setup = setup;
        this.delivery = delivery;
        this.jokeId = jokeId;

    }


}

package com.udacity.gradle.builditbigger.backend.model;

public class Joke {

    public String jokeType;
    public String joke;
    public String setup;
    public String delivery;
    public int jokeId;

    public Joke(String jokeType, String joke, String setup, String delivery, int jokeId) {
        this.jokeType = jokeType;
        this.joke = joke;
        this.setup = setup;
        this.delivery = delivery;
        this.jokeId = jokeId;
    }
}

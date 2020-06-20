package com.udacity.android.javajokes.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.udacity.android.javajokes.model.Joke;

import java.lang.reflect.Type;

public class JokeDeserializer implements JsonDeserializer<Joke> {

    private static final String JOKE_TYPE_ONE_PART = "onepart";


    @Override
    public Joke deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jokeJson = json.getAsJsonObject();
        String jokeType = jokeJson.get("type").getAsString();
        int jokeId = jokeJson.get("id").getAsInt();

        Joke joke;
        if (JOKE_TYPE_ONE_PART.equals(jokeType)) {
            String onePartJoke = jokeJson.get("joke").getAsString();
            joke = new Joke(jokeType, onePartJoke, jokeId);
        } else {
            String jokeSetup = jokeJson.get("setup").getAsString();
            String jokeDelivery = jokeJson.get("delivery").getAsString();
            joke = new Joke(jokeType, jokeSetup, jokeDelivery, jokeId);
        }

        return joke;
    }




}

package com.udacity.android.javajokes.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.udacity.android.javajokes.constant.JavaJokesConstant;
import com.udacity.android.javajokes.model.Joke;

import java.lang.reflect.Type;

/**
 * Deserializes the Json Joke Response into its java Joke model.
 *
 */
public class JokeDeserializer implements JsonDeserializer<Joke> {


    @Override
    public Joke deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jokeJson = json.getAsJsonObject();
        String jokeType = jokeJson.get(JavaJokesConstant.JSON_JOKE_TYPE).getAsString();
        int jokeId = jokeJson.get(JavaJokesConstant.JSON_JOKE_ID).getAsInt();

        Joke joke;
        if (JavaJokesConstant.JSON_JOKE_TYPE_SINGLE.equals(jokeType)) {
            String onePartJoke = jokeJson.get(JavaJokesConstant.JSON_JOKE_SINGLE).getAsString();
            joke = new Joke(jokeType, onePartJoke, jokeId);
        } else {
            String jokeSetup = jokeJson.get(JavaJokesConstant.JSON_JOKE_TWOPART_SETUP).getAsString();
            String jokeDelivery = jokeJson.get(JavaJokesConstant.JSON_JOKE_TWOPART_DELIVERY).getAsString();
            joke = new Joke(jokeType, jokeSetup, jokeDelivery, jokeId);
        }

        return joke;
    }
}

package com.udacity.android.javajokes.data;

import com.udacity.android.javajokes.model.Joke;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class JokesGeneratorTest {


    @Test
    public void testGetJokeFromGenerator() {
        Joke joke = JokeGenerator.getInstance().getJoke();
        assertNotNull(joke);
    }
}

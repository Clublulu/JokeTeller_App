package com.udacity.gradle.builditbigger.ui;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class JokeActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(MainActivity.class, false, false);


    @Test
    public void testJokeRetrievedFromBackendAndSuccessfullyDisplayed() {

    }
}
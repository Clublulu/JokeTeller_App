package com.udacity.gradle.builditbigger.ui;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class JokeActivityTest {


    @Rule
    public ActivityTestRule<MainActivity> mTestRule = new ActivityTestRule<>(MainActivity.class, false, true);


    @Test
    public void testJokeRetrievedFromBackendAndSuccessfullyDisplayed() {
        onView(withId(R.id.tell_joke_button)).check(
                matches(withText(getStringResource(R.string.button_text))));
        onView(withId(R.id.tell_joke_button)).perform(click());
        onView(withId(R.id.tell_another_joke_button)).check(
                matches(withText(getStringResource(R.string.tell_another_joke_button_label))));
    }

    private String getStringResource(int resId) {
        return mTestRule.getActivity().getResources().getString(resId);
    }
}

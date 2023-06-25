package com.example.cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testMainActivity(){

          //onView(withId(R.id.buttonShowData)).perform(click());
          onView(withId(R.id.addActivity)).check(matches(isDisplayed()));
          onView(withId(R.id.textViewHeading)).check(matches(withText("Cardiac Recorder")));
          onView(withId(R.id.textView)).check(matches(isDisplayed()));
          onView(withId(R.id.textView2)).check(matches(isDisplayed()));
          onView(withId(R.id.textView3)).check(matches(isDisplayed()));
          onView(withId(R.id.textView4)).check(matches(isDisplayed()));
          onView(withId(R.id.textView5)).check(matches(isDisplayed()));

          onView(withId(R.id.editTextTextPersonName2)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName3)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName4)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName5)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName6)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextTextPersonName7)).check(matches(isDisplayed()));

        onView(withId(R.id.btnAdd)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()));

        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("01/02/2023"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editTextTextPersonName3)).perform(typeText("10:00"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editTextTextPersonName4)).perform(typeText("100"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editTextTextPersonName5)).perform(typeText("120"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editTextTextPersonName6)).perform(typeText("170"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.editTextTextPersonName7)).perform(typeText("First data record"));
        Espresso.closeSoftKeyboard();


        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        //onView(withId(R.id.btnAdd)).perform(ViewActions.click());
        onView(withId(R.id.btnBack)).perform(ViewActions.click());

        Espresso.onIdle();
        onView(withId(R.id.controllActivity)).check(matches(isDisplayed()));

    }
}
package com.example.cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

public class controllTest {

    @Rule
    public ActivityScenarioRule<controll> activityScenarioRule = new ActivityScenarioRule<>(controll.class);

    @Test
    public void testControllPage(){
        onView(withId(R.id.controllActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.textView6)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonShowData)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonAddData)).check(matches(isDisplayed()));

        onView(withId(R.id.buttonShowData)).perform(click());
        onView(withId(R.id.addActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.btnBack)).perform(click());
        Espresso.onIdle();
        onView(withId(R.id.controllActivity)).check(matches(isDisplayed()));

        onView(withId(R.id.buttonAddData)).perform(click());
        Espresso.onIdle();
        onView(withId(R.id.recyclerViewPage)).check(matches(isDisplayed()));
    }
}
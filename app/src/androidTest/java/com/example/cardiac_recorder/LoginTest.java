package com.example.cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class LoginTest {
    @Rule
    public ActivityScenarioRule<Login> activityScenarioRule = new ActivityScenarioRule<>(Login.class);

    @Test
    public void testLoginPage(){
        onView(withId(R.id.loginActivity)).check(matches(isDisplayed()));
        onView(withId(R.id.loginText)).check(matches(withText("Login")));
        onView(withId(R.id.phone)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
        onView(withId(R.id.login_button)).check(matches(isDisplayed()));
        onView(withId(R.id.bottomText1)).check(matches(isDisplayed()));
        onView(withId(R.id.register_now_button)).check(matches(isDisplayed()));

        onView(withId(R.id.phone)).perform(typeText("01234567890"));
        Espresso.onIdle();
        Espresso.pressBack();
        onView(withId(R.id.password)).perform(replaceText("0000"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.login_button)).perform(ViewActions.click());

    }
}
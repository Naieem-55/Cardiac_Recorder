package com.example.cardiac_recorder;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.replaceText;
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

public class RegisterTest {
    @Rule
    public ActivityScenarioRule<Register> activityScenarioRule = new ActivityScenarioRule<>(Register.class);

    @Test
    public void testRegister(){
        onView(withId(R.id.activityRegister)).check(matches(isDisplayed()));
        onView(withId(R.id.registerText)).check(matches(withText("Register")));
        onView(withId(R.id.full_name)).check(matches(isDisplayed()));
        onView(withId(R.id.phone)).check(matches(isDisplayed()));
        onView(withId(R.id.email)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
        onView(withId(R.id.confirmPassword)).check(matches(isDisplayed()));
        onView(withId(R.id.register_here_button)).check(matches(isDisplayed()));
        onView(withId(R.id.belowText)).check(matches(isDisplayed()));
        onView(withId(R.id.login_now_button)).check(matches(isDisplayed()));

        onView(withId(R.id.full_name)).perform(replaceText("Mohammad"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.phone)).perform(replaceText("01234567899"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.email)).perform(replaceText("mohammd@gmail.com"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.password)).perform(replaceText("9999"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.confirmPassword)).perform(replaceText("9999"));
        Espresso.closeSoftKeyboard();
        Espresso.onIdle();
        onView(withId(R.id.register_here_button)).perform(ViewActions.click());
    }

}
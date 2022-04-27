package com.example.ad340profile;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mainActivityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void canGoThroughForm() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name))
                .check(matches(withText("Jeffrey Chau")));
    }

    @Test
    public void cannotGoThroughFormWithMissingName() {
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Jeffrey Chau")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingEmail() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("jchau@gmail.com")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingUsername() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Jdawg")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingDescription() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("A long description about how I became king")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingOccupation() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Metalshop worker")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithBadEmail() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmaiewasdl.comawdw"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("jchau@gmail.com")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithYoungDob() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2010, 3, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("2/2/1999")).check(doesNotExist());
    }

    @Test
    public void canGoBackFromWelcomeScreen() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("Jdawg"));
        onView(withId(R.id.descriptionField)).perform(replaceText("A long description about how I became king"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalshop worker"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(1999, 2, 2));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name))
                .check(matches(withText("Jeffrey Chau")));

        onView(withId(R.id.backButton)).perform(click());

        onView(withId(R.id.nameField)).check(matches(withText("")));
    }

}

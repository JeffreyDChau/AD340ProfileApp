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
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name))
                .check(matches(withText("Jeffrey Chau")));
    }

    @Test
    public void cannotGoThroughFormWithMissingName() {
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Jeffrey Chau")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingEmail() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("JChau@gmail.com")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingUsername() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("JeffJeff")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingDescription() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Description of me")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithMissingOccupation() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Metalsmith")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithBadEmail() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("Jchau@gmail")).check(doesNotExist());
    }

    @Test
    public void cannotGoThroughFormWithYoungDob() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2021, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withText("3/5/2000")).check(doesNotExist());
    }

    @Test
    public void canGoBackFromWelcomeScreen() {
        onView(withId(R.id.nameField)).perform(replaceText("Jeffrey Chau"));
        onView(withId(R.id.emailAddress)).perform(replaceText("Jchau@gmail.com"));
        onView(withId(R.id.usernameField)).perform(replaceText("JeffJeff"));
        onView(withId(R.id.descriptionField)).perform(replaceText("Description of me"));
        onView(withId(R.id.occupationField)).perform(replaceText("Metalsmith"));

        onView(withId(R.id.dobButton)).perform(click());

        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
                .perform(PickerActions.setDate(2000, 2 + 1, 5));

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.submitButton)).perform(click());

        onView(withId(R.id.name))
                .check(matches(withText("Jeffrey Chau")));

        onView(withId(R.id.backButton)).perform(click());

        onView(withId(R.id.nameField)).check(matches(withText("Jeffrey Chau")));
    }

}

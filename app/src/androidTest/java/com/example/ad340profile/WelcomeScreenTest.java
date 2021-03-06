package com.example.ad340profile;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static com.example.ad340profile.RecyclerViewMatcherTest.withRecyclerView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class WelcomeScreenTest {
    @Rule
    public ActivityScenarioRule<WelcomeScreen> welcomeScreenActivity =
            new ActivityScenarioRule<>(WelcomeScreen.class);

    @Test
    public void clickingOnMatchesDrawerItemDisplaysMatchesFragment() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        onView(withId(R.id.matches_menu_item)).perform(click());

        onView(withRecyclerView(R.id.recycler_view).atPosition(0))
                .check(matches(hasDescendant(withText("Mark Palpatine"))));
        onView(withRecyclerView(R.id.recycler_view).atPosition(1))
                .check(matches(hasDescendant(withText("Grumpy cat"))));
        onView(withRecyclerView(R.id.recycler_view).atPosition(2))
                .check(matches(hasDescendant(withText("Steve"))));
        onView(withRecyclerView(R.id.recycler_view).atPosition(3))
                .check(matches(hasDescendant(withText("Random Duck"))));
    }
}

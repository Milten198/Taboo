package com.projectgroup.taboo;


import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainMenuButtonsTests {

    public static final String NEW_GAME = "Team names";
    public static final String SETTINGS = "Settings";
    public static final String ABOUT = "About";
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void openNewGame() throws Exception {
        clickButton(R.id.startButton);
        checkText(NEW_GAME);
    }

    @Test
    public void openSettings() throws Exception {
        clickButton(R.id.settingsButton);
        checkText(SETTINGS);
    }

    @Test
    public void openAbout() throws Exception {
        clickButton(R.id.aboutButton);
        checkText(ABOUT);
    }

    private void checkText(String toCheck) {
        onView(withText(toCheck))
                .check(matches(isDisplayed()));
    }

    private void clickButton(int buttonId) {
        onView(withId(buttonId))
                .perform(click());
    }

}

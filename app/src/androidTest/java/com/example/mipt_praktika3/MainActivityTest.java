package com.example.mipt_praktika3;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    // Basic Number Input Tests
    @Test
    public void testNumberInput() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("123")));
    }

    @Test
    public void testSingleDigitInput() {
        onView(withId(R.id.btnFive)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("5")));
    }

    // Addition Tests
    @Test
    public void testSimpleAddition() {
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("8")));
    }

    @Test
    public void testChainedAddition() {
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("9")));
    }

    // Subtraction Tests
    @Test
    public void testSimpleSubtraction() {
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnSubtract)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("5")));
    }

    // Multiplication Tests
    @Test
    public void testSimpleMultiplication() {
        onView(withId(R.id.btnFour)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("20")));
    }

    // Division Tests
    @Test
    public void testSimpleDivision() {
        onView(withId(R.id.btnEight)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("4")));
    }

    @Test
    public void testDivisionByZero() {
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnDivide)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("Error")));
    }

    // Square Root Tests
    @Test
    public void testSquareRoot() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnSix)).perform(click());
        onView(withId(R.id.btnSqrt)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("4")));
    }

    // Decimal Tests
    @Test
    public void testDecimalInput() {
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnFour)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("3.14")));
    }

    @Test
    public void testDecimalCalculation() {
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnDecimal)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("4")));
    }

    // Clear Tests
    @Test
    public void testClearButton() {
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnSeven)).perform(click());
        onView(withId(R.id.btnClear)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("0")));
    }

    @Test
    public void testClearEntryButton() {
        onView(withId(R.id.btnNine)).perform(click());
        onView(withId(R.id.btnEight)).perform(click());
        onView(withId(R.id.btnClearEntry)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("0")));
    }

    // Backspace Test
    @Test
    public void testBackspaceButton() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnThree)).perform(click());
        onView(withId(R.id.btnBackspace)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("12")));
    }

    // Sign Change Test
    @Test
    public void testSignChangeButton() {
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnSign)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("-5")));
    }

    // Complex Operation Test
    @Test
    public void testComplexCalculation() {
        onView(withId(R.id.btnOne)).perform(click());
        onView(withId(R.id.btnZero)).perform(click());
        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnFive)).perform(click());
        onView(withId(R.id.btnMultiply)).perform(click());
        onView(withId(R.id.btnTwo)).perform(click());
        onView(withId(R.id.btnEquals)).perform(click());

        onView(withId(R.id.txtDisplay))
                .check(matches(withText("30")));
    }
}
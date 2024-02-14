package com.roc.escapethejail

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest
{
    @Test
    fun useAppContext()
    {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.roc.escapethejail", appContext.packageName)
    }

    @Test
    fun change_view_correctly()
    {
        onView(withId(R.id.settings)).perform(click())
        onView(withId(R.layout.settings)).check(matches(isDisplayed()))
    }
}
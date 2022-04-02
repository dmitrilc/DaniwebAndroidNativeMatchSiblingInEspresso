package com.example.daniwebandroidnativematchsiblinginespresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_matchSibling() {
        onView(allOf(
            withId(R.id.layout_viewHolder),
            hasSibling(allOf(
                withId(R.id.layout_viewHolder),
                withChild(allOf(
                    withId(R.id.textView_name),
                    withText("Mary"),
                    hasSibling(allOf(
                        withId(R.id.textView_title),
                        withText("Teacher"),
                        hasSibling(allOf(
                            withId(R.id.textView_age),
                            withText("28")
                        ))
                    ))
                ))
            ))
        ))

        //One liner
        //onView(hasSibling(withChild(withText("Mary"))))
    }

    @Test
    fun test_matchChildrenSiblings(){
        onView(allOf(
            withId(R.id.layout_viewHolder),
            withChild(allOf(
                withId(R.id.textView_name),
                withText("John"),
                hasSibling(allOf(
                    withId(R.id.textView_title),
                    withText("Student"),
                    hasSibling(allOf(
                        withId(R.id.textView_age),
                        withText("17")
                    ))
                ))
            ))
        )).check(matches(isDisplayed()))

        //One liner
        //onView(withChild(withText("John")))
    }
}
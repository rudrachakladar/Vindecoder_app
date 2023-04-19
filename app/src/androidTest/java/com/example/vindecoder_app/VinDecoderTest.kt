package com.example.vindecoder_app

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class VinDecoderTest {



    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }


    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()
    @Test
    fun testButton()

    {
        val str="VIN: JNKCA21A4XT770979\nVehicle Type: PASSENGER CAR\nPlant City: YOKOSUKA CITY\nPlant Company Name: Oppama Plant\nPlant Country: JAPAN\nPlant State: KANAGAWA\nMake: INFINITI\n"
        onView(withId(R.id.vinEditText)).perform(typeText("JNKCA21A4XT770979"))
        onView(withId(R.id.submitBtn)).perform(click())
       // Thread.sleep(3000)
       // onView(withId(R.id.recyclerview)).check(matches(withText(str)))

    }

}
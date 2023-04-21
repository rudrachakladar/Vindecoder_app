package com.example.vindecoder_app

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.stub
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Shubham Singh on 19/04/23.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class VinDecoderUITest {

    private lateinit var scenario: ActivityScenario<MainActivity>

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var vehicleApi: Vehicleapi

    @Before
    fun setUp() {
        hiltRule.inject()

        val result = Result(VIN = "JNKCA21A4XT770979", VehicleType = "type", PlantCity = "city",
            PlantCompanyName = "company", PlantCountry = "country", PlantState = "state", Make = "make", ModelYear = "2022", Model = "model")

        val vinResponse = VinResponse(1, "success", listOf(result), "search")

        vehicleApi.stub {
            onBlocking { getVinDetails(any()) } doReturn Response.success(vinResponse)
        }
        scenario = launchActivity()
    }

    @Test
    fun verifyUI() {
        Espresso.onView(withId(R.id.vinEditText)).check(matches(withHint("Enter VIN (17 characters)")))
        Espresso.onView(withId(R.id.submitBtn)).check(matches(withText("Submit")))
    }

    @Test
    fun verifyButton() {
        Espresso.onView(withId(R.id.vinEditText)).perform(typeText("JNKCA21A4XT770979"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(R.id.submitBtn)).perform(click())
        //Similarly check for more fields
        Espresso.onView(withText("2022")).check(matches(isDisplayed()))
    }

    @After
    fun tearDown() {
        if(::scenario.isInitialized) {
            scenario.close()
        }
    }
}
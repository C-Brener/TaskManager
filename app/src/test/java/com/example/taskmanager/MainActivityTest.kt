package com.example.taskmanager

import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.SemanticsPropertyKey
import androidx.compose.ui.semantics.SemanticsPropertyReceiver
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.core.app.ActivityScenario
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out // Redirect Logcat to console
    }

    @Test
    fun `Ensure the SplashScreen init with informations provided `() {
        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity { activity: MainActivity ->
                    activity.setContent {
                        SplashScreen(
                            imageResource = painterResource(id = R.drawable.ic_task_completed),
                            taskStatus = "Caique",
                            subTitle = "Brener"
                        )
                    }
                    composeTestRule
                        .onNodeWithTag("Title")
                        .assertIsDisplayed()
                        .assertTextEquals("Caique")
                }
            }

    }

    @Test
    fun `Ensure the SplashScreen init with App Name in the Text When the composable is called with taskStatus parameter null`() {
        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity { activity: MainActivity ->
                    activity.setContent {
                        SplashScreen(
                            imageResource = painterResource(id = R.drawable.ic_task_completed),
                            taskStatus = null,
                            subTitle = "Brener"
                        )
                    }

                    composeTestRule.onNodeWithTag("Title").assertTextEquals("TaskManager")

                }
            }

    }


}

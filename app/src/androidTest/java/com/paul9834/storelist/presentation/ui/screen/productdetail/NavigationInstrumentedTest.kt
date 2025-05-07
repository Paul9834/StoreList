package com.paul9834.storelist.presentation.ui.screen.productdetail

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.paul9834.storelist.presentation.MainActivity
import org.junit.Rule
import org.junit.Test

class NavigationInstrumentedTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigateToDetail_onItemCardClick() {
        composeRule
            .onNodeWithTag("ItemCard_1")
            .assertIsDisplayed()
            .performClick()

        composeRule
            .onNodeWithTag("DetailScreen")
            .assertIsDisplayed()
    }
}
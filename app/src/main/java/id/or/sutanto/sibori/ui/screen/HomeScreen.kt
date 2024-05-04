package id.or.sutanto.sibori.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.or.sutanto.core.analytics.AnalyticsHelper
import id.or.sutanto.sibori.logScreenView
import id.or.sutanto.sibori.logUserAction

@Composable
fun HomeScreen(
    analyticsHelper: AnalyticsHelper,
) {
    analyticsHelper.logScreenView("home_screen open")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                analyticsHelper.logUserAction("button test_crash")
                throw RuntimeException("Test Crash")
            },
        ) {
            Text(text = "Test Crash")
        }
    }
}
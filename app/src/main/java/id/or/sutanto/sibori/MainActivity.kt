package id.or.sutanto.sibori

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import id.or.sutanto.core.analytics.AnalyticsHelper
import id.or.sutanto.core.analytics.NoOpAnalyticsHelper
import id.or.sutanto.sibori.ui.screen.HomeScreen
import id.or.sutanto.core.designsystem.theme.SiboriTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var analyticsHelper: AnalyticsHelper
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        analyticsHelper.logScreenView("main_activity open")
        setContent {
            SiboriTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    EventApplication(
                        analyticsHelper = analyticsHelper,
                    )
                }
            }
        }
    }
}

@Composable
fun EventApplication(
    analyticsHelper: AnalyticsHelper
) {
    HomeScreen(
        analyticsHelper = analyticsHelper,
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    
    SiboriTheme {
        EventApplication(
            analyticsHelper = NoOpAnalyticsHelper(),
        )
    }
}
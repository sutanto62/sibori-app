package id.or.sutanto.sibori.di

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import id.or.sutanto.core.analytics.AnalyticsHelper
import id.or.sutanto.core.analytics.FirebaseAnalyticsHelper
import id.or.sutanto.core.analytics.StubAnalyticsHelper
import id.or.sutanto.sibori.BuildConfig

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {
    
    @Provides
    fun logEvent(): AnalyticsHelper {
        return if (BuildConfig.BUILD_TYPE == "release") {
            Log.d("AnalyticsHelper", "Release mode")
            FirebaseAnalyticsHelper()
        } else {
            Log.d("AnalyticsHelper", "Debug mode")
            StubAnalyticsHelper()
        }
    }
}
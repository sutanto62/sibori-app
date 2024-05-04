package id.or.sutanto.core.analytics

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoOpAnalyticsHelper @Inject constructor() : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) = Unit
}
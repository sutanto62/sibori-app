package id.or.sutanto.sibori

import id.or.sutanto.core.analytics.AnalyticsEvent
import id.or.sutanto.core.analytics.AnalyticsEvent.Types
import id.or.sutanto.core.analytics.AnalyticsEvent.Param
import id.or.sutanto.core.analytics.AnalyticsHelper

fun AnalyticsHelper.logScreenView(screenName: String) {
    logEvent(
        AnalyticsEvent(
            type = Types.SCREEN_VIEW,
            customKeys = listOf(
                Param(key = "screen_name", value = screenName),
            ),
            message = "Log screen view $screenName",
            user = "Sutanto or empty"
        )
    )
}

fun AnalyticsHelper.logUserAction(clickableId: String) {
    logEvent(
        AnalyticsEvent(
            type = "user_action",
            customKeys = listOf(
                Param(key = "clickable", value = clickableId),
                Param(key = "logged_in", value = "today")
            ),
            message = "user action $clickableId",
            user = "Sutanto or empty"
        )
    )
}
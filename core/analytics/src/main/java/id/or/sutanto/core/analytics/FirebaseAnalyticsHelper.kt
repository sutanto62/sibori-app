package id.or.sutanto.core.analytics

import com.google.firebase.Firebase
import com.google.firebase.crashlytics.crashlytics
import javax.inject.Inject
import javax.inject.Singleton

/*
 * Implements AnalyticsHelper using Firebase Crashlytics.
 */
@Singleton
class FirebaseAnalyticsHelper @Inject constructor() : AnalyticsHelper {
    override fun logEvent(event: AnalyticsEvent) {
        
        if (event.type.isNotEmpty()) {
            Firebase.crashlytics.log(event.type)
        }
        
        if (event.message.isNotEmpty()) {
            Firebase.crashlytics.log(event.message)
        }
        
        if (event.user.isNotEmpty()) {
            Firebase.crashlytics.setUserId(event.user)
        }
        
        for (param in event.customKeys) {
            Firebase.crashlytics.setCustomKey(param.key, param.value)
        }
    }
}
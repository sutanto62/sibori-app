package id.or.sutanto.core.analytics

data class AnalyticsEvent(
    val type: String,
    val customKeys: List<Param> = emptyList(),
    val message: String = "",
    val user: String = "",
) {
    
    class Types {
        companion object {
            const val SCREEN_VIEW = "screen_view"
        }
    }
    
    data class Param(val key: String, val value: String)
    
    
}

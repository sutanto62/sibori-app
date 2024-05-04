# :core:analytics module

The purpose of the `AnalyticsHelper` interface is to define a common interface for logging analytics events. This interface allows for different implementations, such as `FirebaseAnalyticsHelper` and `StubAnalyticsHelper`, to log the events in their respective ways.

The `StubAnalyticsHelper` class is a singleton that simply writes events to logcat with global TAG variable `SIBORI`. It is used in builds where no analytics events should be sent to a backend.

The `FirebaseAnalyticsHelper` class, on the other hand, logs events to a Firebase project. It uses `FirebaseAnalytics` library to log eventns and includes logic to truncate paramameter keys and values acconding to Firebase's maximum length values.

There's is mock `NoOpAnalyticsHelper` which does nothing. Useful for tests and previews. 

## How To Use

To use the `AnalyticsHelper` module from another Android module, you'll need to follow these steps:

  1. Add a dependency: In your build.gradle (Module: app) file, add the following line to specify that your app module depends on the module containing the `AnalyticsHelper`. Replace `:path-to-analytics-helper-module` with the actual path to the module containing the `AnalyticsHelper`.

```
implementation project(':path-to-analytics-helper-module')
```

  2. Inject the AnalyticsHelper: In the module where you want to use the `AnalyticsHelper`, add the necessary dependencies and annotations. For example, if you're using Dagger 2 or Koin for dependency injection, you'll need to include the respective dependencies in your build.gradle (Module: app) file.
  ```
  @Inject
  lateinit var analyticsHelper: AnalyticsHelper
  ```

  3. Access the AnalyticsHelper: Once the AnalyticsHelper is injected, you can use it in your code, similar to how it's used in the MainActivity example.

  4. Create an extension function for the AnalyticsHelper class on other modules. This function will call logEvent function and construct the Event.
  ```
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
  ```

Remember that the specific implementation details may vary depending on the tools and libraries you're using, but the general approach remains the same. By following these steps, you'll be able to utilize the AnalyticsHelper module from another Android module in your project.

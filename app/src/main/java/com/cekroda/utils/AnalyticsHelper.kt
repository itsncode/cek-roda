package com.cekroda.utils

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

object AnalyticsHelper {
    private var delegate: FirebaseAnalytics? = null
  
  fun init(firebaseAnalytics: FirebaseAnalytics) {
      delegate = firebaseAnalytics
  }
  
  /**
  * Logs an event to Firebase Analytics.
  *
  * @param name The name of the event to log.
  * @param params A map of parameters to log with the event. The keys and values
  * of the map will be converted to [String]s if necessary.
  */
  fun logEvent(name: String, params: Map<String, String> = emptyMap()) {
      val bundle = Bundle().apply {
          params.forEach { (key, value) ->
              putString(key, value)
          }
      }
      delegate?.logEvent(name, bundle)
   }
}

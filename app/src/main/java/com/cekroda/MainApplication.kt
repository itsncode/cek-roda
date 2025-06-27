package com.cekroda

import android.app.Application
import com.cekroda.di.appModule
import com.cekroda.utils.AnalyticsHelper
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModule)
        }

        val firebaseAnalytics = get<FirebaseAnalytics>()
        AnalyticsHelper.init(firebaseAnalytics)
    }
}

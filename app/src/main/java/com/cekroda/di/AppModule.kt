package com.cekroda.di

import androidx.room.Room
import com.cekroda.data.local.AppDatabase
import com.cekroda.data.repository.InspectionRepository
import com.cekroda.data.repository.InspectionRepositoryImpl
import com.cekroda.presentation.home.HomeViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "inspection_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().inspectionDao() }

    single<InspectionRepository>{ InspectionRepositoryImpl(get()) }

    single { 
        FirebaseAnalytics.getInstance(get()) }
    }

    viewModel { HomeViewModel(get()) }
}

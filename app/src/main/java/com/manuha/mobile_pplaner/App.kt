package com.manuha.mobile_pplaner

import android.app.Application
import androidx.room.Room
import com.manuha.mobile_pplaner.data.database.AppDatabase
import com.manuha.mobile_pplaner.data.issueRepo
import com.manuha.mobile_pplaner.data.projectRepo
import com.manuha.mobile_pplaner.domain.AddDemoIssuesUseCase
import com.manuha.mobile_pplaner.domain.AddDemoProjectsUseCase
import kotlinx.coroutines.runBlocking

/**
 * Main entry point into the application process.
 * Registered in the AndroidManifest.xml file.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(this, AppDatabase::class.java, "app")
            .apply {
                if (BuildConfig.DEBUG) fallbackToDestructiveMigration()
            }
            .allowMainThreadQueries().build()

        runBlocking {
            AddDemoIssuesUseCase(issueRepo)()
            AddDemoProjectsUseCase(projectRepo)()
        }
    }

    companion object {
        lateinit var database: AppDatabase
    }
}

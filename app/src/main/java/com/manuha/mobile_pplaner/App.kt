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

        /*
         In a real app we should never use runBlocking {}. Especially not on app start up.
         However, we would need to refactor the ProductsRepository to use Flow. Therefore, we accept this hack for now. After all, it is
         just a demo app.
         The real solution would be to launch a coroutine in the app scope:
         private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
         scope.launch {  }
         */

        runBlocking {
            AddDemoIssuesUseCase(issueRepo)()
            AddDemoProjectsUseCase(projectRepo)()
        }
    }

    companion object {
        lateinit var database: AppDatabase
    }
}

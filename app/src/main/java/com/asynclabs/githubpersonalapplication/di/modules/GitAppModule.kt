package com.asynclabs.githubpersonalapplication.di.modules

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.DisplayMetrics
import androidx.preference.PreferenceManager
import com.asynclabs.githubpersonalapplication.config.GitAppInfo
import com.asynclabs.githubpersonalapplication.data.DataRepository
import com.asynclabs.githubpersonalapplication.data.RealmService
import com.asynclabs.githubpersonalapplication.data.RemoteDataSources
import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import com.asynclabs.githubpersonalapplication.utils.GitAppPrefManager
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.PublishSubject


@Module
class GitAppModule(private val application: Application) {

    @ApplicationScope
    @Provides
    fun providesApplicationContext(): Context = application.applicationContext

    @ApplicationScope
    @Provides
    fun providesSharedPreferences(): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(application)

    @ApplicationScope
    @Provides
    fun providerDisplayMetrics(): DisplayMetrics = application.resources.displayMetrics

    @ApplicationScope
    @Provides
    fun providerPublishSubject(): PublishSubject<Any> = PublishSubject.create()

    @ApplicationScope
    @Provides
    fun providesDataRepository(
        remoteDataSources: RemoteDataSources,
        gitAppPrefManager: GitAppPrefManager,
        realmService: RealmService
    ) = DataRepository(
        remoteDataSources,
        gitAppPrefManager,
        realmService
    )

    @ApplicationScope
    @Provides
    fun providesAppInfo() = GitAppInfo()

}
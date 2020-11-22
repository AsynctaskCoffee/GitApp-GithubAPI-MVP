package com.asynclabs.githubpersonalapplication.di.modules

import android.app.Application
import com.asynclabs.githubpersonalapplication.data.RealmService
import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import io.realm.Realm
import javax.inject.Named

@Module
class LocalModule(private val application: Application) {

    @ApplicationScope
    @Provides
    @Named("Realm")
    fun provideDefaultRealm(): Realm? {
        return Realm.getDefaultInstance()
    }

    @ApplicationScope
    @Provides
    fun provideRealmService(@Named("Realm") realm: Realm) = RealmService(realm)

}
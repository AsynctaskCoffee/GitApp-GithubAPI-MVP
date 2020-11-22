package com.asynclabs.githubpersonalapplication.di.modules

import com.asynclabs.githubpersonalapplication.data.RealmService
import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class LocalModule() {

    @ApplicationScope
    @Provides
    fun provideRealmService() = RealmService(Realm.getDefaultInstance())

}
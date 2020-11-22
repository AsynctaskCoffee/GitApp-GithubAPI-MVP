package com.asynclabs.githubpersonalapplication.di.components

import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import com.asynclabs.githubpersonalapplication.di.modules.GitAppModule
import com.asynclabs.githubpersonalapplication.di.modules.LocalModule
import com.asynclabs.githubpersonalapplication.di.modules.RemoteModule
import com.asynclabs.githubpersonalapplication.ui.detail.DetailActivity
import com.asynclabs.githubpersonalapplication.ui.main.MainActivity
import dagger.Component

@ApplicationScope
@Component(modules = [GitAppModule::class, RemoteModule::class, LocalModule::class])
interface GitAppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)
}
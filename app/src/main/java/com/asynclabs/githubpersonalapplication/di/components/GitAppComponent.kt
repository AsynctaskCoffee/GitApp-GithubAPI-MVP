package com.asynclabs.githubpersonalapplication.di.components

import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import com.asynclabs.githubpersonalapplication.di.modules.GitAppModule
import com.asynclabs.githubpersonalapplication.di.modules.RemoteModule
import dagger.Component

@ApplicationScope
@Component(modules = [GitAppModule::class, RemoteModule::class])
interface GitAppComponent {

}
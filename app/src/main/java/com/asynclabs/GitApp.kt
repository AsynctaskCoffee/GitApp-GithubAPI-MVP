package com.asynclabs

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import com.asynclabs.githubpersonalapplication.di.components.DaggerGitAppComponent
import com.asynclabs.githubpersonalapplication.di.components.GitAppComponent
import com.asynclabs.githubpersonalapplication.di.modules.GitAppModule
import com.asynclabs.githubpersonalapplication.di.modules.RemoteModule

class GitApp : Application(), LifecycleObserver {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    val applicationComponent: GitAppComponent =
        DaggerGitAppComponent
            .builder()
            .gitAppModule(GitAppModule(this))
            .remoteModule(RemoteModule(this))
            .build()
}
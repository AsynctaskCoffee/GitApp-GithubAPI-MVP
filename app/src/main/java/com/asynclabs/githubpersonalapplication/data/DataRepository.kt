package com.asynclabs.githubpersonalapplication.data

import com.asynclabs.githubpersonalapplication.utils.GitAppPrefManager
import javax.inject.Inject

open class DataRepository @Inject constructor(
    private val remoteDataSources: RemoteDataSources,
    private val gitAppPrefManager: GitAppPrefManager
)
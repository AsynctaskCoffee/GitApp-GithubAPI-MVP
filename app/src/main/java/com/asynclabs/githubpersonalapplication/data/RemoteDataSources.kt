package com.asynclabs.githubpersonalapplication.data

import javax.inject.Inject

open class RemoteDataSources @Inject constructor(
    private val remoteEndPoints: RemoteEndPoints,
)
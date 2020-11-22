package com.asynclabs.githubpersonalapplication.data

import javax.inject.Inject

open class RemoteDataSources @Inject constructor(
    private val remoteEndPoints: RemoteEndPoints,
) {
    fun getRepoDetails(
        userName: String,
        repoName: String
    ) = remoteEndPoints.getRepoDetails(
        userName,
        repoName
    )

    fun getRepoList(
        userName: String
    ) = remoteEndPoints.getRepoList(
        userName
    )
}
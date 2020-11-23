package com.asynclabs.githubpersonalapplication.data

import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.utils.GitAppPrefManager
import javax.inject.Inject

open class DataRepository @Inject constructor(
    private val remoteDataSources: RemoteDataSources,
    private val gitAppPrefManager: GitAppPrefManager,
    private val realmService: RealmService
) {
    fun getRepoDetails(
        userName: String,
        repoName: String
    ) = remoteDataSources.getRepoDetails(
        userName,
        repoName
    )

    fun getRepoReadmeDetails(
        userName: String,
        repoName: String
    ) = remoteDataSources.getRepoReadmeDetails(
        userName,
        repoName
    )

    fun getRepoList(
        userName: String
    ) = remoteDataSources.getRepoList(
        userName
    )

    fun addFav(id: String, repoName: String) = realmService.addFav(repoName, id)
    fun removeFav(id: String) = realmService.removeFav(id)
    fun isFav(id: String) = realmService.isFav(id)
}
package com.asynclabs.githubpersonalapplication.data

import com.asynclabs.githubpersonalapplication.data.remotemodels.ReadmeResponse
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteEndPoints {
    @GET("repos/{userName}/{repoName}")
    fun getRepoDetails(
        @Path("userName") userName: String,
        @Path("repoName") repoName: String
    ): Single<RepoResponse>

    @GET("users/{userName}/repos")
    fun getRepoList(
        @Path("userName") userName: String
    ): Single<List<RepoResponse>>

    @GET("repos/{userName}/{repoName}/readme")
    fun getRepoReadmeDetails(
        @Path("userName") userName: String,
        @Path("repoName") repoName: String
    ): Single<ReadmeResponse>

}
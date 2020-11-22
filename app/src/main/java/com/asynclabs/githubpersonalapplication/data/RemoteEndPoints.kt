package com.asynclabs.githubpersonalapplication.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteEndPoints {
    @GET("repos/{userName}/{repoName}")
    fun getRepoDetails(
        @Path("userName") userName: String,
        @Path("repoName") repoName: String
    ): Single<Any>

    @GET("users/{userName}/repos")
    fun getRepoList(
        @Path("userName") userName: String
    ): Single<Any>
}
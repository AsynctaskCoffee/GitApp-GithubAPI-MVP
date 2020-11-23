package com.asynclabs.githubpersonalapplication.data.remotemodels

import android.os.Parcelable
import com.asynclabs.githubpersonalapplication.data.RealmService
import com.google.gson.annotations.SerializedName
import io.realm.Realm
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import javax.inject.Inject

@Parcelize
data class RepoResponse(

    @field:SerializedName("private")
    val jsonMemberPrivate: Boolean? = null,

    @field:SerializedName("has_downloads")
    val hasDownloads: Boolean? = null,

    @field:SerializedName("stargazers_count")
    val stargazersCount: Int? = null,

    @field:SerializedName("pushed_at")
    val pushedAt: String? = null,

    @field:SerializedName("open_issues_count")
    val openIssuesCount: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("watchers")
    val watchers: Int? = null,

    @field:SerializedName("has_projects")
    val hasProjects: Boolean? = null,

    @field:SerializedName("archived")
    val archived: Boolean? = null,

    @field:SerializedName("has_wiki")
    val hasWiki: Boolean? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("disabled")
    val disabled: Boolean? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("has_pages")
    val hasPages: Boolean? = null,

    @field:SerializedName("owner")
    val owner: Owner? = null,

    @field:SerializedName("forks")
    val forks: Int? = null,

    @field:SerializedName("has_issues")
    val hasIssues: Boolean? = null,

    @field:SerializedName("mirror_url")
    val mirrorUrl: String? = null,

    @field:SerializedName("license")
    val license: License? = null,

    @field:SerializedName("fork")
    val fork: Boolean? = null,

    @field:SerializedName("full_name")
    val fullName: String? = null,

    @field:SerializedName("size")
    val size: Int? = null,

    @field:SerializedName("html_url")
    val htmlUrl: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("default_branch")
    val defaultBranch: String? = null,

    @field:SerializedName("open_issues")
    val openIssues: Int? = null,

    @field:SerializedName("watchers_count")
    val watchersCount: Int? = null,

    @field:SerializedName("node_id")
    val nodeId: String? = null,

    @field:SerializedName("language")
    val language: String? = null,

    @field:SerializedName("forks_count")
    val forksCount: Int? = null
) : Parcelable {

    fun isFav() = RealmService(Realm.getDefaultInstance()).isFav(id.toString())

}

@Parcelize
data class Owner(

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("node_id")
    val nodeId: String? = null
) : Parcelable

@Parcelize
data class License(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("spdx_id")
    val spdxId: String? = null,

    @field:SerializedName("key")
    val key: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("node_id")
    val nodeId: String? = null
) : Parcelable

package com.asynclabs.githubpersonalapplication.data.remotemodels

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReadmeResponse(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("html_url")
	val htmlUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("download_url")
	val downloadUrl: String? = null,

	@field:SerializedName("git_url")
	val gitUrl: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("encoding")
	val encoding: String? = null,

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("content")
	val content: String? = null
) : Parcelable

@Parcelize
data class Links(

	@field:SerializedName("git")
	val git: String? = null,

	@field:SerializedName("self")
	val self: String? = null,

	@field:SerializedName("html")
	val html: String? = null
) : Parcelable

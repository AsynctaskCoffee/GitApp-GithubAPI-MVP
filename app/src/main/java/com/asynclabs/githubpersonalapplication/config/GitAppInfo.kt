package com.asynclabs.githubpersonalapplication.config
import com.asynclabs.githubpersonalapplication.BuildConfig
class GitAppInfo {
    val version: String = BuildConfig.VERSION_NAME
    val isDev: Boolean = BuildConfig.IS_DEVELOPMENT
    val platformVersion: String = android.os.Build.VERSION.RELEASE
}
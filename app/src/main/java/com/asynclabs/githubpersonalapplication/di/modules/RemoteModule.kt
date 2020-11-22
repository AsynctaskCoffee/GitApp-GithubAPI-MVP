package com.asynclabs.githubpersonalapplication.di.modules

import android.app.Application
import com.asynclabs.githubpersonalapplication.data.RemoteEndPoints
import com.asynclabs.githubpersonalapplication.di.scope.ApplicationScope
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import com.asynclabs.githubpersonalapplication.BuildConfig


@Module
class RemoteModule(private val application: Application) {

    companion object {
        const val CACHE_SIZE = 5 * 1024 * 1024L
    }

    @ApplicationScope
    @Provides
    fun provideGson() = GsonBuilder().create()

    @ApplicationScope
    @Provides
    fun provideOkHttpCache() = Cache(application.cacheDir, CACHE_SIZE)


    @ApplicationScope
    @Provides
    @Named("RemoteOkHttpClient")
    fun provideRemoteOkHttpClient(cache: Cache) =
        with(OkHttpClient.Builder()) {
            cache(cache)
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(logging)
            build()
        }

    @ApplicationScope
    @Provides
    @Named("Retrofit")
    fun provideRetrofit(gson: Gson, @Named("RemoteOkHttpClient") okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BuildConfig.githubEndPoint)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @ApplicationScope
    @Provides
    fun provideRemoteApiService(@Named("Retrofit") retrofit: Retrofit) = retrofit.create(
        RemoteEndPoints::class.java
    )
}
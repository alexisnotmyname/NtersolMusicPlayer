package com.alex.ntersolexam.model

import com.alex.ntersolexam.BuildConfig
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val api = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(SongsApi::class.java)

    fun searchSongs(platform: String, postType: String): Single<List<Songs>> {
        return api.searchSongs(platform, postType)
    }
}






package com.alex.ntersolexam.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SongsApi {

    @GET("api/v1/public/posts/search")
    fun searchSongs(@Query("platform") platform: String, @Query("postType") postType: String) : Single<List<Songs>>
}
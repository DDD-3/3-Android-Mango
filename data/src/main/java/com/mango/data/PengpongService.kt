package com.mango.data

import com.mango.data.entitiy.DataEntityPengpong
import retrofit2.http.GET

interface PengpongService {

    @GET("dummy")
    suspend fun getList(): List<DataEntityPengpong>


    /*@GET("search/users")
    suspend fun getSearchUsers(
        @Query("q") q: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): DataEntityGithub*/

}
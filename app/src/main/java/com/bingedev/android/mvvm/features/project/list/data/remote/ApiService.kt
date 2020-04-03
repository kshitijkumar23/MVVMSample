package com.bingedev.android.mvvm.features.project.list.data.remote;

import com.bingedev.android.mvvm.features.project.list.data.model.Project
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Kshitij Kumar
 */

interface ApiService {

    @GET("users/{user}/repos")
    suspend fun getProjectList(@Path("user") user: String): List<Project>

    @GET("/repos/{user}/{reponame}")
    suspend  fun getProjectDetails(@Path("user") user: String, @Path("reponame") projectName: String?): Project

    companion object {
        val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }
}
package com.bingedev.android.mvvm.features.project.detail

import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import com.bingedev.android.mvvm.features.project.list.data.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kshitij Kumar
 */

@Singleton
class ProjectRepository @Inject
constructor(private val gitHubService: ApiService) {

    fun getProjectDetails(userID: String, projectName: String?): Flow<ViewState<Project>> {
        return flow {
            emit(ViewState.loading())
            val newsSource = gitHubService.getProjectDetails(userID, projectName)
            emit(ViewState.success(newsSource))
        }.catch {
            emit(ViewState.error(it.message.orEmpty()))
        }.flowOn(Dispatchers.IO)
    }
}
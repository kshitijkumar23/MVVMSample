package com.bingedev.android.mvvm.features.project.list.domain

import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import com.bingedev.android.mvvm.features.project.list.data.repository.ProjectListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

class ProjectListUseCase @Inject constructor(private val projectListRepository: ProjectListRepository) {

    fun getProjectList(): Flow<ViewState<List<Project>>> =
        projectListRepository.getProjectList("Google")
}
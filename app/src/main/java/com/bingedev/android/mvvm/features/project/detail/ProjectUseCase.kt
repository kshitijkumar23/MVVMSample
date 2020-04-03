package com.bingedev.android.mvvm.features.project.detail

import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

class ProjectUseCase @Inject constructor(private val projectRepository: ProjectRepository) {

    fun getProjectDetails(projectName: String?): Flow<ViewState<Project>> =
        projectRepository.getProjectDetails("Google", projectName)
}
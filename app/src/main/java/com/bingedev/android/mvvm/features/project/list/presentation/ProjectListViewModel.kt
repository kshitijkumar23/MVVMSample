package com.bingedev.android.mvvm.features.project.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.bingedev.android.mvvm.base.BaseViewModel
import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import com.bingedev.android.mvvm.features.project.list.domain.ProjectListUseCase
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

class ProjectListViewModel @Inject constructor(private val projectListUseCase: ProjectListUseCase) :
    BaseViewModel() {

    private val projectList: LiveData<ViewState<List<Project>>> =
        projectListUseCase.getProjectList().asLiveData()

    fun getProjectList(): LiveData<ViewState<List<Project>>> = projectList
}
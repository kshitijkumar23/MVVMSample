package com.bingedev.android.mvvm.features.project.detail

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.bingedev.android.mvvm.base.BaseViewModel
import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

class ProjectViewModel @Inject
constructor(private val projectUseCase: ProjectUseCase) : BaseViewModel() {

    private var projectName: MutableLiveData<String> = MutableLiveData()

    var project = ObservableField<Project>()

    fun setProject(project: Project) {
        this.project.set(project)
    }

    fun setProjectName(projectName: String?) {
        this.projectName.value = projectName
    }

    fun getProjectDetails(): LiveData<ViewState<Project>> =
        projectUseCase.getProjectDetails(projectName.value).asLiveData()
}
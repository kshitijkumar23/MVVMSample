package com.bingedev.android.mvvm.features.project.list.presentation

import com.bingedev.android.mvvm.features.project.list.data.model.Project

/**
 * @author Kshitij Kumar
 */

interface ProjectClickCallback {

    fun onClick(project: Project)
}
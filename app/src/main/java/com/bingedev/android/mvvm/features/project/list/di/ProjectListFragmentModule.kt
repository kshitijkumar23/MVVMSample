package com.bingedev.android.mvvm.features.project.list.di

import androidx.lifecycle.ViewModel
import com.bingedev.android.mvvm.di.ViewModelKey
import com.bingedev.android.mvvm.features.project.list.presentation.ProjectListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * @author Kshitij Kumar
 */

@Module
class ProjectListFragmentModule {

    @Provides
    @IntoMap
    @ViewModelKey(ProjectListViewModel::class)
    fun provideProjectListViewModel(projectListViewModel: ProjectListViewModel): ViewModel =
        projectListViewModel
}
package com.bingedev.android.mvvm.features.project.detail

import androidx.lifecycle.ViewModel
import com.bingedev.android.mvvm.di.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * @author Kshitij Kumar
 */

@Module
class ProjectFragmentModule {

    @Provides
    @IntoMap
    @ViewModelKey(ProjectViewModel::class)
    fun provideProjectViewModel(projectViewModel: ProjectViewModel): ViewModel = projectViewModel
}
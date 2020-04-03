package com.bingedev.android.mvvm.features.project

import com.bingedev.android.mvvm.features.project.detail.ProjectFragment
import com.bingedev.android.mvvm.features.project.detail.ProjectFragmentModule
import com.bingedev.android.mvvm.features.project.list.presentation.ProjectListFragment
import com.bingedev.android.mvvm.features.project.list.di.ProjectListFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Kshitij Kumar
 */

@Module
abstract class ProjectListActivityModule {

    @ContributesAndroidInjector(modules = [ProjectFragmentModule::class])
    internal abstract fun contributeProjectFragment(): ProjectFragment

    @ContributesAndroidInjector(modules = [ProjectListFragmentModule::class])
    internal abstract fun contributeProjectListFragment(): ProjectListFragment
}
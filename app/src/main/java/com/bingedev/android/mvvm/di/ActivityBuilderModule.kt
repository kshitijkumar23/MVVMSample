package com.bingedev.android.mvvm.di

import com.bingedev.android.mvvm.features.authentication.AuthenticationActivity
import com.bingedev.android.mvvm.features.authentication.AuthenticationActivityModule
import com.bingedev.android.mvvm.features.project.ProjectListActivity
import com.bingedev.android.mvvm.features.project.ProjectListActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Kshitij Kumar
 */

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [AuthenticationActivityModule::class])
    abstract fun contributeAuthenticationActivity(): AuthenticationActivity

    @ContributesAndroidInjector(modules = [(ProjectListActivityModule::class)])
    abstract fun contributeProjectListActivity(): ProjectListActivity
}
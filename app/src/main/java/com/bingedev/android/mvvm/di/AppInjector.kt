package com.bingedev.android.mvvm.di

import com.bingedev.android.mvvm.MvvmSampleApp

/**
 * @author Kshitij Kumar
 */

object AppInjector {
    fun init(mvvmSampleApp: MvvmSampleApp) {
        DaggerAppComponent.builder().application(mvvmSampleApp).build().inject(mvvmSampleApp)
    }
}
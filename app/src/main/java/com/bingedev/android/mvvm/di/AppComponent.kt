package com.bingedev.android.mvvm.di

import com.bingedev.android.mvvm.MvvmSampleApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Kshitij Kumar
 */

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MvvmSampleApp): Builder

        fun build(): AppComponent
    }

    fun inject(application: MvvmSampleApp)
}
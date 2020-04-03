package com.bingedev.android.mvvm.features.authentication.register

import androidx.lifecycle.ViewModel
import com.bingedev.android.mvvm.di.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * @author Kshitij Kumar
 */

@Module
class RegisterFragmentModule {

    @Provides
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    fun provideRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel =
        registerViewModel
}
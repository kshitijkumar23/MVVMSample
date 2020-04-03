package com.bingedev.android.mvvm.features.authentication.login

import androidx.lifecycle.ViewModel
import com.bingedev.android.mvvm.di.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

/**
 * @author Kshitij Kumar
 */

@Module
class LoginFragmentModule {

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel = loginViewModel
}
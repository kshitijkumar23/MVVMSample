package com.bingedev.android.mvvm.features.authentication

import com.bingedev.android.mvvm.features.authentication.login.LoginFragment
import com.bingedev.android.mvvm.features.authentication.login.LoginFragmentModule
import com.bingedev.android.mvvm.features.authentication.register.RegisterFragment
import com.bingedev.android.mvvm.features.authentication.register.RegisterFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Kshitij Kumar
 */

@Module
abstract class AuthenticationActivityModule {

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    internal abstract fun contributeLoginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [RegisterFragmentModule::class])
    internal abstract fun contributeRegisterFragment(): RegisterFragment
}
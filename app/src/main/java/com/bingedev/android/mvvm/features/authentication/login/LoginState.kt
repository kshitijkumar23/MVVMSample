package com.bingedev.android.mvvm.features.authentication.login

/**
 * @author Kshitij Kumar
 */

data class LoginState(
    val isLoginEnabled: Boolean = false,
    val hasError: Boolean = false
)

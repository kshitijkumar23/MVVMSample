package com.bingedev.android.mvvm.features.authentication.login

import androidx.lifecycle.MutableLiveData
import com.bingedev.android.mvvm.base.BaseViewModel
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

class LoginViewModel @Inject constructor() : BaseViewModel() {

    companion object {
        private const val PHONE_NUMBER_LENGTH = 10
        private const val PASSWORD_MIN_LENGTH = 4
    }

    var phoneNumber = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    fun isPhoneNumberAndPasswordValid(): Boolean {
        return PHONE_NUMBER_LENGTH == phoneNumber.value?.length
                && password.value?.length!! >= PASSWORD_MIN_LENGTH
    }

    fun onPasswordTextChanged(password: CharSequence) {
    }

    fun onLoginClick(): Unit {
    }

}

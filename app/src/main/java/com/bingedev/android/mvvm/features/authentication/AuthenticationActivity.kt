package com.bingedev.android.mvvm.features.authentication

import android.os.Bundle
import com.bingedev.android.mvvm.R
import com.bingedev.android.mvvm.base.BaseActivity
import com.bingedev.android.mvvm.features.authentication.login.LoginFragment

/**
 * @author Kshitij Kumar
 */

class AuthenticationActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.authentication_activity

    override fun initView() {
    }

    override fun initData() {
    }

    override fun startObserve() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }
}

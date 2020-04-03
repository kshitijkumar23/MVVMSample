package com.bingedev.android.mvvm.features.authentication.login

import com.bingedev.android.mvvm.R
import com.bingedev.android.mvvm.base.BaseFragment

/**
 * @author Kshitij Kumar
 */

class LoginFragment : BaseFragment<LoginViewModel>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override val layoutRes: Int
        get() = R.layout.login_fragment

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun startObserve() {
    }

}

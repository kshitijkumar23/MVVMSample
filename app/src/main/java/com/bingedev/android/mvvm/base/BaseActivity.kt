package com.bingedev.android.mvvm.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

abstract class BaseActivity(useDataBinding: Boolean = true) : AppCompatActivity(),
    HasSupportFragmentInjector {

    private val useBinding = useDataBinding

    @Inject
    lateinit var fragmentAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var dataBinding: ViewDataBinding

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun initView()

    abstract fun initData()

    abstract fun startObserve()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        startObserve()
        if (useBinding) {
            dataBinding = DataBindingUtil.setContentView(this, layoutRes)
        } else {
            setContentView(layoutRes)
        }

        initView()
        initData()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentAndroidInjector
    }
}

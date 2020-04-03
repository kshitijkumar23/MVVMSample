package com.bingedev.android.mvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * @author Kshitij Kumar
 */

abstract class BaseFragment<VM : BaseViewModel>(useDataBinding: Boolean = true) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: VM
    lateinit var dataBinding: ViewDataBinding
    private val useBinding = useDataBinding

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun getViewModel(): Class<VM>

    abstract fun initView()

    abstract fun initData()

    abstract fun startObserve()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (useBinding) {
            dataBinding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
            dataBinding.root
        } else {
            inflater.inflate(layoutRes, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())
        initView()
        initData()
        startObserve()
    }
}

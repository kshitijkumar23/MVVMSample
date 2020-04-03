package com.bingedev.android.mvvm.features.project.detail

import android.os.Bundle
import com.bingedev.android.mvvm.R
import com.bingedev.android.mvvm.base.BaseFragment
import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.databinding.ProjectFragmentBinding
import com.bingedev.android.mvvm.util.ext.observeNotNull
import com.bingedev.android.mvvm.util.ext.toast

/**
 * @author Kshitij Kumar
 */

class ProjectFragment : BaseFragment<ProjectViewModel>() {

    companion object {
        private const val KEY_PROJECT_NAME = "project_name"
        fun forProject(projectName: String?): ProjectFragment {
            val fragment =
                ProjectFragment()
            val args = Bundle()
            args.putString(KEY_PROJECT_NAME, projectName)
            fragment.arguments = args
            return fragment
        }
    }

    override val layoutRes: Int
        get() = R.layout.project_fragment

    override fun getViewModel(): Class<ProjectViewModel> {
        return ProjectViewModel::class.java
    }

    override fun initView() {
    }

    override fun initData() {
        viewModel.setProjectName(arguments!!.getString(KEY_PROJECT_NAME))
        (dataBinding as ProjectFragmentBinding).projectViewModel = viewModel
        (dataBinding as ProjectFragmentBinding).isLoading = true
    }

    override fun startObserve() {
        viewModel.getProjectDetails().observeNotNull(
            this
        ) { state ->
            when (state) {
                is ViewState.Success -> {
                    (dataBinding as ProjectFragmentBinding).isLoading = false
                    viewModel.setProject(state.data)
                }
                is ViewState.Loading -> (dataBinding as ProjectFragmentBinding).isLoading = true
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }
    }
}

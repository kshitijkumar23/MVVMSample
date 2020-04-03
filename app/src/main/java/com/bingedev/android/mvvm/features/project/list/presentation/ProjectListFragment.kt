package com.bingedev.android.mvvm.features.project.list.presentation

import androidx.lifecycle.Lifecycle
import com.bingedev.android.mvvm.R
import com.bingedev.android.mvvm.base.BaseFragment
import com.bingedev.android.mvvm.base.ViewState
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import com.bingedev.android.mvvm.databinding.ProjectListFragmentBinding
import com.bingedev.android.mvvm.features.project.ProjectListActivity
import com.bingedev.android.mvvm.util.ext.observeNotNull
import com.bingedev.android.mvvm.util.ext.toast

/**
 * @author Kshitij Kumar
 */

class ProjectListFragment : BaseFragment<ProjectListViewModel>() {

    private lateinit var projectAdapter: ProjectAdapter

    private val projectClickCallback = object :
        ProjectClickCallback {
        override fun onClick(project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as ProjectListActivity).show(project)
            }
        }
    }

    companion object {
        const val TAG = "ProjectListFragment"
    }

    override val layoutRes: Int
        get() = R.layout.project_list_fragment

    override fun getViewModel(): Class<ProjectListViewModel> {
        return ProjectListViewModel::class.java
    }

    override fun initView() {
        projectAdapter =
            ProjectAdapter(
                projectClickCallback
            )
        (dataBinding as ProjectListFragmentBinding).projectList.adapter = projectAdapter
        (dataBinding as ProjectListFragmentBinding).isLoading = true
    }

    override fun initData() {
    }

    override fun startObserve() {
        // Update the UI on state change
        viewModel.getProjectList().observeNotNull(this) { state ->
            when (state) {
                is ViewState.Success -> {
                    projectAdapter.setProjectList(state.data)
                    (dataBinding as ProjectListFragmentBinding).isLoading = false
                }
                is ViewState.Loading -> (dataBinding as ProjectListFragmentBinding).isLoading = true
                is ViewState.Error -> toast("Something went wrong ¯\\_(ツ)_/¯ => ${state.message}")
            }
        }

    }
}
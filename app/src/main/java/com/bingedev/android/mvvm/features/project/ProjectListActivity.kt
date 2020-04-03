package com.bingedev.android.mvvm.features.project

import android.os.Bundle
import com.bingedev.android.mvvm.R
import com.bingedev.android.mvvm.base.BaseActivity
import com.bingedev.android.mvvm.features.project.list.data.model.Project
import com.bingedev.android.mvvm.features.project.detail.ProjectFragment
import com.bingedev.android.mvvm.features.project.list.presentation.ProjectListFragment

/**
 * @author Kshitij Kumar
 */

class ProjectListActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.project_list_activity

    override fun initView() {
    }

    override fun initData() {
    }

    override fun startObserve() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            val fragment = ProjectListFragment()

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment, ProjectListFragment.TAG)
                .commit()
        }
    }

    /** Shows the project detail fragment  */
    fun show(project: Project) {
        val projectFragment = ProjectFragment.forProject(project.name)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("project")
            .replace(
                R.id.fragment_container,
                projectFragment, null
            ).commit()
    }
}
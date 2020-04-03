package com.bingedev.android.mvvm.util

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * @author Kshitij Kumar
 */

class CustomBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}
package com.asynclabs.githubpersonalapplication.ui.main

import com.asynclabs.githubpersonalapplication.ui.base.BaseContract

class MainContract {
    interface View : BaseContract.View {
        fun initUI()
        fun hideProgressBar()
        fun showProgressBar()
        fun animateSceneToStart()
        fun animateSceneToEnd()
        fun onGitRepoResultsReady()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onItemClicked(item: Any)
    }
}
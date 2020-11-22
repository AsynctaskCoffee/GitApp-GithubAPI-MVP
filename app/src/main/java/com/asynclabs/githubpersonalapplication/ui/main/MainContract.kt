package com.asynclabs.githubpersonalapplication.ui.main

import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BaseContract

class MainContract {
    interface View : BaseContract.View {
        fun initUI()
        fun hideProgressBar()
        fun showProgressBar()
        fun animateSceneToStart()
        fun animateSceneToEnd()
        fun onGitRepoResultsReady(repoList: List<RepoResponse>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onItemClicked(item: Any)
    }
}
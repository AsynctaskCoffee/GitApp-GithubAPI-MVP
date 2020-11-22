package com.asynclabs.githubpersonalapplication.ui.detail

import com.asynclabs.githubpersonalapplication.data.remotemodels.ReadmeResponse
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BaseContract

class DetailContract {
    interface View : BaseContract.View {
        fun hideProgressBar()
        fun showProgressBar()
        fun onGitRepoResultReady(repoResponse: RepoResponse)
        fun onGitReadmeResultReady(readmeResponse: ReadmeResponse)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onStarClicked(item: RepoResponse)
    }
}
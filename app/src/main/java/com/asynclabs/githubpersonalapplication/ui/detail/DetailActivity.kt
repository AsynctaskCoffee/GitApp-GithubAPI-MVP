package com.asynclabs.githubpersonalapplication.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.tiagohm.markdownview.css.styles.Github
import com.asynclabs.githubpersonalapplication.R
import com.asynclabs.githubpersonalapplication.data.remotemodels.ReadmeResponse
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BaseActivity
import com.like.LikeButton
import com.like.OnLikeListener
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.delay
import javax.inject.Inject

class DetailActivity : BaseActivity<DetailContract.View, DetailContract.Presenter>(),
    DetailContract.View {

    var userName = ""
    var repoName = ""
    var repoResponse: RepoResponse? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent != null && intent.hasExtra("userName") && intent.hasExtra("repoName")) {
            repoName = intent.extras?.getString("repoName", "").toString()
            userName = intent.extras?.getString("userName", "").toString()
            detailsPresenter.fetchReadmeDetail(userName, repoName)
            detailsPresenter.fetchRepositoryDetail(userName, repoName)
        } else {
            finish()
        }
    }

    @Inject
    lateinit var detailsPresenter: DetailPresenter

    override fun initPresenter() = detailsPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.activity_detail

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    override fun onGitRepoResultReady(repoResponse: RepoResponse) {
        this.repoResponse = repoResponse
        txtGitUserName?.text = (repoResponse.owner?.login ?: "") + " / "
        txtRepoName?.text = repoResponse.name ?: ""
        txtRepoDesc?.text = repoResponse.description ?: "No description provided yet"
        txtLicenseName?.text = repoResponse.license?.name ?: "None"
        txtForkCount?.text = (repoResponse.forksCount ?: "0").toString() + " forks"
        txtWatchCountAct?.text = (repoResponse.watchersCount ?: "0").toString()
        txtStarCount?.text = (repoResponse.stargazersCount ?: "0").toString() + " stars"
        txtStarCountAct?.text = (repoResponse.stargazersCount ?: "0").toString()
        txtIssuesCount?.text = "Issues " + (repoResponse.openIssuesCount ?: "0").toString()
        starButton?.isLiked = repoResponse.isFav()
        starButton?.setOnLikeListener(object : OnLikeListener {
            override fun liked(likeButton: LikeButton?) {
                detailsPresenter.onStarClicked(repoResponse)
            }

            override fun unLiked(likeButton: LikeButton?) {
                detailsPresenter.onStarClicked(repoResponse)
            }

        })
    }

    override fun onGitReadmeResultReady(readmeResponse: ReadmeResponse) {
        markdownView?.setEscapeHtml(true)
        markdownView?.addStyleSheet(Github())
        markdownView?.loadMarkdownFromUrl(readmeResponse.downloadUrl)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
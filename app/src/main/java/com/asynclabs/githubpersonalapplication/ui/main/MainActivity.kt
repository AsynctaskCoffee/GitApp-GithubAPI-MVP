package com.asynclabs.githubpersonalapplication.ui.main

import android.content.Intent
import android.view.View
import android.widget.Toast
import com.asynclabs.githubpersonalapplication.R
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BaseActivity
import com.asynclabs.githubpersonalapplication.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View,
    MainAdapter.ClickListener {

    var observedPosition = -1

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun initPresenter() = mainPresenter

    override fun injectDependencies() = getApplicationComponent().inject(this)

    override fun getLayoutResId() = R.layout.activity_main

    override fun initUI() {
    }

    override fun hideProgressBar() {
        progressBar?.visibility = View.INVISIBLE
    }

    override fun showProgressBar() {
        lostFocus()
        progressBar?.visibility = View.VISIBLE
    }

    override fun animateSceneToStart() {
        hideProgressBar()
        motionLayout?.transitionToStart()
    }

    override fun animateSceneToEnd() {
        hideProgressBar()
        motionLayout?.transitionToEnd()
    }

    override fun onGitRepoResultsReady(repoList: List<RepoResponse>) {
        edtGitUserName.isEnabled = false
        recyclerViewRepo.adapter = MainAdapter(repoList, this)
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        txtErrorMsg?.visibility = View.VISIBLE
        txtErrorMsg?.text = msg
    }

    fun fetchData(view: View) {
        if (edtGitUserName.text.isNotBlank())
            mainPresenter.fetchRepositoryDetails(edtGitUserName.text.toString())
        else showToast("UserName cannot be empty")
    }


    override fun onClick(repoResponse: RepoResponse, observedPosition: Int) {
        this.observedPosition = observedPosition
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("repoName", repoResponse.name)
        intent.putExtra("userName", repoResponse.owner?.login)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        if (observedPosition != -1)
            recyclerViewRepo?.adapter?.notifyItemChanged(observedPosition)
                .also { observedPosition = -1 }
    }

    override fun onStarClick(repoResponse: RepoResponse) {
        mainPresenter.onStarClicked(repoResponse)
    }
}
package com.asynclabs.githubpersonalapplication.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.asynclabs.githubpersonalapplication.R
import com.asynclabs.githubpersonalapplication.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

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
        progressBar?.visibility = View.VISIBLE
    }

    override fun animateSceneToStart() {
        motionLayout?.transitionToStart()
    }

    override fun animateSceneToEnd() {
        motionLayout?.transitionToEnd()
    }

    override fun onGitRepoResultsReady() {
    }

    override fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        txtErrorMsg?.visibility = View.VISIBLE
        txtErrorMsg?.text = msg
    }
}
package com.asynclabs.githubpersonalapplication.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import butterknife.ButterKnife
import com.asynclabs.GitApp

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> :
    AppCompatActivity(), BaseContract.View {

    protected var presenter: P? = null
    protected var hasSavedInstance: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hasSavedInstance = savedInstanceState != null
        setContentView(getLayoutResId())
        ButterKnife.bind(this)
        injectDependencies()
        val viewModel: BaseViewModel<V, P> = ViewModelProvider(this).get(BaseViewModel<V, P>()::class.java)
        val isCreated = viewModel.presenter == null
        viewModel.presenter = viewModel.presenter ?: initPresenter()
        presenter = viewModel.presenter
        presenter?.attachView(this as V)
        presenter?.onSavedInstance(hasSavedInstance)
        if (isCreated) presenter?.onPresenterCreated()
        presenter?.onCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStarted()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResumed()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPaused()
    }

    override fun handleLongPress(): Boolean {
        return false
    }

    fun getApplicationComponent() = (application as GitApp).applicationComponent

    protected abstract fun initPresenter(): P

    protected abstract fun injectDependencies()

    protected abstract fun getLayoutResId(): Int
}
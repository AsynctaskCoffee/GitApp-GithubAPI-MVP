package com.asynclabs.githubpersonalapplication.ui.base

interface BaseContract {

    interface View {
        fun handleLongPress(): Boolean?
        fun showToast(msg: String)
    }

    interface Presenter<V : View> {

        fun getView(): V?

        fun attachView(view: V)

        fun detachView()

        fun onPresenterCreated()

        fun onPresenterDestroyed()

        fun onCreated()

        fun onStarted()

        fun onResumed()

        fun onDestroyed()

        fun onStopped()

        fun onPaused()

        fun onUserInteraction()

        fun onBackPressed(): Boolean

        fun onSavedInstance(hasSavedInstance: Boolean)
    }
}
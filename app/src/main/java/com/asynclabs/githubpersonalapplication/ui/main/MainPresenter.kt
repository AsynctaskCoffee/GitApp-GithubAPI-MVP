package com.asynclabs.githubpersonalapplication.ui.main

import com.asynclabs.githubpersonalapplication.data.DataRepository
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private val dataRepository: DataRepository) :
    BasePresenter<MainContract.View>(), MainContract.Presenter {
    override fun onItemClicked(item: Any) {

    }

    fun fetchRepositoryDetails(userName: String) {
        disposables?.addAll(
            dataRepository.getRepoList(userName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    getView()?.showProgressBar()
                }.doFinally {
                    getView()?.hideProgressBar()
                }.subscribeWith(object : DisposableSingleObserver<List<RepoResponse>>() {
                    override fun onSuccess(t: List<RepoResponse>) {
                        if (t.isNotEmpty()) {
                            getView()?.animateSceneToEnd()
                            getView()?.onGitRepoResultsReady(t)
                        } else {
                            getView()?.showToast("User has no repository yet")
                            getView()?.hideProgressBar()
                        }
                    }

                    override fun onError(e: Throwable) {
                        getView()?.showToast(e.toString())
                        getView()?.hideProgressBar()
                    }

                })
        )
    }
}
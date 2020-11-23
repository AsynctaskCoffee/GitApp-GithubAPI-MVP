package com.asynclabs.githubpersonalapplication.ui.detail

import com.asynclabs.githubpersonalapplication.data.DataRepository
import com.asynclabs.githubpersonalapplication.data.remotemodels.ReadmeResponse
import com.asynclabs.githubpersonalapplication.data.remotemodels.RepoResponse
import com.asynclabs.githubpersonalapplication.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class DetailPresenter @Inject constructor(private val dataRepository: DataRepository) :
    BasePresenter<DetailContract.View>(), DetailContract.Presenter {

    fun fetchRepositoryDetail(userName: String, repoName: String) {
        disposables?.addAll(
            dataRepository.getRepoDetails(userName, repoName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    getView()?.showProgressBar()
                }.doFinally {
                    getView()?.hideProgressBar()
                }.subscribeWith(object : DisposableSingleObserver<RepoResponse>() {
                    override fun onSuccess(t: RepoResponse) {
                        getView()?.onGitRepoResultReady(t)
                    }

                    override fun onError(e: Throwable) {
                        getView()?.showToast(e.toString())
                    }
                })
        )
    }

    fun fetchReadmeDetail(userName: String, repoName: String) {
        disposables?.addAll(
            dataRepository.getRepoReadmeDetails(userName, repoName)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    getView()?.showProgressBar()
                }.doFinally {
                    getView()?.hideProgressBar()
                }.subscribeWith(object : DisposableSingleObserver<ReadmeResponse>() {
                    override fun onSuccess(t: ReadmeResponse) {
                        getView()?.onGitReadmeResultReady(t)
                    }

                    override fun onError(e: Throwable) {
                        getView()?.showToast(e.toString())
                    }
                })
        )
    }

    override fun onStarClicked(item: RepoResponse) {
        if (item.id != null)
            if (dataRepository.isFav(item.id)) {
                dataRepository.removeFav(item.id)
                getView()?.showToast("Repo deleted from favList")
            } else {
                item.name?.let { dataRepository.addFav(item.id, it) }
                getView()?.showToast("Repo added into favList")
            }
    }
}
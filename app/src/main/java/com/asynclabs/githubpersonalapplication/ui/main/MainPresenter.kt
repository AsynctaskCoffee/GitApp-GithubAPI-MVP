package com.asynclabs.githubpersonalapplication.ui.main

import com.asynclabs.githubpersonalapplication.data.DataRepository
import com.asynclabs.githubpersonalapplication.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(private val dataRepository: DataRepository) :
    BasePresenter<MainContract.View>(), MainContract.Presenter {
    override fun onItemClicked(item: Any) {

    }

    fun fetchRepositoryDetails(){

    }
}
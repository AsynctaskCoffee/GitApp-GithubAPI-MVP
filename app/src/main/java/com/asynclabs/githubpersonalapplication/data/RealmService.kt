package com.asynclabs.githubpersonalapplication.data

import com.asynclabs.githubpersonalapplication.data.localmodels.FavRepoModel
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

open class RealmService @Inject constructor(private val mRealm: Realm) {
    fun closeRealm() {
        mRealm.close()
    }

    fun removeFav(itemId: Int) {
        val x: RealmResults<FavRepoModel> =
            mRealm.where(FavRepoModel::class.java).equalTo("id", itemId).findAll()
        x.deleteAllFromRealm()
    }

    fun isFav(itemId: Int) =
        mRealm.where(FavRepoModel::class.java).equalTo("id", itemId).findFirst() != null

    fun addFav(
        name: String, id: Int,
    ) {
        mRealm.executeTransactionAsync { realm ->
            val favRepoModel = FavRepoModel()
            favRepoModel.id = id
            favRepoModel.name = name
            realm.copyToRealm(favRepoModel)
        }
    }
}
package com.asynclabs.githubpersonalapplication.data

import com.asynclabs.githubpersonalapplication.data.localmodels.FavRepoModel
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

open class RealmService @Inject constructor(private val mRealm: Realm) {
    fun closeRealm() {
        mRealm.close()
    }

    fun removeFav(itemId: String) {
        mRealm.executeTransaction {
            val x: RealmResults<FavRepoModel> =
                it.where(FavRepoModel::class.java).equalTo("id", itemId).findAll()
            x.deleteAllFromRealm()
        }

    }

    fun isFav(itemId: String) =
        mRealm.where(FavRepoModel::class.java).equalTo("id", itemId).findAll().size > 0

    fun addFav(
        name: String, id: String,
    ) {
        mRealm.executeTransaction { realm ->
            val favRepoModel = FavRepoModel()
            favRepoModel.id = id
            favRepoModel.name = name
            realm.copyToRealm(favRepoModel)
        }
    }
}
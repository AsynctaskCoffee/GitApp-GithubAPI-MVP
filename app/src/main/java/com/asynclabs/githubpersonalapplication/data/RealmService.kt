package com.asynclabs.githubpersonalapplication.data

import io.realm.Realm
import javax.inject.Inject

open class RealmService @Inject constructor(private val mRealm: Realm) {
    fun closeRealm() {
        mRealm.close()
    }

//    val getExample: RealmResults<Any>
//        get() = mRealm.where(Any::class.java).findAll()

//    fun addExample(
//        title: String?, isbn: String?,
//        onTransactionCallback: OnTransactionCallback
//    ) {
//        mRealm.executeTransactionAsync({ realm ->
//            val any: Any = Any()
//            Any.setId(realm.where(Any::class.java).findAll().size)
//            Any.setTitle(title)
//            Any.setIsbn(isbn)
//            realm.copyToRealm(Any)
//        }, { onTransactionCallback.onRealmSuccess() }
//        ) { error -> onTransactionCallback.onRealmError(error) }
//    }

    interface OnTransactionCallback {
        fun onRealmSuccess()
        fun onRealmError(t: Throwable?)
    }
}
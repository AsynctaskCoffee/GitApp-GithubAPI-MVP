package com.asynclabs.githubpersonalapplication.data.localmodels

import io.realm.RealmObject

open class FavRepoModel(
    var name: String = "",
    var id: String = ""
) : RealmObject()
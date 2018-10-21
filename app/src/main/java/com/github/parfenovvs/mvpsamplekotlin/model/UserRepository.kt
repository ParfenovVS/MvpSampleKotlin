package com.github.parfenovvs.mvpsamplekotlin.model

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val api: ServerApi) {

  init {
    Timber.e("UserRepository created")
  }

  fun getUsers(): List<User> {
    val users = mutableListOf<User>()
    for (i in 0..10) {
      users.add(api.getUser())
    }
    return users
  }

}
package com.github.parfenovvs.mvpsamplekotlin.model

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import timber.log.Timber
import javax.inject.Singleton

interface ServerApi {

  fun getUser(): User

}

class MockServerApi : ServerApi {

  init {
    Timber.e("MockServerApi created")
  }

  override fun getUser(): User {
    return User("Mock Name", "Mock Email");
  }

}
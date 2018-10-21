package com.github.parfenovvs.mvpsamplekotlin.ui.list

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.model.UserRepository
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter
import javax.inject.Inject
import timber.log.Timber
import javax.inject.Singleton

@Singleton
class UsersPresenter @Inject constructor(
    private val repository: UserRepository
): BasePresenter<UsersView>() {

  init {
    Timber.e("UsersPresenter created")
  }

  override fun onAttach() {
    val users = repository.getUsers()
    view?.showData(users)
  }

  fun onItemClick(user: User) {
    view?.showDetails(user)
  }
}
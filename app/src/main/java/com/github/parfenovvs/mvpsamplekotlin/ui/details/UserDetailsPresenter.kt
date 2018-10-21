package com.github.parfenovvs.mvpsamplekotlin.ui.details

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter
import javax.inject.Inject

class UserDetailsPresenter @Inject constructor(
    private val user: User
): BasePresenter<UserDetailsView>() {

  override fun onAttach() {
    view?.showUser(user)
  }
}
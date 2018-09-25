package com.github.parfenovvs.mvpsamplekotlin.ui.details

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter

class SimpleDetailsPresenter(
    private val user: User
): BasePresenter<SimpleDetailsView>() {

  override fun onAttach() {
    view?.showUser(user)
  }
}
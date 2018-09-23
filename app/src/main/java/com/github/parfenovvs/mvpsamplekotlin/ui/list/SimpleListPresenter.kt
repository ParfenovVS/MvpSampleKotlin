package com.github.parfenovvs.mvpsamplekotlin.ui.list

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter

class SimpleListPresenter: BasePresenter<SimpleListView>() {

  override fun onAttach() {
    val users = listOf(
        User("Vova", "vvv@gmail.com"),
        User("Eugene", "eugene@gmail.com")
    )

    view?.showData(users)
  }
}
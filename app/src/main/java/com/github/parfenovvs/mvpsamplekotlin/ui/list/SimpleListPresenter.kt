package com.github.parfenovvs.mvpsamplekotlin.ui.list

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter
import com.github.parfenovvs.mvpsamplekotlin.ui.details.InitialDataHolder

class SimpleListPresenter: BasePresenter<SimpleListView>() {

  override fun onAttach() {
    val users = listOf(
        User("Vova", "vvv@gmail.com"),
        User("Eugene", "eugene@gmail.com")
    )

    view?.showData(users)
  }

  fun onItemClick(user: User) {
    InitialDataHolder.user = user
    view?.showDetails()
  }
}
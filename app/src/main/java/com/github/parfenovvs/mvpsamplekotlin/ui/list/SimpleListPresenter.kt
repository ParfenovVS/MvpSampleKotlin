package com.github.parfenovvs.mvpsamplekotlin.ui.list

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.model.UserRepository
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BasePresenter
import com.github.parfenovvs.mvpsamplekotlin.ui.details.InitialDataHolder
import javax.inject.Inject

class SimpleListPresenter @Inject constructor(
    private val repository: UserRepository
//...
): BasePresenter<SimpleListView>() {

  override fun onAttach() {
    val users = repository.getUsers()
    view?.showData(users)
  }

  fun onItemClick(user: User) {
    InitialDataHolder.user = user
    view?.showDetails()
  }
}
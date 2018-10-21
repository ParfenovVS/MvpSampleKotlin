package com.github.parfenovvs.mvpsamplekotlin.ui.list

import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseView

interface UsersView : BaseView {
  fun showData(items: List<User>)
  fun showDetails(user: User)
}
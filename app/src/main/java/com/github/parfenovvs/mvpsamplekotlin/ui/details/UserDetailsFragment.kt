package com.github.parfenovvs.mvpsamplekotlin.ui.details

import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.di.UsersComponent
import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user_details.emailTextView
import kotlinx.android.synthetic.main.fragment_user_details.nameTextView

class UserDetailsFragment : BaseFragment<UserDetailsView, UserDetailsPresenter>(), UserDetailsView {
  lateinit var component: UsersComponent

  override fun layoutId(): Int {
    return R.layout.fragment_user_details
  }

  override fun providePresenter(): UserDetailsPresenter {
    return component.detailsPresenter()
  }

  override fun showUser(user: User) {
    nameTextView.text = user.name
    emailTextView.text = user.email
  }
}
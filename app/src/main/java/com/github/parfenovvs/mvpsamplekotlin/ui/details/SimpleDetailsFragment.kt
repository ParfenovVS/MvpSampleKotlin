package com.github.parfenovvs.mvpsamplekotlin.ui.details

import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_simple_details.emailTextView
import kotlinx.android.synthetic.main.fragment_simple_details.nameTextView

class SimpleDetailsFragment : BaseFragment<SimpleDetailsView, SimpleDetailsPresenter>(), SimpleDetailsView {
  override fun layoutId(): Int {
    return R.layout.fragment_simple_details
  }

  override fun providePresenter(): SimpleDetailsPresenter {
    return SimpleDetailsPresenter(checkNotNull(InitialDataHolder.user))
  }

  override fun showUser(user: User) {
    nameTextView.text = user.name
    emailTextView.text = user.email
  }
}
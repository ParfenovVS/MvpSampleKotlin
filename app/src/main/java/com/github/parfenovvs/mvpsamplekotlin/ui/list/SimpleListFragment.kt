package com.github.parfenovvs.mvpsamplekotlin.ui.list

import android.os.Bundle
import android.view.View
import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.entity.User
import com.github.parfenovvs.mvpsamplekotlin.ui.base.BaseFragment

class SimpleListFragment : BaseFragment<SimpleListView, SimpleListPresenter>(), SimpleListView {

  override fun layoutId(): Int {
    return R.layout.fragment_simple_list
  }

  override fun providePresenter(): SimpleListPresenter {
    return SimpleListPresenter()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }

  override fun showData(items: List<User>) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
  
}
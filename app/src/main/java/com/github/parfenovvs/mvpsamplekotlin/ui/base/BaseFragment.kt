package com.github.parfenovvs.mvpsamplekotlin.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : Fragment() {
  protected var presenter: P? = null
    private set

  private lateinit var key: String

  abstract fun layoutId(): Int

  protected abstract fun providePresenter(): P

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(layoutId(), container, false)
  }

  override fun onStart() {
    super.onStart()
    attachPresenter(this as V)
  }

  private fun attachPresenter(view: V) {
    val presenter = providePresenter()
    presenter.attachView(view)
    this.presenter = presenter
  }

  override fun onStop() {
    presenter?.detachView()
    super.onStop()
  }
}
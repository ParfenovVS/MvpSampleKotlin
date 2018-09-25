package com.github.parfenovvs.mvpsamplekotlin.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    key = view::class.java.name
    val presenter: P
    if (PresentersHolder.presenters.contains(key)) {
      presenter = PresentersHolder.presenters[key] as P
      Timber.e("Presenter ${checkNotNull(presenter)::class.java.simpleName} restored")
    } else {
      presenter = providePresenter()
      PresentersHolder.presenters[key] = presenter
      Timber.e("Presenter ${checkNotNull(presenter)::class.java.simpleName} created")
    }

    presenter.attachView(view)
    this.presenter = presenter
  }

  override fun onStop() {
    presenter?.detachView()
    super.onStop()
  }

  override fun onDestroyView() {
    Timber.e("Presenter ${checkNotNull(presenter)::class.java.simpleName} removed")
    PresentersHolder.presenters.remove(key)
    super.onDestroyView()
  }
}

private object PresentersHolder {
  val presenters = mutableMapOf<String, Any>()
}
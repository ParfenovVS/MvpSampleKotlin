package com.github.parfenovvs.mvpsamplekotlin.ui.base

import java.lang.ref.WeakReference

abstract class BasePresenter<V : BaseView> {
  private var viewRef: WeakReference<V>? = null
  private var firstAttach = true

  val view: V?
    get() = viewRef?.get()

  internal fun attachView(view: V) {
    viewRef = WeakReference(view)
    if (firstAttach) {
      onFirstAttach()
      firstAttach = false
    }
    onAttach()
  }

  internal fun detachView() {
    onDetach()
    viewRef?.clear()
  }

  protected open fun onFirstAttach() {}

  protected open fun onAttach() {}

  protected open fun onDetach() {}
}

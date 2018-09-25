package com.github.parfenovvs.mvpsamplekotlin

import android.app.Application
import timber.log.Timber

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    Timber.plant(Timber.DebugTree())
  }

}
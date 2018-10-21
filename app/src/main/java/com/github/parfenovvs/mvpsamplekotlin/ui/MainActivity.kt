package com.github.parfenovvs.mvpsamplekotlin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.parfenovvs.mvpsamplekotlin.R
import com.github.parfenovvs.mvpsamplekotlin.di.DaggerUsersComponent
import com.github.parfenovvs.mvpsamplekotlin.di.ServerApiModule
import com.github.parfenovvs.mvpsamplekotlin.ui.list.UsersFragment


class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    if (savedInstanceState == null) {
      val fragment = UsersFragment()
      fragment.component = DaggerUsersComponent.builder()
          .serverApiModule(ServerApiModule())
          .build()
      supportFragmentManager.beginTransaction()
          .add(R.id.container, fragment)
          .commitAllowingStateLoss()
    }
  }

}
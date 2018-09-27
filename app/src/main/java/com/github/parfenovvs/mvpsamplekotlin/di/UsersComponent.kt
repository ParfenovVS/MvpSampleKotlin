package com.github.parfenovvs.mvpsamplekotlin.di

import com.github.parfenovvs.mvpsamplekotlin.model.UserRepository
import com.github.parfenovvs.mvpsamplekotlin.ui.list.SimpleListPresenter
import dagger.Component
import javax.inject.Singleton


@Component(modules = [ServerApiModule::class])
interface UsersComponent {
  fun listPresenter(): SimpleListPresenter
}
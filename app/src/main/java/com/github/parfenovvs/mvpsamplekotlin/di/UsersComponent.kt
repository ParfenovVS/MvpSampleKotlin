package com.github.parfenovvs.mvpsamplekotlin.di

import com.github.parfenovvs.mvpsamplekotlin.ui.details.UserDetailsPresenter
import com.github.parfenovvs.mvpsamplekotlin.ui.list.UsersPresenter
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ServerApiModule::class])
interface UsersComponent {
  fun presenter(): UsersPresenter
  fun detailsPresenter(): UserDetailsPresenter
}
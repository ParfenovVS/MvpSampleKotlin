package com.github.parfenovvs.mvpsamplekotlin.di

import com.github.parfenovvs.mvpsamplekotlin.model.MockServerApi
import com.github.parfenovvs.mvpsamplekotlin.model.ServerApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ServerApiModule {

  @Singleton
  @Provides
  fun provideServerApi(): ServerApi {
    return MockServerApi()
  }

}
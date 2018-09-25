package com.github.parfenovvs.mvpsamplekotlin.ui.details

import com.github.parfenovvs.mvpsamplekotlin.entity.User


/*
Минусы:
1. Область видимости и существования зависимостей глобальная
2. Зависимость остается в памяти, пока не занулим ссылку
3. Доступ к зависимостям глобальный
4. Нужно помнить о том, что зависимости необходимо сетить
 */
object InitialDataHolder {
  var user: User? = null
}
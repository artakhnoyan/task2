package com.art.user

class DataProvider {
    fun requestUser(id: Int): UserModel = when (id) {
        1 -> UserModel.NewUser(mapOf("name" to "Gags", "age" to 13))
        2 -> UserModel.OnlyName(name = "Maga")
        else -> UserModel.Empty
    }
}
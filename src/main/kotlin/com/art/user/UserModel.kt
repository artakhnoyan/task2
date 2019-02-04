package com.art.user

sealed class UserModel {
    class NewUser(val userMap: Map<String, Any>) : UserModel()
    object Empty : UserModel()
    data class OnlyName(val name: String) : UserModel()
}

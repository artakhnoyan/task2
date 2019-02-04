package com.art.user

interface UserRepository {
    fun getUser(id: Int) : UserEntity
}
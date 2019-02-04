package com.art.user

class UserUseCase(private val userRepository: UserRepository) {
    fun getUser(id: Int): UserEntity {
        return userRepository.getUser(id)
    }
}
package com.art.user

class UserPresenter(private val userUseCase: UserUseCase) {
    fun showAllUsers(userCount: Int) {
        for (id in 1..userCount) {
            printUser(id)
        }
    }

    private fun getUser(id: Int): UserEntity = userUseCase.getUser(id)

    private fun printUser(id: Int) = println(getUser(id))
}
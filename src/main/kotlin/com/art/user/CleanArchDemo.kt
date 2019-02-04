package com.art.user

//Using args: Array<String> is not a must for latest kotlin version
fun main() {
    val presenter = UserPresenter(UserUseCase(UserRepositoryImpl()))
    presenter.showAllUsers(userCount = 3)
}
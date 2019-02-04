package com.art.user

class UserRepositoryImpl : UserRepository {
    private val dataProvider: DataProvider = DataProvider()

    override fun getUser(id: Int): UserEntity {
        val user = dataProvider.requestUser(id)
        return when (user) {
            is UserModel.NewUser -> mapToUserEntity(user.userMap)
            is UserModel.OnlyName -> initUserWithName(user.name)
            else -> UserEntity("Empty", -1)
        }
    }

    private fun initUserWithName(name: String): UserEntity = UserEntity(name = name)

    private fun mapToUserEntity(userMap: Map<String, Any>): UserEntity =
            UserEntity(userMap["name"] as String, userMap["age"] as Int)
}
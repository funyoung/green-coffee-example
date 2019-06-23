package com.mauriciotogneri.greencoffeeexample.database

import com.mauriciotogneri.greencoffeeexample.model.User
import java.util.*

class UserDatabase {

    fun isValid(username: String, password: String): Boolean {
        for (user in USERS) {
            if (user.matches(username, password)) {
                return true
            }
        }

        return false
    }

    companion object {
        val USER_1 = User("admin", "1234")
        val USER_2 = User("guest", "qwerty")
        val USER_3 = User("root", "11111")

        // 替换java的Arrays.asList为 listOf
        private val USERS = ArrayList(listOf(USER_1, USER_2, USER_3))
    }
}
package com.mauriciotogneri.greencoffeeexample.model

class User(private val username: String, private val password: String) {

    fun username(): String {
        return username
    }

    fun password(): String {
        return password
    }

    fun hasUsername(username: String): Boolean {
        return this.username == username
    }

    fun matches(username: String, password: String): Boolean {
        return this.username == username && this.password == password
    }
}
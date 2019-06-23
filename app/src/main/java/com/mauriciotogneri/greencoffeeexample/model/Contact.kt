package com.mauriciotogneri.greencoffeeexample.model

import android.content.Context

import com.mauriciotogneri.greencoffeeexample.R

class Contact(private val id: String, private val firstName: String,
              private val lastName: String, private val age: Int?,
              private val weight: Double?, private val married: Boolean?) {

    fun hasId(id: String): Boolean {
        return this.id == id
    }

    fun id(): String {
        return id
    }

    fun name(): String {
        return String.format("%s %s", firstName, lastName)
    }

    fun age(): String {
        return age!!.toString()
    }

    fun weight(): String {
        return String.format("%s kg.", weight)
    }

    // convert from java with build error about if (married), ->
    // if (this!!.married!!)
    fun married(context: Context): String {
        return if (this!!.married!!) context.getString(R.string.contacts_married_yes) else context.getString(R.string.contacts_married_no)
    }
}
package com.mauriciotogneri.greencoffeeexample.database

import com.mauriciotogneri.greencoffeeexample.model.Contact

import java.util.ArrayList

class ContactDatabase {

    // 用 when 代替 if... else if... else
    // listOf 代替 Arrays.asList
    fun contacts(username: String): List<Contact> {
        return when {
            UserDatabase.USER_1.hasUsername(username) -> ArrayList(listOf(CONTACT_1, CONTACT_3, CONTACT_5, CONTACT_7, CONTACT_9))
            UserDatabase.USER_2.hasUsername(username) -> ArrayList(listOf(CONTACT_2, CONTACT_4, CONTACT_6, CONTACT_8, CONTACT_10))
            else -> ArrayList()
        }
    }

    fun contact(contactId: String): Contact {
        for (contact in CONTACTS) {
            if (contact.hasId(contactId)) {
                return contact
            }
        }

        throw RuntimeException()
    }

    companion object {
        private val CONTACT_1 = Contact("1", "John", "Smith", 42, 81.2, true)
        private val CONTACT_2 = Contact("2", "Martha", "Phillips", 30, 65.7, false)
        private val CONTACT_3 = Contact("3", "Freddie", "James", 55, 78.8, true)
        private val CONTACT_4 = Contact("4", "Megan", "Woodard", 49, 73.0, true)
        private val CONTACT_5 = Contact("5", "Jack", "Baxter", 28, 71.4, false)
        private val CONTACT_6 = Contact("6", "Amelia", "Harrison", 22, 62.7, false)
        private val CONTACT_7 = Contact("7", "Thomas", "Wolfe", 40, 77.2, true)
        private val CONTACT_8 = Contact("8", "Rebecca", "Rees", 60, 74.5, true)
        private val CONTACT_9 = Contact("9", "James", "Houghton", 31, 76.9, true)
        private val CONTACT_10 = Contact("10", "Maddison", "Wallace", 25, 71.6, false)

        // listOf 代替 Arrays.asList
        private val CONTACTS = ArrayList(listOf(CONTACT_1, CONTACT_2, CONTACT_3, CONTACT_4, CONTACT_5, CONTACT_6, CONTACT_7, CONTACT_8, CONTACT_9, CONTACT_10))
    }
}
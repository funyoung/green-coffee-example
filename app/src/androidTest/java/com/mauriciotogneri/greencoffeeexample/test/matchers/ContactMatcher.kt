package com.mauriciotogneri.greencoffeeexample.test.matchers

import com.mauriciotogneri.greencoffee.interactions.DataMatcher
import com.mauriciotogneri.greencoffeeexample.model.Contact

class ContactMatcher(resourceId: Int) : DataMatcher<Contact, String>(resourceId, Contact::class.java) {

    override fun matches(contact: Contact, content: String): Boolean {
        return contact.name() == content
    }
}
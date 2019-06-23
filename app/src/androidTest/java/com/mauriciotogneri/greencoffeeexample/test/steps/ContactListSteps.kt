package com.mauriciotogneri.greencoffeeexample.test.steps

import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.internal.util.Checks
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
import com.mauriciotogneri.greencoffee.interactions.DataMatcher
import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.adapters.ContactViewHolder
import com.mauriciotogneri.greencoffeeexample.model.Contact
import com.mauriciotogneri.greencoffeeexample.test.matchers.ContactMatcher

import org.hamcrest.Description
import org.hamcrest.Matcher

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.hasDescendant
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

class ContactListSteps : GreenCoffeeSteps() {
    @When("^I select the contact called '([\\w| ]+)'$")
    fun `iSelectTheContactCalled$`(username: String) {
        //DataMatcher<Contact, String> dataMatcher = new ContactMatcher(R.id.contacts_list);
        //dataMatcher.with(username).click();
        onView(withId(R.id.contacts_list)).perform(RecyclerViewActions.actionOnHolderItem(withItemSubject(username), click()))
    }

    @Then("^I see an empty contact list$")
    fun iSeeAnEmptyContactList() {
        onViewWithText(R.string.contacts_emptyList).isDisplayed
    }

    @Then("^I see the contacts screen$")
    fun iSeeTheContactsScreen() {
        onViewWithText(R.string.contacts_title).isDisplayed
    }

    companion object {

        // http://androidcookie.com/espressorecyclerview.html
        fun withItemSubject(subject: String): Matcher<RecyclerView.ViewHolder> {
            Checks.checkNotNull(subject)
            return object : BoundedMatcher<RecyclerView.ViewHolder, ContactViewHolder>(ContactViewHolder::class.java) {
                override fun matchesSafely(viewHolder: ContactViewHolder): Boolean {
                    val subjectTextView = viewHolder.itemView.findViewById<TextView>(R.id.contact_name)
                    return subject == subjectTextView.text.toString() && subjectTextView.visibility == View.VISIBLE
                }

                override fun describeTo(description: Description) {
                    description.appendText("item with subject: $subject")
                }
            }
        }
    }

}
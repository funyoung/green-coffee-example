package com.mauriciotogneri.greencoffeeexample.test.steps;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps;
import com.mauriciotogneri.greencoffee.annotations.Then;
import com.mauriciotogneri.greencoffee.annotations.When;
import com.mauriciotogneri.greencoffee.interactions.DataMatcher;
import com.mauriciotogneri.greencoffeeexample.R;
import com.mauriciotogneri.greencoffeeexample.adapters.ContactViewHolder;
import com.mauriciotogneri.greencoffeeexample.model.Contact;
import com.mauriciotogneri.greencoffeeexample.test.matchers.ContactMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ContactListSteps extends GreenCoffeeSteps
{
    @When("^I select the contact called '([\\w| ]+)'$")
    public void iSelectTheContactCalled$(String username)
    {
        //DataMatcher<Contact, String> dataMatcher = new ContactMatcher(R.id.contacts_list);
        //dataMatcher.with(username).click();
        onView(withId(R.id.contacts_list)).perform(RecyclerViewActions.actionOnHolderItem(withItemSubject(username), click()));
    }

    @Then("^I see an empty contact list$")
    public void iSeeAnEmptyContactList()
    {
        onViewWithText(R.string.contacts_emptyList).isDisplayed();
    }

    @Then("^I see the contacts screen$")
    public void iSeeTheContactsScreen()
    {
        onViewWithText(R.string.contacts_title).isDisplayed();
    }

    // http://androidcookie.com/espressorecyclerview.html
    public static Matcher<RecyclerView.ViewHolder> withItemSubject(final String subject) {
        Checks.checkNotNull(subject);
        return new BoundedMatcher<RecyclerView.ViewHolder, ContactViewHolder>(ContactViewHolder.class) {
            @Override protected boolean matchesSafely(ContactViewHolder viewHolder) {
                TextView subjectTextView = viewHolder.itemView.findViewById(R.id.contact_name);
                return ((subject.equals(subjectTextView.getText().toString()) && (subjectTextView.getVisibility() == View.VISIBLE)));
            }

            @Override public void describeTo(Description description) {
                description.appendText("item with subject: " + subject);
            }
        };
    }

}
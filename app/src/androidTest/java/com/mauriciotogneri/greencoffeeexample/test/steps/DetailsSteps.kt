package com.mauriciotogneri.greencoffeeexample.test.steps

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffeeexample.R

class DetailsSteps : GreenCoffeeSteps() {
    @Then("^I see the detail screen for '([\\w| ]+)'$")
    fun `iSeeTheDetailScreenFor$`(username: String) {
        onViewWithText(username).isDisplayed
    }

    @Then("^I see his name is '([\\w| ]+)'$")
    fun iSeeHisHerNameIs(name: String) {
        onViewWithId(R.id.contact_detail_name).contains(name)
    }

    @Then("^I see his age is (\\d+)$")
    fun iSeeHisHerAgeIs(age: Int) {
        onViewWithId(R.id.contact_detail_age).contains(age)
    }

    @Then("^I see his weight is (\\d+\\.?\\d+ kg.)$")
    fun iSeeHisHerWeightIs(weight: String) {
        onViewWithId(R.id.contact_detail_weight).contains(weight)
    }

    @Then("^I see he is (single|married)$")
    fun iSeeHeIsSingleMarried(status: String) {
        when (status) {
            "single" -> onViewWithId(R.id.contact_detail_married).contains(string(R.string.contacts_married_no))

            "married" -> onViewWithId(R.id.contact_detail_married).contains(string(R.string.contacts_married_yes))

            else -> throw RuntimeException()
        }
    }
}
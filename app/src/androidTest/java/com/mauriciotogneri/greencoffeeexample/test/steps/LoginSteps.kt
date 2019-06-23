package com.mauriciotogneri.greencoffeeexample.test.steps

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.database.UserDatabase

class LoginSteps : GreenCoffeeSteps() {

    @Given("^I see an empty login form$")
    fun iSeeAnEmptyLoginForm() {
        onViewWithId(R.id.login_input_username).isEmpty
        onViewWithId(R.id.login_input_password).isEmpty
    }

    @Given("^I login as (\\w+)$")
    fun `iLoginAs$`(user: String) {
        when (user) {
            "USER_1" -> {
                onViewWithId(R.id.login_input_username).type(UserDatabase.USER_1.username())
                onViewWithId(R.id.login_input_password).type(UserDatabase.USER_1.password())
            }

            "USER_2" -> {
                onViewWithId(R.id.login_input_username).type(UserDatabase.USER_2.username())
                onViewWithId(R.id.login_input_password).type(UserDatabase.USER_2.password())
            }

            "USER_3" -> {
                onViewWithId(R.id.login_input_username).type(UserDatabase.USER_3.username())
                onViewWithId(R.id.login_input_password).type(UserDatabase.USER_3.password())
            }

            else -> throw RuntimeException()
        }

        onViewWithId(R.id.login_button_doLogin).click()
    }

    @When("^I press the login button$")
    fun iPressTheLoginButton() {
        onViewWithId(R.id.login_button_doLogin).click()
    }

    @When("^I introduce a valid username$")
    fun iIntroduceAValidUsername() {
        onViewWithId(R.id.login_input_username).type(UserDatabase.USER_1.username())
    }

    @When("^I introduce a valid password$")
    fun iIntroduceAValidPassword() {
        onViewWithId(R.id.login_input_password).type(UserDatabase.USER_1.password())
    }

    @When("^I introduce an invalid username$")
    fun iIntroduceAnInvalidUsername() {
        onViewWithId(R.id.login_input_username).type(INVALID_USERNAME)
    }

    @When("^I introduce an invalid password$")
    fun iIntroduceAnInvalidPassword() {
        onViewWithId(R.id.login_input_password).type(INVALID_PASSWORD)
    }

    @When("^I introduce as username (.+)$")
    fun iIntroduceAsUsername(username: String) {
        onViewWithId(R.id.login_input_username).type(username)
    }

    @When("^I introduce as password (.+)$")
    fun iIntroduceAsPassword(password: String) {
        onViewWithId(R.id.login_input_password).type(password)
    }

    @Then("^I see an error message saying 'Invalid username'$")
    fun iSeeAnErrorMessageSayingInvalidUsername() {
        onViewWithText(R.string.login_username_error).isDisplayed
    }

    @Then("^I see an error message saying 'Invalid password'$")
    fun iSeeAnErrorMessageSayingInvalidPassword() {
        onViewWithText(R.string.login_password_error).isDisplayed
    }

    @Then("^I see an error message saying 'Invalid credentials'$")
    fun iSeeAnErrorMessageSayingInvalidCredentials() {
        onViewWithText(R.string.login_credentials_error).isDisplayed
    }

    companion object {
        private val INVALID_USERNAME = "guest"
        private val INVALID_PASSWORD = "5678"
    }
}
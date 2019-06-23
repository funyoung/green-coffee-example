package com.mauriciotogneri.greencoffeeexample.test.steps

import android.support.test.InstrumentationRegistry

import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.Then

import java.io.File

class ScreenshotSteps : GreenCoffeeSteps() {
    @Then("^I take a screenshot named '(\\w+)'$")
    fun iSeeAnEmptyLoginForm(name: String) {
        val fileName = String.format("%s/%s.jpg", locale(), name)
        val file = File(InstrumentationRegistry.getTargetContext().getExternalFilesDir("screenshots"), fileName)
        takeScreenshot(file)
    }
}
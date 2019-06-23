package com.mauriciotogneri.greencoffeeexample.test

import com.mauriciotogneri.greencoffeeexample.test.features.ContactListFeatureTest
import com.mauriciotogneri.greencoffeeexample.test.features.DetailsFeatureTest
import com.mauriciotogneri.greencoffeeexample.test.features.LoginFeatureTest

import org.junit.runner.RunWith
import org.junit.runners.Suite

import java.util.Locale

@RunWith(Suite::class)
@Suite.SuiteClasses(LoginFeatureTest::class,
        ContactListFeatureTest::class,
        DetailsFeatureTest::class)
object TestSuite {
    val ENGLISH = Locale("en", "GB")
    val SPANISH = Locale("es", "ES")
}
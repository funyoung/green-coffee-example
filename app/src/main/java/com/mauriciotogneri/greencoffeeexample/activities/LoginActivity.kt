package com.mauriciotogneri.greencoffeeexample.activities

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.EditText

import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.database.UserDatabase

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)
        setTitle(R.string.login_title)

        // lambada 表达式只有1个参数可省略，用 it 访问
        findViewById<View>(R.id.login_button_doLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.login_input_username)
            val password = findViewById<EditText>(R.id.login_input_password)

            login(username.text.toString(), password.text.toString())
        }
    }

    private fun login(username: String, password: String) {
        if (validForm(username, password)) {
            if (validCredentials(username, password)) {
                startActivity(ContactListActivity.create(this, username))
                finish()
            } else {
                errorDialog(R.string.login_credentials_error)
            }
        }
    }

    private fun validForm(username: String, password: String): Boolean {
        if (TextUtils.isEmpty(username)) {
            errorDialog(R.string.login_username_error)

            return false
        } else if (TextUtils.isEmpty(password)) {
            errorDialog(R.string.login_password_error)

            return false
        }

        return true
    }

    private fun validCredentials(username: String, password: String): Boolean {
        val userDatabase = UserDatabase()

        return userDatabase.isValid(username, password)
    }

    private fun errorDialog(message: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setTitle(message)
        builder.setPositiveButton(R.string.dialog_button_ok, null)
        builder.show()
    }
}
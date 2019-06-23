package com.mauriciotogneri.greencoffeeexample.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.adapters.ContactAdapter
import com.mauriciotogneri.greencoffeeexample.database.ContactDatabase
import com.mauriciotogneri.greencoffeeexample.model.Contact

class ContactListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_contacts)
        setTitle(R.string.contacts_title)

        val username = intent.getStringExtra(PARAMETER_USERNAME)

        val contactDatabase = ContactDatabase()
        val contacts = contactDatabase.contacts(username)

        val listView = findViewById<RecyclerView>(R.id.contacts_list)

        if (!contacts.isEmpty()) {
            val adapter = ContactAdapter(this, contacts)
            adapter.setOnItemClickListener(View.OnClickListener {
                val contact = it.tag as Contact
                onContactSelected(contact)
            })
            listView.adapter = adapter
        } else {
            listView.visibility = View.GONE

            val labelEmptyList = findViewById<TextView>(R.id.contacts_label_emptyList)
            labelEmptyList.visibility = View.VISIBLE
        }
    }

    private fun onContactSelected(contact: Contact) {
        startActivity(DetailsActivity.create(this, contact.id()))
    }

    companion object {
        private val PARAMETER_USERNAME = "parameter.username"

        fun create(context: Context, username: String): Intent {
            val intent = Intent(context, ContactListActivity::class.java)
            intent.putExtra(PARAMETER_USERNAME, username)

            return intent
        }
    }
}
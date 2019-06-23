package com.mauriciotogneri.greencoffeeexample.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.model.Contact

// 类成员声明时就可以用构造函数的参数进行初始化，简洁
class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val firstName: TextView = view.findViewById(R.id.contact_name)
    private val age: TextView = view.findViewById(R.id.contact_age)
    private val weight: TextView = view.findViewById(R.id.contact_weight)
    private val married: TextView = view.findViewById(R.id.contact_married)

    fun bind(contact: Contact) {
        itemView.tag = contact
        firstName.text = contact.name()
        age.text = contact.age()
        weight.text = contact.weight()
        married.text = contact.married(itemView.context)
    }
}

package com.mauriciotogneri.greencoffeeexample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mauriciotogneri.greencoffeeexample.R;
import com.mauriciotogneri.greencoffeeexample.model.Contact;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView age;
    private TextView weight;
    private TextView married;

    public ContactViewHolder(@NonNull View view) {
        super(view);

        firstName = view.findViewById(R.id.contact_name);
        age = view.findViewById(R.id.contact_age);
        weight = view.findViewById(R.id.contact_weight);
        married = view.findViewById(R.id.contact_married);
    }

    public void bind(Contact contact) {
        itemView.setTag(contact);
        firstName.setText(contact.name());
        age.setText(contact.age());
        weight.setText(contact.weight());
        married.setText(contact.married(itemView.getContext()));
    }
}

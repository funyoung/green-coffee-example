package com.mauriciotogneri.greencoffeeexample.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mauriciotogneri.greencoffeeexample.R;
import com.mauriciotogneri.greencoffeeexample.model.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private final Context context;
    private final List<Contact> contacts;

    private View.OnClickListener mOnClickListener;

    private final LayoutInflater layoutInflater;

    public ContactAdapter(Context context, List<Contact> contacts)
    {
        //super(context, R.layout.row_contact, contacts);
        this.context = context;
        this.contacts = contacts;
        this.layoutInflater = LayoutInflater.from(context);
    }

//    @Override
//    @NonNull
//    public View getView(int position, View convertView, @NonNull ViewGroup parent)
//    {
//        View view = convertView;
//
//        if (view == null)
//        {
//            view = layoutInflater.inflate(R.layout.row_contact, null, false);
//        }
//
//        Contact contact = getItem(position);
//
//        if (contact != null)
//        {
//            TextView firstName = view.findViewById(R.id.contact_name);
//            firstName.setText(contact.name());
//
//            TextView age = view.findViewById(R.id.contact_age);
//            age.setText(contact.age());
//
//            TextView weight = view.findViewById(R.id.contact_weight);
//            weight.setText(contact.weight());
//
//            TextView married = view.findViewById(R.id.contact_married);
//            married.setText(contact.married(context));
//        }
//
//        return view;
//    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.row_contact, null, false);
        view.setOnClickListener(mOnClickListener);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder viewHolder, int i) {
        viewHolder.bind(contacts.get(i));
    }

    public void setOnItemClickListener(View.OnClickListener clickListener) {
        mOnClickListener = clickListener;
    }


    @Override
    public int getItemCount() {
        return null == contacts ? 0 : contacts.size();
    }

}
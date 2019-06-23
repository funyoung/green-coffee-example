package com.mauriciotogneri.greencoffeeexample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mauriciotogneri.greencoffeeexample.R
import com.mauriciotogneri.greencoffeeexample.model.Contact

class ContactAdapter(context: Context, private val contacts: List<Contact>?) : RecyclerView.Adapter<ContactViewHolder>() {

    private var mOnClickListener: View.OnClickListener? = null

    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)

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

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ContactViewHolder {
        val view = layoutInflater.inflate(R.layout.row_contact, null, false)
        view.setOnClickListener(mOnClickListener)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ContactViewHolder, i: Int) {
        viewHolder.bind(contacts!![i])
    }

    fun setOnItemClickListener(clickListener: View.OnClickListener) {
        mOnClickListener = clickListener
    }


    override fun getItemCount(): Int {
        return contacts?.size ?: 0
    }

}
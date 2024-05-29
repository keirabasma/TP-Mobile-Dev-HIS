package hk.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private ArrayList<Contact> contactList;
    private LayoutInflater inflater;
    private int resource;

    public ContactAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, contacts);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.resource = resource;
        this.contactList = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = inflater.inflate(resource, parent, false);
        }

        Contact contact = contactList.get(position);

        TextView nameTextView = v.findViewById(R.id.fullName);
        TextView numberTextView = v.findViewById(R.id.number);

        nameTextView.setText(contact.getName() +" "+ contact.getFname());
        numberTextView.setText(contact.getNumber());

        return v;
    }

    public int getCount(){
        return contactList.size();
    }
}

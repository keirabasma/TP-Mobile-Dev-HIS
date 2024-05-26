package com.example.contacts_mustapha;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contacts_mustapha.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> mylist = new ArrayList<>();
        mylist.add(new Contact("Mustapha", "Bouchene", "0566328465"));
        mylist.add(new Contact("Omar", "Boutan", "0654213985"));
        mylist.add(new Contact("Fatima", "Onio", "0548653215"));
        mylist.add(new Contact("Kamila", "Latrech", "0548653215"));

        ListView lv = findViewById(R.id.listep);
        ContactAdapter myAdapter = new ContactAdapter(this, R.layout.contact_lay, mylist);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Contact selectedContact = mylist.get(position);


                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", selectedContact.name);
                intent.putExtra("lastname", selectedContact.lastname);
                //intent.putExtra("name", "000");
               // intent.putExtra("lastname", "222");
              //  intent.putExtra("phone", selectedContact.phone);

                startActivity(intent);
            }
        });
    }

    public class Contact {
        public String name;
        public String lastname;
        public String phone;

        public Contact(String name, String lastname, String phone){
            this.name = name;
            this.lastname = lastname;
            this.phone = phone;
        }
    }

    public class ContactAdapter extends ArrayAdapter<Contact> {
        ArrayList<Contact> contactlist;
        LayoutInflater inflat;
        int Rc;

        public ContactAdapter(MainActivity c, int resource, ArrayList<Contact> L) {
            super(c, resource, L);
            inflat = LayoutInflater.from(c);
            Rc = resource;
            contactlist = L;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null)
                v = inflat.inflate(Rc, null);
            TextView tvName = v.findViewById(R.id.name);
            TextView tvPrenom = v.findViewById(R.id.lastname);
            tvName.setText(contactlist.get(position).name);
            tvPrenom.setText(contactlist.get(position).lastname);
            return v;
        }















    }
}

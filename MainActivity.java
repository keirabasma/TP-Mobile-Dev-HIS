package com.example.contacte;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private ArrayList<Contact> contactList;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView contactListView = findViewById(R.id.contactListView);
        contactList = new ArrayList<>();
        contactList.add(new Contact("nom1", "prenom1", "123456789"));
        contactList.add(new Contact("nom2", "prenom2", "123456789"));
        contactList.add(new Contact("nom3", "prenom3", "123456789"));

        contactAdapter = new ContactAdapter(this, R.layout.contact_item, contactList);
        contactListView.setAdapter(contactAdapter);


        contactListView.setOnItemClickListener((parent, view, position, id) -> {
            Contact selectedContact = contactList.get(position);
            Intent intent = new Intent(MainActivity.this, activity_contact_detail.class);
            intent.putExtra("contact" ," " +selectedContact);
            startActivity(intent);
        });

    }
    }



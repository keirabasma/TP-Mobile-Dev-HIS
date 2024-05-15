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
        contactList.add(new Contact("nom1", "prenom1", "123456"));
        contactList.add(new Contact("nom2", "prenom2", "123456"));
        contactList.add(new Contact("nom3", "prenom3", "123456"));
        contactList.add(new Contact("nom4", "prenom4", "123456"));
        contactList.add(new Contact("nom5", "prenom5", "123456"));
        contactList.add(new Contact("nom6", "prenom6", "123456"));
        contactList.add(new Contact("nom7", "prenom7", "123456"));
        contactList.add(new Contact("nom8", "prenom8", "123456"));
        contactList.add(new Contact("nom9", "prenom9", "123456"));
        contactList.add(new Contact("nom10", "prenom10", "123456"));
        contactList.add(new Contact("nom11", "prenom11", "123456"));
        contactList.add(new Contact("nom12", "prenom12", "123456"));

        contactAdapter = new ContactAdapter(this, R.layout.contact_item, contactList);
        contactListView.setAdapter(contactAdapter);
        contactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contactList.get(position);
                Intent intent = new Intent(MainActivity.this, activity_contact_detail.class);
                intent.putExtra("contact", selectedContact);
                startActivity(intent);
            }
        });
    }

    }




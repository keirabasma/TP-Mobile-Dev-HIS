package com.example.liste;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Contact> contactList;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        ListView listView = findViewById(R.id.contactListView);

        contactList.add(new Contact("nom1", "prenom1", "123456"));
        contactList.add(new Contact("nom2", "prenom2", "123456"));
        contactList.add(new Contact("nom3", "prenom3", "123456"));
        contactList.add(new Contact("nom4", "prenom4", "123456"));
        contactList.add(new Contact("nom5", "prenom5", "123456"));

        adapter = new ContactAdapter(this, R.layout.contact, contactList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contactList.get(position);
                Intent intent = new Intent(MainActivity.this, detailactivity.class);
                intent.putExtra("contact", selectedContact);
                startActivity(intent);
            }
        });
    }

}

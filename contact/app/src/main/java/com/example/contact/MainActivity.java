package com.example.contact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Contact> contactList;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.simpleListView);
        contactList = new ArrayList<>();

        // Add dummy contacts
        contactList.add(new Contact("Ahmed", "ait", "123456789", R.drawable.ic_launcher_foreground));
        contactList.add(new Contact("lyna", "chebbab", "987654321", R.drawable.ic_launcher_foreground));

        contactAdapter = new ContactAdapter(this, R.layout.contact_lay, contactList);
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                intent.putExtra("contact", contactList.get(position));
                startActivity(intent);
            }
        });
    }
}

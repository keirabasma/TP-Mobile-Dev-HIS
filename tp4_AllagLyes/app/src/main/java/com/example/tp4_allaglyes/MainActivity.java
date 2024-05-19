package com.example.tp4_allaglyes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewContacts;
    private ArrayList<Contact> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Contact> myContacts = new ArrayList<>();
        myContacts.add(new Contact("test1", "test1", "1111111111111"));
        myContacts.add(new Contact("test2", "test2", "2222222222222"));
        myContacts.add(new Contact("test3", "test3", "3333333333333"));

        ContactAdapter myAdapter = new ContactAdapter(this, R.layout.activity_contact, myContacts);

        ListView lv = findViewById(R.id.listep);

        lv.setAdapter(myAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Contact selectedContact = myContacts.get(position);
                Intent intent = new Intent(MainActivity.this, ListItemActivity1.class);
                intent.putExtra("contact", selectedContact);
                startActivity(intent);
            }
        });

    }
}

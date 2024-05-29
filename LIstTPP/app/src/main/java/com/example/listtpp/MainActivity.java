package com.example.listtpp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> contactList;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Abdou Luis", "0553999373"));
        contactList.add(new Contact("Youssra Noubli", "0774335623"));
        contactList.add(new Contact("Lyna Annou", "0563556373"));
        contactList.add(new Contact("Mouna Chebbab", "0777735623"));

        recyclerView = findViewById(R.id.recycler_view_contacts);
        adapter = new ContactAdapter(contactList, new ContactAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Contact contact) {
                Toast.makeText(MainActivity.this, "Clic sur " + contact.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}


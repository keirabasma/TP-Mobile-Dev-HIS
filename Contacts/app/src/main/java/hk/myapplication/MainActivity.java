package hk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import hk.myapplication.Contact;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        listView = findViewById(R.id.listView);



        contacts = new ArrayList<>();
        contacts.add(new Contact("John","Doe", "123456789"));
        contacts.add(new Contact("Jane", "Smith", "987654321"));
        contacts.add(new Contact("Sam", "Johnson", "555555555"));
        contacts.add(new Contact("John", "Doe", "123456789"));
        contacts.add(new Contact("Jane", "Smith", "987654321"));
        contacts.add(new Contact("Sam", "Johnson", "555555555"));
        contacts.add(new Contact("Mike", "Brown", "111222333"));
        contacts.add(new Contact("Emily", "Davis", "444555666"));
        contacts.add(new Contact("Anna", "Wilson", "777888999"));
        contacts.add(new Contact("Robert", "Moore", "000111222"));
        contacts.add(new Contact("Laura", "Taylor", "333444555"));
        contacts.add(new Contact("David", "Anderson", "666777888"));
        contacts.add(new Contact("Sophia", "Thomas", "999000111"));
        contacts.add(new Contact("James", "Jackson", "222333444"));
        ContactAdapter adapter = new ContactAdapter(this, R.layout.list_item, contacts);
        listView.setAdapter(adapter);


        // Set an item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectedContact = contacts.get(position);

                // Start the ContactDetailActivity and pass the contact details
                Intent intent = new Intent(MainActivity.this, ContactDetailActivity.class);
                intent.putExtra("name", selectedContact.getName()+" "+ selectedContact.getFname());
                intent.putExtra("number", selectedContact.getNumber());
                startActivity(intent);
            }
        });






    }
}
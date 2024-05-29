package com.example.contact;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class ContactDetailActivity extends AppCompatActivity {
    private EditText firstNameEditText, lastNameEditText, phoneNumberEditText;
    private Button saveButton;
    private String contactName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        phoneNumberEditText = findViewById(R.id.phone_number);
        saveButton = findViewById(R.id.save_button);

        contactName = getIntent().getStringExtra("CONTACT_NAME");
        loadContactDetails(contactName);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContactDetails();
            }
        });
    }

    private void loadContactDetails(String contactName) {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " = ?",
                new String[]{contactName}, null);

        if (cursor != null && cursor.moveToFirst()) {
            String firstName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            firstNameEditText.setText(firstName);
            phoneNumberEditText.setText(phoneNumber);
            cursor.close();
        }
    }

    private void saveContactDetails() {
        String newFirstName = firstNameEditText.getText().toString();
        String newPhoneNumber = phoneNumberEditText.getText().toString();

        ContentValues values = new ContentValues();
        values.put(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, newFirstName);
        values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, newPhoneNumber);

        getContentResolver().update(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                values,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " = ?",
                new String[]{contactName});
    }
}

package hk.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        ImageView photoImageView = findViewById(R.id.photo);
        TextView nameTextView = findViewById(R.id.fullname);
        TextView numberTextView = findViewById(R.id.number);

        // Get the intent and extract the contact details
        Intent intent = getIntent();
        String fullname = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");

        // Set the contact details
        photoImageView.setImageResource(R.drawable.avatar); // Set a static photo
        nameTextView.setText(fullname);
        numberTextView.setText(number);
    }
}
